package com.rinku.payroll.employee.service.api;

import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;
import com.rinku.payroll.employee.service.service.EmployeeService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Test del controlador.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {
  /**
   * clase a testear.
   */
  @InjectMocks
  private EmployeeController employeeController;
  /**
   * Servicio de empleados.
   */
  @Mock
  private EmployeeService employeeService;

  /**
   * Inicializa los componentes de mockito.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Consulta todos los empleados
   * 
   * @when consulta todos los empleados
   * @given headers and request
   * @then una lista de empleados
   */
  @Test
  public void employeeRetrieveTest() {
    Mockito.when(this.employeeService.getEmployees(Mockito.any()))
        .thenReturn(Arrays.asList(new Employee()));
    Assert.assertNotNull(this.employeeController.retrieve(new HttpHeaders()));
  }

  /**
   * Consulta una lista paginada de los empleados
   * 
   * @when consulta una lista paginada los empleados
   * @given headers and request
   * @then una lista de empleados
   */
  @Test
  public void employeePagintionTest() {
    Mockito.when(this.employeeService.getEmployees(Mockito.any(), Mockito.anyInt()))
        .thenReturn(new EmployeeResponse());
    Assert.assertNotNull(this.employeeController.retrieve(new HttpHeaders(), 1));
  }

  /**
   * Guarda un empleado
   * 
   * @when Guarda un empleado
   * @given headers and request
   * @then httpStatus 201
   */
  @Test
  public void employeeSaveTest() {
    Assert.assertNotNull(this.employeeController.save(new HttpHeaders(), new EmployeeRequest()));
  }

  /**
   * Actualiza un empleado
   * 
   * @when Actualiza un empleado
   * @given headers and request
   * @then httpStatus 204
   */
  @Test
  public void employeeUpdateTest() {
    Assert.assertNotNull(this.employeeController.update(new HttpHeaders(), new Employee(), 1));
  }
}
