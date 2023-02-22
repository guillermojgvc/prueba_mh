package cl.myhotel.vehiculos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.myhotel.vehiculos.dto.AutomovilDTO;
import cl.myhotel.vehiculos.dto.CamionDTO;
import cl.myhotel.vehiculos.dto.VehiculoDTO;
import cl.myhotel.vehiculos.entities.Vehiculo;
import cl.myhotel.vehiculos.repository.VehiculoRepository;
import cl.myhotel.vehiculos.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoDTO> listarVehiculo() {
		List<Vehiculo> vehiculos = vehiculoRepository.findAll();
		List<VehiculoDTO> result = new ArrayList<>();
		for (Vehiculo vehiculo : vehiculos) {
			result.add(this.transformar(vehiculo));
		}
		
		return result;
	}

	@Override
	public Vehiculo buscar(Long id) {
		return vehiculoRepository.findById(id).map(vehiculo -> {
			return vehiculo;
		}).orElseGet(null);
	}
	
	@Override
	public VehiculoDTO guardar(Vehiculo vehiculo) {
		return this.transformar(vehiculoRepository.save(vehiculo));
	}

	@Override
	public VehiculoDTO eliminar(Long id) {
		return vehiculoRepository.findById(id)
				.map(vehiculo -> {
					vehiculoRepository.deleteById(id);
					return this.transformar(vehiculo);
				}).orElseGet(null);
	}


	@Override
	public VehiculoDTO transformar(Vehiculo vehiculo) {
		switch (vehiculo.getTipo().getCategoria().getDescripcion().toLowerCase()) {
		case "automovil":
			return new AutomovilDTO(
					vehiculo.getId(), vehiculo.getMarca(), 
					vehiculo.getModelo(), vehiculo.getPatente(),
					vehiculo.getAnio(), vehiculo.getKilometraje(), 
					vehiculo.getCilindrada(), vehiculo.getTipo().getDescripcion(), 
					vehiculo.getTipo().getCategoria().getDescripcion(),
					vehiculo.getNumeroPuertas(), vehiculo.getCapacidadPasajeros(),
					vehiculo.getCapacidadMaletero()
				);
		case "camion":
			return new CamionDTO(
					vehiculo.getId(), vehiculo.getMarca(), 
					vehiculo.getModelo(), vehiculo.getPatente(),
					vehiculo.getAnio(), vehiculo.getKilometraje(), 
					vehiculo.getCilindrada(), vehiculo.getTipo().getDescripcion(), 
					vehiculo.getTipo().getCategoria().getDescripcion(),
					vehiculo.getCapacidadToneladas(), vehiculo.getCantidadEjes()
				);
		default:
			return null;
		}
	}

	@Override
	public VehiculoDTO actualizar(Vehiculo vehiculo, Long id) {
		return vehiculoRepository.findById(id)
			      .map(vehiculoOld -> {
			    	  vehiculo.setId(vehiculoOld.getId());
			    	  return this.transformar(vehiculoRepository.save(vehiculo));
			      })
			      .orElseGet(() -> {
			    	  return null;
			      });
	}

	
}
