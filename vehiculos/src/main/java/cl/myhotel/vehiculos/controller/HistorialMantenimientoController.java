package cl.myhotel.vehiculos.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.myhotel.vehiculos.dto.HistorialMantenimientoDTO;
import cl.myhotel.vehiculos.dto.HistorialMantenimientoRequestDTO;
import cl.myhotel.vehiculos.dto.ResponseDTO;
import cl.myhotel.vehiculos.entities.HistorialMantenimiento;
import cl.myhotel.vehiculos.entities.Vehiculo;
import cl.myhotel.vehiculos.service.HistorialMantenimientoService;
import cl.myhotel.vehiculos.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Service
@RequestMapping(value = "/mantenimiento_vehiculo")
@Tag(name = "API")
public class HistorialMantenimientoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HistorialMantenimientoController.class);
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired
	private HistorialMantenimientoService historialMantenimientoService;
	
	@GetMapping(value = "buscar/{id}")
	@Operation(summary = "", description = "Consultar por id de vehículo")
	public ResponseEntity<ResponseDTO> listarMantenimientoVehiculo(@PathVariable Long id){
		LOGGER.info("Consulta historial por id de vehículo");
		ResponseDTO result = new ResponseDTO();
		List<HistorialMantenimientoDTO> lista = historialMantenimientoService.buscarPorVehiculo(id);
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@PostMapping(value = "nuevo")
	@Operation(summary = "", description = "Insertar un nuevo mantenimiento vehículo")
	public ResponseEntity<ResponseDTO> nuevoMantenimientoVehiculo(@Valid @RequestBody HistorialMantenimientoRequestDTO dto){
		LOGGER.info("Insertar nuevo mantenimiento vehículo");
		ResponseDTO result = new ResponseDTO();
		Vehiculo vehiculo = vehiculoService.buscar(dto.getIdVehiculo());
		if(vehiculo == null) {
			result.setMsg("No existe el vehículo");
			result.setStatus(HttpStatus.BAD_REQUEST);
		}else {
			HistorialMantenimiento historialMantenimiento = new HistorialMantenimiento();
			historialMantenimiento.setFechaMantenimiento(new Date());
			historialMantenimiento.setKilometraje(dto.getKilometraje());
			historialMantenimiento.setVehiculo(vehiculo);
			
			result.setResponse(historialMantenimientoService.guardar(historialMantenimiento));
			result.setMsg("Se almacenó el vehículo");
			result.setStatus(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@DeleteMapping(value = "eliminar/{id}")
	@Operation(summary = "", description = "Eliminar un mantenimiento de vehículo")
	public ResponseEntity<ResponseDTO> eliminarMantenimientoVehiculo(@PathVariable Long id){
		LOGGER.info("Eliminar un vehículo por id");
		ResponseDTO result = new ResponseDTO();
		HistorialMantenimientoDTO historialMantenimientoDTO = historialMantenimientoService.eliminar(id);
		if(historialMantenimientoDTO == null) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(historialMantenimientoDTO);
		return new ResponseEntity<>(result, result.getStatus());
	}
	

}
