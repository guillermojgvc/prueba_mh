package cl.myhotel.vehiculos.service;

import java.util.List;

import cl.myhotel.vehiculos.dto.VehiculoDTO;
import cl.myhotel.vehiculos.entities.Vehiculo;

public interface VehiculoService {
	
	List<VehiculoDTO> listarVehiculo();
	
	Vehiculo buscar(Long id);
	
	VehiculoDTO eliminar(Long id);
	
	VehiculoDTO guardar(Vehiculo vehiculo);
	 
	VehiculoDTO	actualizar(Vehiculo vehiculo, Long id);
	
	VehiculoDTO transformar(Vehiculo vehiculo);
	
	
}