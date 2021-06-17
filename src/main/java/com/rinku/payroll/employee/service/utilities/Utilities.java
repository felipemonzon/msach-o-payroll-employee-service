package com.rinku.payroll.employee.service.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilidades para el servicio de nomina de rinku.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
public abstract class Utilities {
  /**
   * Formato de salida de la respuesta de error.
   */
  public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
  /**
   * Formato fecha para sentencias SQL.
   */
  public static final String DATETIME_FORMAT_SLASH_SQL = "yyyy/MM/dd HH:mm";
  /**
   * Formato de salida de la respuesta de error.
   */
  public static final String ERROR_DATE_PATTER = "yyyy-MM-dd HH:mm:ss";

  /**
   * Convierte una fecha a cadena
   * 
   * @param dateTime fecha en formato {@link LocalDateTime}
   * @param pattern formato nuevo de la fecha
   * @return la fecha con formato dado
   */
  public static String convertDateTimeToString(LocalDateTime dateTime, String pattern) {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern));
  }

  /**
   * Constructor de la clase.
   */
  private Utilities() {}
}
