package com.rinku.payroll.employee.service.business;

import com.rinku.payroll.employee.service.client.EmployeeClient;
import com.rinku.payroll.employee.service.constant.LogConstant;
import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;
import com.rinku.payroll.employee.service.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para empleados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeBusiness implements EmployeeService {
  /**
   * Cliente para consultar el servicio de empleados.
   */
  private final EmployeeClient employeeClient;

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Employee> getEmployees(HttpHeaders headers) {
    log.info(LogConstant.EMPLOYEES_RETREVE);
    return this.employeeClient.retrieve(headers);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public EmployeeResponse getEmployees(HttpHeaders headers, int pageNumber) {
    log.info(LogConstant.EMPLOYEES_PAGINATION, pageNumber);
    return this.employeeClient.retrieve(headers, pageNumber);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void saveEmployee(HttpHeaders headers, EmployeeRequest request) {
    log.debug(LogConstant.REQUEST, request.toString());
    this.employeeClient.save(headers, request);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void replaceEmployee(HttpHeaders headers, Employee request, long id) {
    log.debug(LogConstant.EMPLOYEE_UPDATE_DATA_REQUEST, request.toString(), id);
    this.employeeClient.update(headers, request, id);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Employee> searchBy(HttpHeaders headers, final String search) {
    log.debug(LogConstant.EMPLOYEE_SEARCH_BY);
    return this.employeeClient.searchBy(headers, search);
  }
}
