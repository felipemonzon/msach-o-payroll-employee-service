package com.rinku.payroll.employee.service.business;

import com.rinku.payroll.employee.service.client.EmployeeClient;
import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;

/**
 * Test de la clase de negocio.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeBusinessTest {
  /**
   * clase a testear.
   */
  @InjectMocks
  private EmployeeBusiness employeeBusiness;
  /**
   * Servicio de empleados.
   */
  @Mock
  private EmployeeClient employeeClient;

  /**
   * Inicializa los componentes de mockito.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Consulta empleados de rinku.
   * 
   * @when consulta los empleados
   * @given cabeceras necesarias para consumo
   * @then lista de todos los empleados
   */
  @Test
  public void getEmployeesTest() {
    Mockito.when(this.employeeClient.retrieve(Mockito.any()))
        .thenReturn(Arrays.asList(new Employee()));
    Assert.assertNotNull(this.employeeBusiness.getEmployees(new HttpHeaders()));
  }

  /**
   * Consulta una lista paginada de empleados de rinku.
   * 
   * @when consulta los empleados
   * @given cabeceras necesarias para consumo y numero de pagina
   * @then lista de paginada de los empleados
   */
  @Test
  public void getEmployeesPaginationTest() {
    Mockito.when(this.employeeClient.retrieve(Mockito.any(), Mockito.anyInt()))
        .thenReturn(new EmployeeResponse());
    Assert.assertNotNull(this.employeeBusiness.getEmployees(new HttpHeaders(), 1));
  }

  /**
   * Guarda un empleado.
   * 
   * @when guarda un empleado con exito
   * @then empleado guardado con exito
   */
  @Test
  public void saveEmployeeTest() {
    this.employeeBusiness.saveEmployee(new HttpHeaders(), new EmployeeRequest());
    Assert.assertTrue(true);
  }
}
