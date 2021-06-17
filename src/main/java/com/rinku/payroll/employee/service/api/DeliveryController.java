package com.rinku.payroll.employee.service.api;

import com.rinku.payroll.employee.service.constant.ApiConstant;
import com.rinku.payroll.employee.service.constant.RoutesConstant;
import com.rinku.payroll.employee.service.exception.custom.ErrorResponse;
import com.rinku.payroll.employee.service.model.request.DeliveryRequest;
import com.rinku.payroll.employee.service.model.request.DeliverySaveResponse;
import com.rinku.payroll.employee.service.model.response.Delivery;
import com.rinku.payroll.employee.service.model.response.DeliveryResponse;
import com.rinku.payroll.employee.service.service.DeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Controlador para las entregas de los empleados.
 * 
 * @author Felipe Monzón
 * @date 4 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(tags = ApiConstant.API_DELIVERY)
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class DeliveryController {
  /**
   * Servicio de entregas.
   */
  private final DeliveryService deliveryService;

  /**
   * Consulta todas las entregas de los empleados.
   * 
   * @param headers cabeceras necesarias para consumo
   * @return lista de tipo {@code Delivery}
   */
  @ApiOperation(value = ApiConstant.API_TAG_DELIVERY_RETRIEVE,
      notes = ApiConstant.API_OPERATION_DELIVERY_RETRIEVE)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK, response = Delivery.class,
          responseContainer = ApiConstant.RESPONSE_CONTAINT_LIST),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.DELIVERY_RETRIEVE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Delivery>> retrieve(@RequestHeader HttpHeaders headers) {
    return ResponseEntity.ok(this.deliveryService.deliveriesRetrieve(headers));
  }

  /**
   * Consulta una pagina de las entregas de los empleados.
   * 
   * @param headers cabeceras necesarias para consumo
   * @return pagina de tipo {@code DeliveryResponse}
   */
  @ApiOperation(value = ApiConstant.API_TAG_DELIVERY_RETRIEVE,
      notes = ApiConstant.API_OPERATION_DELIVERY_RETRIEVE)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK,
          response = DeliveryResponse.class),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.DELIVERY_PAGINATION_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DeliveryResponse> retrieve(@RequestHeader HttpHeaders headers,
      @Valid @Min(value = 0) @RequestParam int page) {
    return ResponseEntity.ok(this.deliveryService.deliveriesRetrieve(headers, page));
  }

  /**
   * Busca la(s) entrega(s) diaria(s) por una opcion de busqueda.
   * 
   * @param headers cabeceras necesarias de consumo
   * @param option opcion a buscar
   * @param value valor de busqueda
   * @return una lista de tipo {@code Delivery}
   */
  @ApiOperation(value = ApiConstant.API_TAG_DELIVERY_RETRIEVE,
      notes = ApiConstant.API_OPERATION_DELIVERY_SEARCH)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK,
          response = DeliveryResponse.class),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.DELIVERY_SEARCH_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Delivery>> searchBy(@RequestHeader HttpHeaders headers,
      @Valid @NotEmpty @PathVariable(name = ApiConstant.PARAM_OPTION) String opc,
      @NotEmpty @PathVariable(name = ApiConstant.PARAM_VALUE) String value) {
    return ResponseEntity.ok(this.deliveryService.searchBy(headers, opc, value));
  }

  /**
   * 
   * @param headers
   * @param request
   * @return
   */
  @ApiOperation(value = ApiConstant.API_TAG_DELIVERY_SAVE,
      notes = ApiConstant.API_OPERATION_DELIVERY_SAVE)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK,
          response = DeliveryResponse.class),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @PostMapping(path = RoutesConstant.DELIVERY_SAVE_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DeliverySaveResponse> save(@RequestHeader HttpHeaders headers,
      @RequestBody @Valid DeliveryRequest request) {
    return ResponseEntity.ok(this.deliveryService.saveDelivery(headers, request));
  }
}
