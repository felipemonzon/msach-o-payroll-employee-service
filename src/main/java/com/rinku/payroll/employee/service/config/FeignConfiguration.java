package com.rinku.payroll.employee.service.config;

import com.rinku.payroll.employee.service.exception.FeignErrorDecoder;

import feign.codec.ErrorDecoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion de feign.
 * 
 * @author Felipe Monzón
 * @since 30 may 2020
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Configuration
public class FeignConfiguration {
  /**
   * Instancia el objeto de FeignErrorDecoder.
   * 
   * @return decoder {@link FeignErrorDecoder}
   */
  @Bean
  public ErrorDecoder errorDecoder() {
    return new FeignErrorDecoder();
  }
}
