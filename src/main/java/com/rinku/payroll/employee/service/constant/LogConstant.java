package com.rinku.payroll.employee.service.constant;

/**
 * Constantes para el log.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class LogConstant {
  /**
   * Log para la entrada de las peticiones.
   */
  public static final String REQUEST = "Request {}";
  /**
   * Log para mensaje de 404.
   */
  public static final String NO_DATA = "Dato no Encontrado.";
  /**
   * Log para consultar los empleados.
   */
  public static final String EMPLOYEES_RETREVE = "Consulta de Empleados";
  /**
   * Log para consultar los empleados.
   */
  public static final String EMPLOYEES_PAGINATION = "Consulta de Empleados, pagina {}";
  /**
   * Peticion para la api de actualizacion de empleados.
   */
  public static final String EMPLOYEE_UPDATE_DATA_REQUEST =
      "Datos de empleado a actualizar {}, identificador del empleado {}";
  /**
   * Mensaje de parseo.
   */
  public static final String ERROR_BODY_PARSE =
      "Failed to parse the playload. The format of the message does not correspond with the predefined";
  /**
   * Mensaje de error al consumir sevicio con feign.
   */
  public static final String ERROR_CODE_FEIGN = "error code {}";
  /**
   * Log para consultar todas las entregas.
   */
  public static final String DELIVERIES_RETREVE = "Consulta todas las entregas de los Empleados";
  /**
   * Log para consultar una pagina de entregas de los empleados.
   */
  public static final String DELIVERIES_PAGINATION =
      "Consulta la pagina {} de entregas diarias de empleados.";
  /**
   * Log para consultar las entregas por folio o empleado.
   */
  public static final String DELIVERIES_SEARCH_BY = "Consulta las entregas diarias de {} por {}";
  /**
   * Log para registrar las entregas de un empleado.
   */
  public static final String DELIVERY_SAVE = "Entrega a registrar {}";
  /**
   * Log para consulta un empleado.
   */
  public static final String EMPLOYEE_SEARCH_BY = "Consulta un empleado por {}";

  /**
   * Constructor de la clase.
   */
  private LogConstant() {}
}
