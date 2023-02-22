package cl.myhotel.vehiculos.dto;

import java.util.Date;

import lombok.Data;



@Data
public class HistorialMantenimientoDTO {
	
	private Long id;
	private Integer kilometraje;
	private Date fechaMantenimiento;
	private String patente;
	
	public HistorialMantenimientoDTO() {
		super();
	}
	
	public HistorialMantenimientoDTO(Long id, Integer kilometraje, Date fechaMantenimiento, String patente) {
		super();
		this.id = id;
		this.kilometraje = kilometraje;
		this.fechaMantenimiento = fechaMantenimiento;
		this.patente = patente;
	}
	
	

}