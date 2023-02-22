package cl.myhotel.vehiculos.service;

import java.util.List;

import cl.myhotel.vehiculos.dto.CategoriaDTO;
import cl.myhotel.vehiculos.entities.Categoria;

public interface CategoriaService {
	
	List<CategoriaDTO> listarCategoria();
	
	CategoriaDTO toDTO(Categoria categoria);
	
	Categoria toEntity(CategoriaDTO dto);
	
}