package com.rinku.payroll.employee.service.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rinku.payroll.employee.service.constant.LogConstant;
import com.rinku.payroll.employee.service.exception.custom.CustomFeignException;
import com.rinku.payroll.employee.service.exception.custom.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

/**
 * Decodificacion de errores de feing.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
  /**
   * Respuesta de base de feing.
   */
  private final ErrorDecoder errorDecoder = new ErrorDecoder.Default();
  /**
   * Propiedad para el status.
   */
  private static final String STATUS_PROPERTY = "status";
  /**
   * Propiedad para la ruta.
   */
  private static final String PATH_PROPERTY = "path";
  /**
   * Propiedad para el error.
   */
  private static final String ERROR_PROPERTY = "error";
  /**
   * Propiedad para el mensaje.
   */
  private static final String MESSAGE_PROPERTY = "message";
  /**
   * Respuesta no estandarizada.
   */
  private static final String NOT_STANDART_RESPONSE =
      "Respuesta de un Servicio no Estandarizado {}";

  /**
   * decodifica error de feing.
   */
  @Override
  public Exception decode(String methodKey, Response response) {
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    ErrorResponse errorResponse = null;

    log.info(LogConstant.ERROR_CODE_FEIGN, HttpStatus.valueOf(response.status()));
    if (response.body() == null) {
      return errorDecoder.decode(methodKey, response);
    }

    try {
      JsonNode rootNode = mapper.readTree(response.body().toString());

      if (rootNode.has(STATUS_PROPERTY)) {
        log.debug(NOT_STANDART_RESPONSE, rootNode);
        errorResponse = this.mapperResponse(rootNode);
      } else {
        errorResponse = mapper.readValue(response.body().toString(), ErrorResponse.class);
      }
    } catch (JsonProcessingException e) {
      log.info(LogConstant.ERROR_BODY_PARSE);
      log.error(e.getMessage(), e);
      return errorDecoder.decode(methodKey, response);
    }

    return new CustomFeignException(response.status(), errorResponse);
  }

  /**
   * Mapea una respuesta diferente al estandar.
   * 
   * @param rootNode respuesta recibida de la peticion
   * @return respuesta estandarizada {@code ErrorResponse}
   * @throws JsonProcessingException
   * @throws JsonMappingException
   */
  private ErrorResponse mapperResponse(final JsonNode rootNode) throws JsonProcessingException {
    return ErrorResponse.builder().code(rootNode.get(STATUS_PROPERTY).toString())
        .type(ExceptionManagment.ErrorType.FATAL.name())
        .location(this.convertNodeToString(rootNode.get(PATH_PROPERTY)))
        .details(this.convertNodeToString(rootNode.get(ERROR_PROPERTY)))
        .moreInfo(this.convertNodeToString(rootNode.get(MESSAGE_PROPERTY))).build();
  }

  /**
   * Convierte una propiedad del root a string
   * 
   * @param jsonNode propiedad
   * @return una cadena
   * @throws JsonProcessingException
   */
  private String convertNodeToString(final JsonNode jsonNode) throws JsonProcessingException {
    return new ObjectMapper().readValue(jsonNode.toString(), String.class);
  }
}
