package cl.myhotel.vehiculos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the historial_mantenimiento database table.
 * 
 */
@Data
@Entity
@Table(name="historial_mantenimiento")
public class HistorialMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HISTORIAL_ID")
	private Long id;
	
	@Column(name="KILOMETRAJE")
	private Integer kilometraje;
	

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_MANTENIMIENTO")
	private Date fechaMantenimiento;

	//bi-directional many-to-one association
	@ManyToOne
	@JoinColumn(name="VEHICULO_ID")
	private Vehiculo vehiculo;

}