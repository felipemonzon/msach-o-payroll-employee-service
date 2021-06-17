package com.rinku.payroll.employee.service.config;

import com.rinku.payroll.employee.service.constant.PropertiesConstant;
import com.rinku.payroll.employee.service.interceptor.TimeInterceptor;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración para añadir el interceptor.
 *
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
  /**
   * Componente para medir el tiempo de la petición.
   */
  private final TimeInterceptor timeInterceptor;
  /**
   * Constantes generales de la aplicación.
   */
  private final PropertiesConstant properties;

  /**
   * Se registra el interceptor y al ruta a interceptar.
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(this.timeInterceptor)
        .addPathPatterns(this.properties.getInterceptorPath());
  }
}
