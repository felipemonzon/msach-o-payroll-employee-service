package com.rinku.payroll.employee.service.model.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Clase utilizado para las apis de empleado.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
public class Employee {
  /**
   * Identificador principal de la peticion.
   */
  private Long idEmployee;
  /**
   * Propiedad para la matricula.
   */
  private String employeeNumber;
  /**
   * Propiedad para el nombre.
   */
  private String firstname;
  /**
   * Propiedad para el apellido.
   */
  private String lastanme;
  /**
   * Propiedad para el identificador del rol.
   */
  private long idRol;
  /**
   * Salario del empleado.
   */
  private BigDecimal salary;
  /**
   * Propiedad para el identificador del tipo de empleado.
   */
  private long idType;
  /**
   * Estatus del empleado.
   */
  private long idStatus;
  /**
   * Description of the role.
   */
  private String rolDescription;
}
