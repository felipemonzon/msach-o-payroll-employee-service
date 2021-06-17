package com.rinku.payroll.employee.service.exception.custom;

import com.rinku.payroll.employee.service.constant.ApiConstant;

import lombok.Getter;

/**
 * Excepcion para consumos de feign.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Getter
public class CustomFeignException extends RuntimeException {
  /**
   * serial de la clase.
   */
  private static final long serialVersionUID = 6644695846138055036L;
  /**
   * Http Status que se asignara.
   */
  private final int status;
  /**
   * Respuesta de error.
   */
  private final ErrorResponse errorResponse;

  /**
   * Constructor que inicializa los valores por defecto.
   */
  public CustomFeignException() {
    super();
    this.status = 0;
    this.errorResponse = null;
  }

  /**
   * Constructor que recibe el estatus Http de la respuesta y los valores de la misma.
   * 
   * @param status of the response.
   * @param errorResponse response of the error from the feign.
   */
  public CustomFeignException(int status, ErrorResponse errorResponse) {
    super(ApiConstant.EXCEPTION + status + ApiConstant.COMMA + ApiConstant.SPACE_STRING
        + errorResponse.getDetails());
    this.status = status;
    this.errorResponse = errorResponse;
  }
}
