package cl.myhotel.vehiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.myhotel.vehiculos.entities.HistorialMantenimiento;
import cl.myhotel.vehiculos.entities.Vehiculo;

@Repository("historialMantenimientoRepository")
public interface HistorialMantenimientoRepository extends JpaRepository<HistorialMantenimiento, Long> {
	List<HistorialMantenimiento> findByVehiculo(Vehiculo vehiculo);
}