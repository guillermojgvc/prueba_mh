package cl.myhotel.vehiculos.dto;

public class CamionDTO extends VehiculoDTO {
	
	private Integer capacidadToneladas;
	private Integer cantidadEjes;
	
	public CamionDTO() {
		
	}
	
	public CamionDTO(Long id, String marca, String modelo, String patente, Integer anio, Integer kilometraje,
			Integer cilindrada, String tipo, String categoria, Integer capacidadToneladas, Integer cantidadEjes) {
		super(id, marca, modelo, patente, anio, kilometraje, cilindrada, tipo, categoria);
		this.capacidadToneladas = capacidadToneladas;
		this.cantidadEjes = cantidadEjes;
	}

	public Integer getCapacidadToneladas() {
		return capacidadToneladas;
	}
	public void setCapacidadToneladas(Integer capacidadToneladas) {
		this.capacidadToneladas = capacidadToneladas;
	}
	public Integer getCantidadEjes() {
		return cantidadEjes;
	}
	public void setCantidadEjes(Integer cantidadEjes) {
		this.cantidadEjes = cantidadEjes;
	}
	

}
