package cl.myhotel.vehiculos.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;



@Data
public class HistorialMantenimientoRequestDTO {
	
	@Min(value = 0, message = "Debe ser un valor mayor o igual a 0")
	private Integer kilometraje;
	private Date fechaMantenimiento;
	@NotNull(message = "Campo obligatorio")
	private Long idVehiculo;

}