package com.rinku.payroll.employee.service.exception;

import com.rinku.payroll.employee.service.constant.ApiConstant;
import com.rinku.payroll.employee.service.exception.custom.BadRequestException;
import com.rinku.payroll.employee.service.exception.custom.CustomFeignException;
import com.rinku.payroll.employee.service.exception.custom.ErrorResponse;
import com.rinku.payroll.employee.service.exception.custom.NoDataFoundException;

import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * Administrador de excepciones.
 *
 * @author Felipe Monzón
 * @date 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class ExceptionManagment {
  /**
   * Enumerator for errors.
   */
  public enum ErrorType {
    ERROR, WARN, INVALID, FATAL
  }

  /**
   * Maneja una excepción de tipo BadRequestException.
   *
   * @param req Objeto HttpServlet de petición.
   * @param ex Excepción recibida BadRequestException.
   * @return errorResponse Objeto de respuesta específica para BadRequestException.
   */
  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveBadRequestException(HttpServletRequest req, BadRequestException ex) {
    String moreInfo = null;

    if (ObjectUtils.isEmpty(ex.getBadFields())) {
      moreInfo = String.join(ApiConstant.COMMA, ex.getBadFields());
    }
    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).type(ErrorType.INVALID.name())
            .uuid(req.getHeader(ApiConstant.HEADER_UUID)).moreInfo(moreInfo).build();
    log.error(errorResponse.toString());

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpRequestMethodNotSupportedException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida UnauthorizedException.
   * @return errorResponse Objeto de respuesta específica para
   *         HttpRequestMethodNotSupportedException.
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public ErrorResponse resolveHttpRequestMethodNotSupportedException(HttpServletRequest req,
      HttpRequestMethodNotSupportedException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.METHOD_NOT_ALLOWED.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.INVALID.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());

    return errorResponse;

  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotAcceptableException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida HttpMediaTypeNotAcceptableException.
   * @return errorResponse Objeto de respuesta específica para HttpMediaTypeNotAcceptableException.
   */
  @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
  public ErrorResponse resolveHttpMediaTypeNotAcceptableException(HttpServletRequest req,
      HttpMediaTypeNotAcceptableException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.INVALID.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());

    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMediaTypeNotSupportedException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida HttpMediaTypeNotAcceptableException.
   * @return errorResponse Objeto de respuesta específica para HttpMediaTypeNotSupportedException.
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public ErrorResponse resolveHttpMediaTypeNotSupportedException(HttpServletRequest req,
      HttpMediaTypeNotSupportedException ex) {

    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.INVALID.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link HttpMessageNotReadableException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida HttpMessageNotReadableException.
   * @return errorResponse Objeto de respuesta específica para HttpMessageNotReadableException.
   */
  @ExceptionHandler(
      value = {HttpMessageNotReadableException.class, ConstraintViolationException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveHttpMessageNotReadableException(HttpServletRequest req,
      HttpMessageNotReadableException ex) {
    String error = Optional.ofNullable(ex.getMessage()).orElse("[:]");
    String[] message = Arrays.stream(error.split("[:]")).map(String::trim).toArray(String[]::new);

    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
            .details(message[0]).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.INVALID.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link MissingServletRequestParameterException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida MissingServletRequestParameterException.
   * @return errorResponse Objeto de respuesta específica para
   *         MissingServletRequestParameterException.
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveMissingServletRequestParameterException(HttpServletRequest req,
      MissingServletRequestParameterException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.INVALID.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@link MethodArgumentNotValidException}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida MethodArgumentNotValidException.
   * @return errorResponse Objeto de respuesta específica para MethodArgumentNotValidException.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
      MethodArgumentNotValidException ex) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

    List<String> fields = new ArrayList<>();
    Map<String, List<String>> groupedErrors = new HashMap<>();

    for (FieldError fieldError : fieldErrors) {
      String field = fieldError.getField();
      groupedErrors.computeIfAbsent(fieldError.getDefaultMessage(),
          key -> Collections.singletonList(field));
      fields.add(field);
    }
    ErrorResponse errorResponse = ErrorResponse.builder()
        .code(String.valueOf(HttpStatus.BAD_REQUEST.value())).details(groupedErrors.toString())
        .location(req.getRequestURI()).timestamp(LocalDateTime.now()).type(ErrorType.INVALID.name())
        .uuid(req.getHeader(ApiConstant.HEADER_UUID)).moreInfo(fields.toString()).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Maneja una excepción de tipo {@code NoDataFoundException} generada por no encontrar datos.
   *
   * @param req Petición
   * @param ex excepción generada por no encontrar datos
   * @return objeto de respuesta especifico para {@see NoDataFoundException}
   */
  @ExceptionHandler(NoDataFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse resolveNoDataFoundException(HttpServletRequest req,
      NoDataFoundException ex) {
    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.NOT_FOUND.value()))
            .details(ex.getMessage()).location(req.getRequestURI()).timestamp(LocalDateTime.now())
            .type(ErrorType.ERROR.name()).uuid(req.getHeader(ApiConstant.HEADER_UUID)).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo {@link Exception}.
   *
   * @param req Objeto Http Servlet de petición.
   * @param ex Excepción recibida Exception.
   * @return errorResponse Objeto de respuesta específica para Exception.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse resolveException(HttpServletRequest req, Exception ex) {
    String errorMessage = "Ocurrio un error, Intentelo mas tarde.";

    ErrorResponse errorResponse =
        ErrorResponse.builder().code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .details(errorMessage).location(req.getRequestURI()).type(ErrorType.FATAL.name())
            .uuid(req.getHeader(ApiConstant.HEADER_UUID)).timestamp(LocalDateTime.now()).build();
    log.error(errorResponse.toString());
    return errorResponse;
  }

  /**
   * Metodo para manejar una excepcion de tipo CustomFeignException.
   *
   * @param req Objeto Http Servlet de petición.
   * @param resp Objeto Http Servlet de respuesta.
   * @param ex Excepción recibida CustomFeignException.
   * @return ErrorResponse Objeto de respuesta específica para {@code CustomFeignException}
   */
  @ResponseBody
  @ExceptionHandler(CustomFeignException.class)
  public ErrorResponse resolveCustomFeignException(HttpServletRequest req, HttpServletResponse resp,
      CustomFeignException ex) {
    resp.setStatus(ex.getStatus());
    ErrorResponse errorResponse = new ModelMapper().map(ex.getErrorResponse(), ErrorResponse.class);
    errorResponse.setUuid(req.getHeader(ApiConstant.HEADER_UUID));
    log.error(errorResponse.toString());
    return errorResponse;
  }
}
