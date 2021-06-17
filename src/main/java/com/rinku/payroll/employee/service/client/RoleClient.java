package com.rinku.payroll.employee.service.client;

import com.rinku.payroll.employee.service.constant.RoutesConstant;
import com.rinku.payroll.employee.service.model.request.Rol;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * Cliente feign para consumo de servicio de roles.
 * 
 * @author Felipe Monzón
 * @date 15 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
@FeignClient(name = RoutesConstant.ROL_MANAGEMENT_NAME,
    url = RoutesConstant.EMPLOYEE_MANAGEMENT_PATH)
public interface RoleClient {
  /**
   * Consulta todos los roles de los empleados.
   * 
   * @param headers
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @return lista de tipo {@code Rol}
   */
  @GetMapping(path = RoutesConstant.ROL_MANAGEMENT_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  List<Rol> retrieve(@RequestHeader HttpHeaders headers);
}
