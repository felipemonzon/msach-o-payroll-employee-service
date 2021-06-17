package com.rinku.payroll.employee.service.business;

import com.rinku.payroll.employee.service.client.RoleClient;
import com.rinku.payroll.employee.service.model.request.Rol;
import com.rinku.payroll.employee.service.service.RolService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author Felipe Monzón
 * @date 15 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
@Service
@RequiredArgsConstructor
public class RolBusiness implements RolService {
  /**
   * Cliente para consumir el servicio de roles.
   */
  private final RoleClient rolClient;

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Rol> retrieve(HttpHeaders headers) {
    return this.rolClient.retrieve(headers);
  }
}
