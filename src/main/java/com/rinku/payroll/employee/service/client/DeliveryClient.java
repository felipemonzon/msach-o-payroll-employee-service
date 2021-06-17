package com.rinku.payroll.employee.service.client;

import com.rinku.payroll.employee.service.constant.ApiConstant;
import com.rinku.payroll.employee.service.constant.RoutesConstant;
import com.rinku.payroll.employee.service.model.request.DeliveryRequest;
import com.rinku.payroll.employee.service.model.request.DeliverySaveResponse;
import com.rinku.payroll.employee.service.model.response.Delivery;
import com.rinku.payroll.employee.service.model.response.DeliveryResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.Valid;

/**
 * Cliente feign para consumir servicio de entregas
 * 
 * @author Felipe Monzón
 * @since 4 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
@FeignClient(name = RoutesConstant.DELIVERY_MANAGEMENT_NAME,
    url = RoutesConstant.DELIVERY_MANAGEMENT_SERVICE_PATH)
public interface DeliveryClient {
  /**
   * Ejecuta API para consultar todos las entregas.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @return una lista de tipo {@code Delivery}
   */
  @GetMapping(path = RoutesConstant.DELIVERY_MANAGEMENT_RETRIEVE_SERVICE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  List<Delivery> retrieve(@RequestHeader HttpHeaders headers);

  /**
   * Ejecuta API para consultar una pagina de todas las entregas.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @return una pagina de tipo {@code DeliveryResponse}
   */
  @GetMapping(path = RoutesConstant.DELIVERY_MANAGEMENT_PAGINATION_SERVICE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  DeliveryResponse retrieve(@RequestHeader HttpHeaders headers, @RequestParam int page);

  /**
   * Ejecuta API para consultar una entrega por folio o por empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @return una lista de tipo {@code Delivery}
   */
  @GetMapping(path = RoutesConstant.DELIVERY_MANAGEMENT_SEARCH_SERVICE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  List<Delivery> searchBy(@RequestHeader HttpHeaders headers,
      @PathVariable(name = ApiConstant.PARAM_OPTION) String opc,
      @PathVariable(name = ApiConstant.PARAM_VALUE) String value);

  /**
   * Registra las entregas diarias de un empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   *        <ul>
   *        <li>Accept.</li>
   *        <li>Authorization.</li>
   *        <li>uuid.</li>
   *        </ul>
   * @param request datos de la entrega {@code DeliveryRequest}
   * @return folio de registro
   */
  @PostMapping(path = RoutesConstant.DELIVERY_MANAGEMENT_SAVE_SERVICE_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  DeliverySaveResponse saveDelivery(@RequestHeader HttpHeaders headers,
      @RequestBody @Valid DeliveryRequest request);
}
