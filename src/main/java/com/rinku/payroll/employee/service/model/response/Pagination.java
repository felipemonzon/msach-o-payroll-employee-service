package com.rinku.payroll.employee.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Objeto de paginación.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Pagination {
  /**
   * Páginas totales.
   */
  private int totalPages;
  /**
   * Página final.
   */
  private boolean lastPage;
  /**
   * Página inicial.
   */
  private boolean firstPage;
  /**
   * Página Actual.
   */
  private int currentPage;
}
