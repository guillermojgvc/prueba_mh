package cl.myhotel.vehiculos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.myhotel.vehiculos.dto.CategoriaDTO;
import cl.myhotel.vehiculos.dto.ResponseDTO;
import cl.myhotel.vehiculos.dto.TipoDTO;
import cl.myhotel.vehiculos.service.CategoriaService;
import cl.myhotel.vehiculos.service.TipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Service
@RequestMapping(value = "/catalogo")
@Tag(name = "API - Catalogos")
public class CatalogoController {
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogoController.class);
	
	
	@GetMapping(value = "tipos")
	@Operation(summary = "", description = "Obtener los tipos de vehículos")
	public ResponseEntity<ResponseDTO> listarTipos(){
		LOGGER.info("Consulta obtener tipos");
		ResponseDTO result = new ResponseDTO();
		List<TipoDTO> lista = tipoService.listarTipo();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}
	
	@GetMapping(value = "categorias")
	@Operation(summary = "", description = "Obtener las categorías de los vehículos")
	public ResponseEntity<ResponseDTO> listarCategorias(){
		LOGGER.info("Consulta obtener categorias");
		ResponseDTO result = new ResponseDTO();
		List<CategoriaDTO> lista = categoriaService.listarCategoria();
		if(lista.isEmpty()) {
			result.setStatus(HttpStatus.NO_CONTENT);
		}else {
			result.setStatus(HttpStatus.OK);
		}
		result.setResponse(lista);
		return new ResponseEntity<>(result, result.getStatus());
	}

}
