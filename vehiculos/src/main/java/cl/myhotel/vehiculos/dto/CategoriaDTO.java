package cl.myhotel.vehiculos.dto;

import lombok.Data;


/**
 * 
 * 
 */
@Data
public class CategoriaDTO {

	private long id;
	private String descripcion;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

}