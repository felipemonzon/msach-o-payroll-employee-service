package com.rinku.payroll.employee.service.model.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Clase utilizado para las apis de empleado.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
public class EmployeeRequest {
  /**
   * Identificador principal de la peticion.
   */
  private Long idEmployee;
  /**
   * Propiedad para la matricula.
   */
  @NotEmpty
  private String employeeNumber;
  /**
   * Propiedad para el nombre.
   */
  @NotEmpty
  private String firstname;
  /**
   * Propiedad para el apellido.
   */
  @NotEmpty
  private String lastanme;
  /**
   * Propiedad para el identificador del rol.
   */
  @Min(value = 1)
  private long idRol;
  /**
   * Propiedad para el identificador del tipo de empleado.
   */
  @Min(value = 1)
  private long idType;
  /**
   * Estatus del empleado.
   */
  @Min(value = 1)
  private long idStatus;
}
