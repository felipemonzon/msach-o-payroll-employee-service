package com.rinku.payroll.employee.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Respuesta para la páginacion de las entregas de empleados.
 * 
 * @author Felipe Monzón
 * @date 04 jun. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DeliveryResponse extends Pagination {
  /**
   * Lista de entregas de los empleados.
   */
  List<Delivery> deliveries;
}
