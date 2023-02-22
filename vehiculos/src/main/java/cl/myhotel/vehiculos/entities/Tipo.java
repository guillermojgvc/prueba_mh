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
@Table(name="tipo")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIPO_ID")
	private long id;

	@Column(name="DESCRIPCION")
	private String descripcion;
	
	//bi-directional many-to-one association
	@ManyToOne
	@JoinColumn(name="CATEGORIA_ID")
	private Categoria categoria;
	
	//bi-directional many-to-one association
	@OneToMany(mappedBy="tipo")
	private List<Vehiculo> vehiculos;

}