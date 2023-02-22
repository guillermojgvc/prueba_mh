package cl.myhotel.vehiculos.service;

import java.util.List;

import cl.myhotel.vehiculos.dto.HistorialMantenimientoDTO;
import cl.myhotel.vehiculos.entities.HistorialMantenimiento;

public interface HistorialMantenimientoService {
	
	List<HistorialMantenimientoDTO> buscarPorVehiculo(Long id);
	
	HistorialMantenimientoDTO eliminar(Long id);
	
	HistorialMantenimientoDTO guardar(HistorialMantenimiento historialMantenimiento);
	
	HistorialMantenimientoDTO toDTO(HistorialMantenimiento historialMantenimiento);
	
}