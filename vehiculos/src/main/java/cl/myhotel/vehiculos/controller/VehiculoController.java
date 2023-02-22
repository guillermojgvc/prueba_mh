package cl.myhotel.vehiculos.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.myhotel.vehiculos.dto.ResponseDTO;
import cl.myhotel.vehiculos.dto.VehiculoDTO;
import cl.myhotel.vehiculos.dto.VehiculoRequestDTO;
import cl.myhotel.vehiculos.entities.Tipo;
import cl.myhotel.vehiculos.entities.Vehiculo;
import cl.myhotel.vehiculos.service.TipoService;
import cl.myhotel.vehiculos.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Service
@RequestMapping(value = "/vehiculo")
@Tag(name = "API")
public class VehiculoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VehiculoController.class);
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping(value = "buscar/{id}")
	@Operation(summary = "", description = "Consultar vehículo por id")
	public ResponseEntity<ResponseDTO> listarVehiculo(@PathVariable Long id){
		LOGGER.info("Consulta vehículo por id");
		ResponseDTO result = new ResponseDTO();
		VehiculoDTO vehiculoDTO = vehiculoService.transformar(vehiculoService.buscar(id));
		
		if(vehiculoDTO == null) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(vehiculoDTO);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "listar")
	@Operation(summary = "", description = "Listar vehículos registrados")
	public ResponseEntity<ResponseDTO> listarVehiculo(){
		LOGGER.info("Consulta lista de vehiculos");
		ResponseDTO result = new ResponseDTO();
		List<VehiculoDTO> lista = vehiculoService.listarVehiculo();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@PostMapping(value = "nuevo")
	@Operation(summary = "", description = "Insertar un nuevo vehículo")
	public ResponseEntity<ResponseDTO> nuevoVehiculo(@Valid @RequestBody VehiculoRequestDTO vehiculoDto){
		LOGGER.info("Insertar nuevo vehículo");
		ResponseDTO result = new ResponseDTO();
		Optional<Tipo> opTipo = tipoService.buscarTipo(vehiculoDto.getIdTipo());
		if(opTipo.isPresent()) {
			Vehiculo vehiculo = this.formatearPeticion(vehiculoDto, opTipo.get());
			result.setResponse(vehiculoService.guardar(vehiculo));
			result.setMsg("Se almacenó el vehículo");
			result.setStatus(HttpStatus.OK);
		}else {
			result.setMsg("No existe el tipo de vehículo");
			result.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@DeleteMapping(value = "eliminar/{id}")
	@Operation(summary = "", description = "Eliminar un vehículo")
	public ResponseEntity<ResponseDTO> eliminarVehiculo(@PathVariable Long id){
		LOGGER.info("Eliminar un vehículo por id");
		ResponseDTO result = new ResponseDTO();
		VehiculoDTO vehiculoDTO = vehiculoService.eliminar(id);
		if(vehiculoDTO == null) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(vehiculoDTO);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@PutMapping(value = "actualizar/{id}")
	@Operation(summary = "", description = "Actualizar un vehículo")
	public ResponseEntity<ResponseDTO> actualizarVehiculo(@PathVariable Long id,@Valid @RequestBody VehiculoRequestDTO vehiculoDto){
		LOGGER.info("Actualizar un vehículo por id");
		ResponseDTO result = new ResponseDTO();
		
		Optional<Tipo> opTipo = tipoService.buscarTipo(vehiculoDto.getIdTipo());
		if(opTipo.isPresent()) {
			Vehiculo vehiculo = this.formatearPeticion(vehiculoDto, opTipo.get());
			result.setResponse(vehiculoService.actualizar(vehiculo, id));
			result.setMsg("Se almacenó el vehículo");
			result.setStatus(HttpStatus.OK);
		}else {
			result.setMsg("No existe el tipo de vehículo");
			result.setStatus(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(result, result.getStatus());
	}
	
	private Vehiculo formatearPeticion(VehiculoRequestDTO vehiculoDto, Tipo tipo) {
		Vehiculo vehiculo;
		switch (tipo.getCategoria().getDescripcion().toLowerCase()) {
			case "automovil":
				vehiculo = new Vehiculo(
						null, vehiculoDto.getMarca(), vehiculoDto.getModelo(), vehiculoDto.getPatente(), 
						vehiculoDto.getAnio(), vehiculoDto.getKilometraje(), vehiculoDto.getCilindrada(), 
						vehiculoDto.getNumeroPuertas(),vehiculoDto.getCapacidadPasajeros(),
						vehiculoDto.getCapacidadMaletero(),null,
						null,tipo
					);
				break;
			case "camion":
				vehiculo = new Vehiculo(
						null, vehiculoDto.getMarca(), vehiculoDto.getModelo(), vehiculoDto.getPatente(), 
						vehiculoDto.getAnio(), vehiculoDto.getKilometraje(), vehiculoDto.getCilindrada(), 
						null,null,
						null,vehiculoDto.getCapacidadToneladas(),
						vehiculoDto.getCantidadEjes(),tipo
					);
				break;
			default:
				vehiculo = null;
				break;
		}
		return vehiculo;
	}

}
