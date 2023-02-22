package cl.myhotel.vehiculos.service;

import java.util.List;
import java.util.Optional;

import cl.myhotel.vehiculos.dto.TipoDTO;
import cl.myhotel.vehiculos.entities.Tipo;

public interface TipoService {
	
	List<TipoDTO> listarTipo();
	
	Optional<Tipo> buscarTipo(Long id);
	
	TipoDTO toDTO(Tipo tipo);
	
	Tipo toEntity(TipoDTO dto);
	
}