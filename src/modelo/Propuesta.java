package modelo;

public class Propuesta {

	private String titulo;
	private String autor;
	private String estado;
	private String descripcion;
	private String motivoRechazo;
	private String origen;
	private String motivacion;
	private String fecha;
	private String categoria;
	
	
	
	public Propuesta(String titulo, String autor, String estado, String descripcion,
			String origen, String motivacion, String fecha, String categoria) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.estado = estado;
		this.descripcion = descripcion;
		this.origen = origen;
		this.motivacion = motivacion;
		this.fecha = fecha;
		this.categoria = categoria;
	}


	public Propuesta(String titulo, String autor, String estado, String descripcion, String fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.estado = estado;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getMotivacion() {
		return motivacion;
	}
	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	
	
	
}
