package cl.myhotel.prueba.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.myhotel.prueba.dto.ResponseDTO;
import cl.myhotel.prueba.entities.projection.AntiguedadEmpleadoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoDepartamentoView;
import cl.myhotel.prueba.entities.projection.EmpleadoSegmentoView;
import cl.myhotel.prueba.entities.projection.InformacionPaisView;
import cl.myhotel.prueba.entities.projection.SalarioDepartamentoView;
import cl.myhotel.prueba.entities.projection.SueldoEmpleadoDepartmentoView;
import cl.myhotel.prueba.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@RestController
@RequestMapping(value = "/api")
@Tag(name = "API")
//@CrossOrigin
public class ApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "consulta1")
	@Operation(summary = "", description = "Obtener cantidad de empleados dentro de los siguientes segmentos de sueldo")
	public ResponseEntity<ResponseDTO> obtenerEmpleadoSegmento(){
		LOGGER.info("Consulta obtener Empleado Segmento");
		ResponseDTO result = new ResponseDTO();
		List<EmpleadoSegmentoView> lista = employeeService.listarEmpleadoSegmento();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "consulta2")
	@Operation(summary = "", description = "Obtener cantidad de empleados dentro de los siguientes segmentos de sueldo por departamento")
	public ResponseEntity<ResponseDTO> obtenerEmpleadoSegmentoDepartamento(){
		ResponseDTO result = new ResponseDTO();
		List<EmpleadoSegmentoDepartamentoView> lista = employeeService.listarEmpleadoSegmentoDepartamento();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "consulta3")
	@Operation(summary = "", description = "Información del empleado con mayor sueldo de cada departamento")
	public ResponseEntity<ResponseDTO> obtenerSueldoEmpleadoDepartamento(){
		ResponseDTO result = new ResponseDTO();
		List<SueldoEmpleadoDepartmentoView> lista = employeeService.listarSueldoEmpleado();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "consulta4")
	@Operation(summary = "", description = "Información de los gerentes que hayan sido contratados hace más de 15\n"
			+ "años.")
	public ResponseEntity<ResponseDTO> obtenerManagerMasAnios(){
		ResponseDTO result = new ResponseDTO();
		List<AntiguedadEmpleadoView> lista = employeeService.listarEmpleadoPorAntiguedad(15);
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "consulta5")
	@Operation(summary = "", description = "Salario promedio de todos los departamentos que tengan más de 10\n"
			+ "empleados")
	public ResponseEntity<ResponseDTO> obtenerSalarioPromedioDepartamento(){
		ResponseDTO result = new ResponseDTO();
		List<SalarioDepartamentoView> lista = employeeService.listarSalarioPorDepartamento(10);
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "consulta6")
	@Operation(summary = "", description = "Obtener la siguiente información agrupada por país: cantidad empleados,salario promedio, salario más alto, salario más bajo, promedio años antigüedad")
	public ResponseEntity<ResponseDTO> obtenerInformacionPorPais(){
		ResponseDTO result = new ResponseDTO();
		List<InformacionPaisView> lista = employeeService.listarInfoPorPais();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
}
