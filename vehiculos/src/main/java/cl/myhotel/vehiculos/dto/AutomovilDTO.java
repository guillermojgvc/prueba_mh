package cl.myhotel.vehiculos.dto;

public class AutomovilDTO extends VehiculoDTO {
	
	private Integer numeroPuertas;
	private Integer capacidadPasajeros;
	private Integer capacidadMaletero;
	
	public AutomovilDTO() {
		super();
	}

	public AutomovilDTO(Long id, String marca, String modelo, String patente, Integer anio, Integer kilometraje,
			Integer cilindrada, String tipo, String categoria, Integer numeroPuertas, Integer capacidadPasajeros, 
			Integer capacidadMaletero) {
		super(id, marca, modelo, patente, anio, kilometraje, cilindrada, tipo, categoria);
		this.numeroPuertas = numeroPuertas;
		this.capacidadPasajeros = capacidadPasajeros;
		this.capacidadMaletero = capacidadMaletero;
	}
	
	public Integer getNumeroPuertas() {
		return numeroPuertas;
	}
	public void setNumeroPuertas(Integer numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	public Integer getCapacidadPasajeros() {
		return capacidadPasajeros;
	}
	public void setCapacidadPasajeros(Integer capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}
	public Integer getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(Integer capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

}
