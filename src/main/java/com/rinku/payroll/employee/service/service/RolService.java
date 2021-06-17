package com.rinku.payroll.employee.service.service;

import com.rinku.payroll.employee.service.model.request.Rol;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Servicio de roles de empleado.
 * 
 * @author Felipe Monzón
 * @date 15 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
public interface RolService {
  /**
   * Cosnulta todos los roles.
   * 
   * @param headers cabaceras necesarias para consumo
   * @return una lista de tipo {@link Rol}
   */
  List<Rol> retrieve(HttpHeaders headers);
}
