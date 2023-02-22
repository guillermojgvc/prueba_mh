package cl.myhotel.vehiculos.dto;

public class VehiculoDTO {
	
	private Long id;
	private String marca;
	private String modelo;
	private String patente;
	private Integer anio;
	private Integer kilometraje;
	private Integer cilindrada;
	private String tipo;
	private String categoria;
	
	public VehiculoDTO() {
		
	}
	
	public VehiculoDTO(Long id, String marca, String modelo, String patente, Integer anio, Integer kilometraje,
			Integer cilindrada, String tipo, String categoria) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.kilometraje = kilometraje;
		this.cilindrada = cilindrada;
		this.tipo = tipo;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}
	public Integer getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
