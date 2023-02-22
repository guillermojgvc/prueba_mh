package cl.myhotel.vehiculos.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ResponseDTO {
	@JsonIgnore
	private HttpStatus status;
	private Object response;
	private String msg;
}
