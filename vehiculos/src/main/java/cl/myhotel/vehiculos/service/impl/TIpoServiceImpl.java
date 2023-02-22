package cl.myhotel.vehiculos.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.myhotel.vehiculos.dto.TipoDTO;
import cl.myhotel.vehiculos.entities.Tipo;
import cl.myhotel.vehiculos.repository.TipoRepository;
import cl.myhotel.vehiculos.service.TipoService;

@Service
public class TIpoServiceImpl implements TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;

	@Override
	public List<TipoDTO> listarTipo() {
		List<Tipo> tipos = tipoRepository.findAll();
		List<TipoDTO> result = new ArrayList<>();
		for (Tipo tipo : tipos) {
			result.add(this.toDTO(tipo));
		}
		return result;
	}
	
	@Override
	public Optional<Tipo> buscarTipo(Long id) {
		try {
			return tipoRepository.findById(id);
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		} catch (Exception e) {
			return Optional.empty();
		}
		
	}
	
	@Override
	public TipoDTO toDTO(Tipo tipo) {
		TipoDTO dto = new TipoDTO();
		dto.setId(tipo.getId());
		dto.setDescripcion(tipo.getDescripcion());
		dto.setCategoria(tipo.getCategoria().getDescripcion());
		return dto;
	}

	@Override
	public Tipo toEntity(TipoDTO dto) {
		return tipoRepository.findById(dto.getId()).map(tipo -> {
			tipo.setDescripcion(dto.getDescripcion());
	        return tipo;
		}).orElseGet(null);
		
        
	}

}
