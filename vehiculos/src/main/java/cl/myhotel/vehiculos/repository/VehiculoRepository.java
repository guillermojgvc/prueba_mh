package cl.myhotel.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.myhotel.vehiculos.entities.Vehiculo;

@Repository("vehiculoRepository")
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
	
}