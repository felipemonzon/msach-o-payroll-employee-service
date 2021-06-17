package com.rinku.payroll.employee.service.client;

import com.rinku.payroll.employee.service.constant.ApiConstant;
import com.rinku.payroll.employee.service.constant.RoutesConstant;
import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Cliente feign para consumir servicio de empleados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@FeignClient(name = RoutesConstant.EMPLOYEE_MANAGEMENT_NAME,
    url = RoutesConstant.EMPLOYEE_MANAGEMENT_PATH)
public interface EmployeeClient {
  /**
   * Ejecuta API para consultar todos los empleados.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @return una lista de tipo {@code Employee}
   */
  @GetMapping(path = RoutesConstant.EMPLOYEE_MANAGEMENT_RETRIEVE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  List<Employee> retrieve(@RequestHeader HttpHeaders headers);

  /**
   * Ejecuta API para consultar una lista paginada de los empleados.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @param pageNumber numero de pagina
   * @return una objeto de tipo {@code EmployeeResponse}
   */
  @GetMapping(path = RoutesConstant.EMPLOYEE_MANAGEMENT_PAGINATION_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  EmployeeResponse retrieve(@RequestHeader HttpHeaders headers, @RequestParam int page);

  /**
   * Ejecuta API para guardar un empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>Content-Type.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @param employee objeto de tipo {@code EmployeeRequest}
   */
  @PostMapping(path = RoutesConstant.EMPLOYEE_MANAGEMENT_SAVE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  void save(@RequestHeader HttpHeaders headers, @RequestBody EmployeeRequest employee);

  /**
   * Ejecuta API para actualizar un empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>Content-Type.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @param employee objeto de tipo {@code Employee}
   * @param id identificador del empleado
   */
  @PutMapping(path = RoutesConstant.EMPLOYEE_MANAGEMENT_UPDATE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  void update(@RequestHeader HttpHeaders headers, @RequestBody Employee employee,
      @PathVariable long id);

  /**
   * Consulta un empleado por una opcion.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>Content-Type.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @param search parametro de busqueda
   * @return lista de tipo {@code Employee}
   */
  @GetMapping(path = RoutesConstant.EMPLOYEE_MANAGEMENT_SEARCH_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  List<Employee> searchBy(@RequestHeader HttpHeaders headers,
      @PathVariable(name = ApiConstant.PARAM_SEARCH) String search);
}
