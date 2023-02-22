package cl.myhotel.vehiculos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the vehicles database table.
 * 
 */
@Data
@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VEHICULO_ID")
	private Long id;

	@Column(name="MARCA")
	private String marca;
	
	@Column(name="MODELO")
	private String modelo;
	
	@Column(name="PATENTE")
	private String patente;
	
	@Column(name="ANIO")
	private Integer anio;
	
	@Column(name="KILOMETRAJE")
	private Integer kilometraje;
	
	@Column(name="CILINDRADA")
	private Integer cilindrada;
	
	@Column(name="NUMERO_PUERTAS")
	private Integer numeroPuertas;
	
	@Column(name="CAPACIDAD_PASAJEROS")
	private Integer capacidadPasajeros;
	
	@Column(name="CAPACIDAD_MALETERO")
	private Integer capacidadMaletero;
	
	@Column(name="CAPACIDAD_TONELADAS")
	private Integer capacidadToneladas;
	
	@Column(name="CANTIDAD_EJES")
	private Integer cantidadEjes;

//	@Temporal(TemporalType.DATE)
//	@Column(name="HIRE_DATE")
//	private Date hireDate;

	//bi-directional many-to-one association
	@ManyToOne
	@JoinColumn(name="TIPO_ID")
	private Tipo tipo;
	
	//bi-directional many-to-one association
	@OneToMany(mappedBy="vehiculo")
	private List<HistorialMantenimiento> historialMantenimientos;

	public Vehiculo() {
		super();
	}
			
	public Vehiculo(Long id, String marca, String modelo, String patente, Integer anio, Integer kilometraje,
			Integer cilindrada, Integer numeroPuertas, Integer capacidadPasajeros, Integer capacidadMaletero,
			Integer capacidadToneladas, Integer cantidadEjes, Tipo tipo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.kilometraje = kilometraje;
		this.cilindrada = cilindrada;
		this.numeroPuertas = numeroPuertas;
		this.capacidadPasajeros = capacidadPasajeros;
		this.capacidadMaletero = capacidadMaletero;
		this.capacidadToneladas = capacidadToneladas;
		this.cantidadEjes = cantidadEjes;
		this.tipo = tipo;
	}
	
	

}