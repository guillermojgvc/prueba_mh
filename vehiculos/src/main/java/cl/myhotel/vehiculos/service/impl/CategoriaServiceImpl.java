package cl.myhotel.vehiculos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.myhotel.vehiculos.dto.CategoriaDTO;
import cl.myhotel.vehiculos.entities.Categoria;
import cl.myhotel.vehiculos.repository.CategoriaRepository;
import cl.myhotel.vehiculos.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<CategoriaDTO> listarCategoria() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> result = new ArrayList<>();
		for (Categoria categoria : categorias) {
			result.add(new CategoriaDTO(categoria.getId(),categoria.getDescripcion()));
		}
		return result;
	}

	@Override
	public CategoriaDTO toDTO(Categoria categoria) {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setId(categoria.getId());
		dto.setDescripcion(categoria.getDescripcion());
		return dto;
	}

	@Override
	public Categoria toEntity(CategoriaDTO dto) {
		return categoriaRepository.findById(dto.getId()).map(tipo -> {
			tipo.setDescripcion(dto.getDescripcion());
	        return tipo;
		}).orElseGet(null);
	}

}
