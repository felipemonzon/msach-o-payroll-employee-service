package com.rinku.payroll.employee.service.service;

import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Servicio para empleados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public interface EmployeeService {
  /**
   * Consulta todos los empleados.
   * 
   * @param headers cabeceras de consumo
   * @return una lista de {@code Employee}
   */
  List<Employee> getEmployees(HttpHeaders headers);

  /**
   * Consulta una lista paginada de los empleados.
   * 
   * @param headers cabeceras de consumo
   * @param pageNumber numero de pagina
   * @return una objeto de tipo {@code EmployeeResponse}
   */
  EmployeeResponse getEmployees(HttpHeaders headers, int pageNumber);

  /**
   * Guarda un empleado.
   * 
   * @param headers cabeceras de consumo
   * @param request objeto de tipo {@code EmployeeRequest}
   */
  void saveEmployee(HttpHeaders headers, EmployeeRequest request);

  /**
   * Actualiza un empleado.
   * 
   * @param headers cabeceras de consumo
   * @param request objeto de tipo {@code Employee}
   * @param id identificador del empleado
   */
  void replaceEmployee(HttpHeaders headers, Employee request, long id);

  /**
   * Consulta un empleado por una opcion.
   * 
   * @param headers cabeceras necesarias para consumo
   * @param search parametro de busqueda
   * @return lista de tipo encontrado
   */
  List<Employee> searchBy(HttpHeaders headers, final String search);
}
