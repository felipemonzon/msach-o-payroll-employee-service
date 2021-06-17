package com.rinku.payroll.employee.service.constant;

/**
 * Constantes de rutas.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class RoutesConstant {
  /**
   * Ruta base del proyecto.
   */
  public static final String BASE_PATH = "${api.uri.basePath}";
  /**
   * Identificador de consumo del servicio de empleados.
   */
  public static final String EMPLOYEE_MANAGEMENT_NAME = "${feign.employeeManagement.name}";
  /**
   * Ruta base para el serviciod de empleados.
   */
  public static final String EMPLOYEE_MANAGEMENT_PATH = "${feign.employeeManagement.url}";
  /**
   * Ruta para consultar los empleados.
   */
  public static final String EMPLOYEE_MANAGEMENT_RETRIEVE_PATH =
      "${feign.employeeManagement.retrieve.mapping}";
  /**
   * Ruta para consultar una pagina de los empleados.
   */
  public static final String EMPLOYEE_MANAGEMENT_PAGINATION_PATH =
      "${feign.employeeManagement.retrieve.pagintation.mapping}";
  /**
   * Ruta para guardar un empleado.
   */
  public static final String EMPLOYEE_MANAGEMENT_SAVE_PATH =
      "${feign.employeeManagement.save.mapping}";
  /**
   * Ruta para actualizar un empleado.
   */
  public static final String EMPLOYEE_MANAGEMENT_UPDATE_PATH =
      "${feign.employeeManagement.update.mapping}";
  /**
   * Ruta para consultar los datos de un empleado.
   */
  public static final String EMPLOYEE_MANAGEMENT_SEARCH_PATH =
      "${feign.employeeManagement.search.mapping}";
  /**
   * Identificador de consumo del servicio de entregas.
   */
  public static final String DELIVERY_MANAGEMENT_NAME = "${feign.deliveryManagement.name}";
  /**
   * Ruta base para el servicio de entregas.
   */
  public static final String DELIVERY_MANAGEMENT_SERVICE_PATH = "${feign.deliveryManagement.url}";
  /**
   * Ruta para consultar todas las entregas de los empleados.
   */
  public static final String DELIVERY_MANAGEMENT_RETRIEVE_SERVICE_PATH =
      "${feign.deliveryManagement.retrieve.mapping}";
  /**
   * Ruta para consultar una pagina de las entregas.
   */
  public static final String DELIVERY_MANAGEMENT_PAGINATION_SERVICE_PATH =
      "${feign.deliveryManagement.retrieve.pagintation.mapping}";
  /**
   * Ruta para guardar las entregas de un empleado.
   */
  public static final String DELIVERY_MANAGEMENT_SAVE_SERVICE_PATH =
      "${feign.deliveryManagement.save.mapping}";
  /**
   * Ruta para actualizar las entregas diarias de un empleado.
   */
  public static final String DELIVERY_MANAGEMENT_UPDATE_SERVICE_PATH =
      "${feign.deliveryManagement.update.mapping}";
  /**
   * Ruta para consultar una entrega de un empleado.
   */
  public static final String DELIVERY_MANAGEMENT_SEARCH_SERVICE_PATH =
      "${feign.deliveryManagement.search.mapping}";
  /**
   * Ruta para la consulta de datos de todos los empleados.
   */
  public static final String EMPLOYEE_DATA_RETRIEVE_PATH = "${api.uri.employees.retrieve.mapping}";
  /**
   * Ruta para guardar los datos de un empleado.
   */
  public static final String EMPLOYEE_DATA_SAVE_PATH = "${api.uri.employees.save.mapping}";
  /**
   * Ruta para actualizar los datos de un empleado.
   */
  public static final String EMPLOYEE_DATA_UPDATE_PATH = "${api.uri.employees.update.mapping}";
  /**
   * Ruta para consultar los datos de los empleados.
   */
  public static final String EMPLOYEE_DATA_PAGINATION_PATH =
      "${api.uri.employees.retrieve.pagintation.mapping}";
  /**
   * Ruta para consultar los datos de un empleado.
   */
  public static final String EMPLOYEE_DATA_SEARCH_PATH = "${api.uri.employees.search.mapping}";
  /**
   * Ruta para consultar todas las entregas.
   */
  public static final String DELIVERY_RETRIEVE_PATH = "${api.uri.delivery.retrieve.mapping}";
  /**
   * Ruta para guardar las entregas diarias de un empleado.
   */
  public static final String DELIVERY_SAVE_PATH = "${api.uri.delivery.save.mapping}";
  /**
   * Ruta para actualizar las entregas diarias de un empleado.
   */
  public static final String DELIVERY_UPDATE_PATH = "${api.uri.delivery.update.mapping}";
  /**
   * Ruta para consultar luna pagina de las entregas de los empleados.
   */
  public static final String DELIVERY_PAGINATION_PATH =
      "${api.uri.delivery.retrieve.pagintation.mapping}";
  /**
   * Ruta para consultar las entregas de los empleados por opciones.
   */
  public static final String DELIVERY_SEARCH_PATH = "${api.uri.delivery.search.mapping}";
  /**
   * Identificador de consumo del servicio de roles.
   */
  public static final String ROL_MANAGEMENT_NAME = "${feign.rolManagement.name}";
  /**
   * Ruta para consultar los roles de los empleados.
   */
  public static final String ROL_MANAGEMENT_PATH = "${feign.rolManagement.retrieve.mapping}";
  /**
   * Ruta para consultar todos los roles del empleado.
   */
  public static final String ROLE_RETRIEVE_PATH = "${api.uri.role.retrieve.mapping}";

  /**
   * Constructor de la clase.
   */
  private RoutesConstant() {}
}
