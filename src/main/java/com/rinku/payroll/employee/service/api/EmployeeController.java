package com.rinku.payroll.employee.service.api;

import com.rinku.payroll.employee.service.constant.ApiConstant;
import com.rinku.payroll.employee.service.constant.RoutesConstant;
import com.rinku.payroll.employee.service.exception.custom.ErrorResponse;
import com.rinku.payroll.employee.service.model.request.EmployeeRequest;
import com.rinku.payroll.employee.service.model.response.Employee;
import com.rinku.payroll.employee.service.model.response.EmployeeResponse;
import com.rinku.payroll.employee.service.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Apis para empleados.
 * 
 * @author Felipe Monzón
 * @since 30 may. 2021
 * @enterprise Rinku Cinema
 * @version 1.0.0
 */
@Validated
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(tags = ApiConstant.API_EMPLOYEE_DATA)
@RequestMapping(path = RoutesConstant.BASE_PATH)
public class EmployeeController {
  /**
   * Servicio para empleados.
   */
  private final EmployeeService employeeService;

  /**
   * Consulta los empleados.
   * 
   * @param headers cabeceras necesarias para consumo
   * @return lista de tipo {@code Employee}
   */
  @ApiOperation(value = ApiConstant.API_TAG_EMPLOYEE_RETRIEVE,
      notes = ApiConstant.API_OPERATION_EMPLOYEE_RETRIEVE)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK, response = Employee.class,
          responseContainer = ApiConstant.RESPONSE_CONTAINT_LIST),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.EMPLOYEE_DATA_RETRIEVE_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Employee>> retrieve(@RequestHeader HttpHeaders headers) {
    return ResponseEntity.ok(this.employeeService.getEmployees(headers));
  }

  /**
   * Guarda un empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   * @param request objeto de tipo {@code Employee}
   * @return 201 si se guardo con exito
   */
  @ApiOperation(value = ApiConstant.API_OPERATION_EMPLOYEE_SAVE)
  @ApiResponses(value = {@ApiResponse(code = ApiConstant.CODE_CREATE, message = ApiConstant.CREATE),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @PostMapping(path = RoutesConstant.EMPLOYEE_DATA_SAVE_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> save(@RequestHeader HttpHeaders headers,
      @Valid @RequestBody EmployeeRequest request) {
    this.employeeService.saveEmployee(headers, request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * Guarda un empleado.
   * 
   * @param headers cabeceras necesarias para consumo
   * @param request objeto de tipo {@code Employee}
   * @return 201 si se guardo con exito
   */
  @ApiOperation(value = ApiConstant.API_OPERATION_EMPLOYEE_UPDATE)
  @ApiResponses(
      value = {@ApiResponse(code = ApiConstant.CODE_NO_CONTENT, message = ApiConstant.NO_CONTENT),
          @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
              response = ErrorResponse.class),
          @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
              response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @PutMapping(path = RoutesConstant.EMPLOYEE_DATA_UPDATE_PATH,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> update(@RequestHeader HttpHeaders headers,
      @Valid @RequestBody Employee request, @Min(value = 0) @PathVariable long id) {
    this.employeeService.replaceEmployee(headers, request, id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * API para listar todas los empleados.
   *
   * @param pageable objeto de paginación {@code Pageable}
   * @return {@code Page} paginación de los empleados
   */
  @ApiOperation(value = ApiConstant.API_OPERATION_EMPLOYEE_RETRIEVE)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK,
          response = EmployeeResponse.class),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.EMPLOYEE_DATA_PAGINATION_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeResponse> retrieve(@RequestHeader HttpHeaders headers,
      @Valid @NotNull @Min(value = 0) @RequestParam int page) {
    return ResponseEntity.ok(this.employeeService.getEmployees(headers, page));
  }

  /**
   * API para consultar un empleado por una opcion.
   *
   * @param headers cabeceras necesarias para consumo
   * @param value parametro de busqueda
   * @return empleado encontradoF
   */
  @ApiOperation(value = ApiConstant.API_OPERATION_EMPLOYEE_SEARCH)
  @ApiResponses(value = {
      @ApiResponse(code = ApiConstant.CODE_OK, message = ApiConstant.OK, response = Employee.class,
          responseContainer = ApiConstant.RESPONSE_CONTAINT_LIST),
      @ApiResponse(code = ApiConstant.CODE_BAD_REQUEST, message = ApiConstant.BAD_REQUEST,
          response = ErrorResponse.class),
      @ApiResponse(code = ApiConstant.CODE_INTERNAL_ERROR, message = ApiConstant.INTERNAL_ERROR,
          response = ErrorResponse.class)})
  @ApiImplicitParams({
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.DATE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_CHARSET),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_ENCODING),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.ACCEPT_LANGUAGE),
      @ApiImplicitParam(required = true, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.AUTHORIZATION),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_TYPE),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.CONTENT_LENGTH),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.HOST),
      @ApiImplicitParam(required = false, paramType = ApiConstant.PARAM_TYPE_HEADER,
          name = HttpHeaders.USER_AGENT),
      @ApiImplicitParam(name = ApiConstant.UUID, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER, value = ApiConstant.UUID_DESCRIPTION),
      @ApiImplicitParam(name = ApiConstant.CHANNEL_ID_HEADER, required = true,
          paramType = ApiConstant.PARAM_TYPE_HEADER)})
  @GetMapping(path = RoutesConstant.EMPLOYEE_DATA_SEARCH_PATH,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Employee>> searchBy(@RequestHeader HttpHeaders headers,
      @NotEmpty @PathVariable(name = ApiConstant.PARAM_SEARCH) String value) {
    return ResponseEntity.ok(this.employeeService.searchBy(headers, value));
  }
}
