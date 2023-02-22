package cl.myhotel.vehiculos.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class VehiculoRequestDTO {
	
	@Size(max = 255, message = "Supera la longitud permitida de 255 caracteres")
	private String marca;
	@Size(max = 255, message = "Supera la longitud permitida de 255 caracteres")
	private String modelo;
	@Size(max = 255, message = "Supera la longitud permitida de 255 caracteres")
	private String patente;
	@Max(value = 2100, message = "Debe ser un valor menor o igual a 2100")
	@Min(value = 1950, message = "Debe ser un valor mayor o igual a 1950")
	private Integer anio;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer kilometraje;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer cilindrada;
	@NotNull(message = "El id debe ser un número válido")
	private Long idTipo;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer numeroPuertas;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer capacidadPasajeros;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer capacidadMaletero;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer capacidadToneladas;
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer cantidadEjes;
	
}
