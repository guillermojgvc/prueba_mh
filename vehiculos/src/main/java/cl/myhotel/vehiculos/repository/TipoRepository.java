package cl.myhotel.vehiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.myhotel.vehiculos.entities.Tipo;

@Repository("tipoRepository")
public interface TipoRepository extends JpaRepository<Tipo, Long> {
	
}