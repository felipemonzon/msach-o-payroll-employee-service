package com.rinku.payroll.employee.service.business;

import com.rinku.payroll.employee.service.client.DeliveryClient;
import com.rinku.payroll.employee.service.constant.LogConstant;
import com.rinku.payroll.employee.service.model.request.DeliveryRequest;
import com.rinku.payroll.employee.service.model.request.DeliverySaveResponse;
import com.rinku.payroll.employee.service.model.response.Delivery;
import com.rinku.payroll.employee.service.model.response.DeliveryResponse;
import com.rinku.payroll.employee.service.service.DeliveryService;
import com.rinku.payroll.employee.service.utilities.Utilities;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio para entregas.
 * 
 * @author Felipe Monzón
 * @date 4 jun. 2021
 * @enterprise Coppel DSB III
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryBusiness implements DeliveryService {
  /**
   * Repositorio para entregas.
   */
  private final DeliveryClient deliveryClient;

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Delivery> deliveriesRetrieve(HttpHeaders headers) {
    log.info(LogConstant.DELIVERIES_RETREVE);
    return this.deliveryClient.retrieve(headers);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public DeliveryResponse deliveriesRetrieve(HttpHeaders headers, int pageNumber) {
    log.debug(LogConstant.DELIVERIES_PAGINATION, pageNumber);
    return this.deliveryClient.retrieve(headers, pageNumber);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public List<Delivery> searchBy(HttpHeaders headers, String option, String value) {
    log.debug(LogConstant.DELIVERIES_SEARCH_BY, value, option);
    return this.deliveryClient.searchBy(headers, option, value);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public DeliverySaveResponse saveDelivery(HttpHeaders headers, DeliveryRequest request) {
    request.setRegistrationDate(Utilities.convertDateTimeToString(LocalDateTime.now(),
        Utilities.DATETIME_FORMAT_SLASH_SQL));
    log.debug(LogConstant.DELIVERY_SAVE, request.toString());
    return this.deliveryClient.saveDelivery(headers, request);
  }
}
