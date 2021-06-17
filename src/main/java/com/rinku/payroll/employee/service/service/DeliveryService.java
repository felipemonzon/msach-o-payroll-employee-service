package com.rinku.payroll.employee.service.service;

import com.rinku.payroll.employee.service.model.request.DeliveryRequest;
import com.rinku.payroll.employee.service.model.request.DeliverySaveResponse;
import com.rinku.payroll.employee.service.model.response.Delivery;
import com.rinku.payroll.employee.service.model.response.DeliveryResponse;

import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Servicio para las entregas de los empleados.
 * 
 * @author Felipe Monzón
 * @date 4 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
public interface DeliveryService {
  /**
   * Consulta todas las entregas.
   * 
   * @param headers cabeceras requeridas para consumo
   * @return una lista de tipo {@code Delivery}
   */
  List<Delivery> deliveriesRetrieve(HttpHeaders headers);

  /**
   * Consulta una pagina de las entregas diarias de los empleados.
   * 
   * @param headers cabeceras requeridas para consumo
   * @param pageNumber número de página
   * @return
   */
  DeliveryResponse deliveriesRetrieve(HttpHeaders headers, int pageNumber);

  /**
   * Busca la(s) entrega(s) diaria(s) por una opcion de busqueda.
   * 
   * @param headers cabeceras necesarias de consumo
   * @param option opcion a buscar
   * @param value valor de busqueda
   * @return una lista de tipo {@code Delivery}
   */
  List<Delivery> searchBy(HttpHeaders headers, String option, String value);

  /**
   * Registra las entregas de un empleado.
   * 
   * @param headers cabeceras necesarias de consumo
   * @param request peticion de tipo {@code DeliveryRequest}
   * @return folio del registro
   */
  DeliverySaveResponse saveDelivery(HttpHeaders headers, DeliveryRequest request);
}
