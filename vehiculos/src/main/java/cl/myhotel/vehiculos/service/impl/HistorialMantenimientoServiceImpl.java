package cl.myhotel.vehiculos.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.myhotel.vehiculos.dto.HistorialMantenimientoDTO;
import cl.myhotel.vehiculos.entities.HistorialMantenimiento;
import cl.myhotel.vehiculos.entities.Vehiculo;
import cl.myhotel.vehiculos.repository.HistorialMantenimientoRepository;
import cl.myhotel.vehiculos.repository.VehiculoRepository;
import cl.myhotel.vehiculos.service.HistorialMantenimientoService;

@Service
public class HistorialMantenimientoServiceImpl implements HistorialMantenimientoService {

	@Autowired
	private HistorialMantenimientoRepository historialMantenimientoRepository;
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public List<HistorialMantenimientoDTO> buscarPorVehiculo(Long id) {
		Optional<Vehiculo> opVehiculo = vehiculoRepository.findById(id);
		List<HistorialMantenimientoDTO> result = new ArrayList<>();
		if(opVehiculo.isPresent()) {
			List<HistorialMantenimiento> historialMantenimientos = historialMantenimientoRepository.findByVehiculo(opVehiculo.get());
			
			for (HistorialMantenimiento historialMantenimiento : historialMantenimientos) {
				result.add(this.toDTO(historialMantenimiento));
			}
		}
		return result;
	}

	@Override
	public HistorialMantenimientoDTO eliminar(Long id) {
		return historialMantenimientoRepository.findById(id)
				.map(mantenimiento -> {
					historialMantenimientoRepository.deleteById(id);
					return this.toDTO(mantenimiento);
				}).orElseGet(null);
	}

	@Override
	public HistorialMantenimientoDTO guardar(HistorialMantenimiento historialMantenimiento) {
		return this.toDTO(historialMantenimientoRepository.save(historialMantenimiento));
	}

//	@Override
//	public HistorialMantenimientoDTO actualizar(HistorialMantenimiento historialMantenimiento, Long id) {
//		return historialMantenimientoRepository.findById(id)
//			      .map(mantenimientoOld -> {
//			    	  historialMantenimiento.setId(mantenimientoOld.getId());
//			    	  return this.toDTO(historialMantenimientoRepository.save(historialMantenimiento));
//			      })
//			      .orElseGet(() -> {
//			    	  return null;
//			      });
//	}

	@Override
	public HistorialMantenimientoDTO toDTO(HistorialMantenimiento historialMantenimiento) {
		return new HistorialMantenimientoDTO(
				historialMantenimiento.getId(),historialMantenimiento.getKilometraje(),
				historialMantenimiento.getFechaMantenimiento(),
				historialMantenimiento.getVehiculo().getPatente());
	}

}
