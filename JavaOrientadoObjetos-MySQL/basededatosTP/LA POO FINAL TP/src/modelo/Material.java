package modelo;

public class Material {
private String titulo;
private String categoria;
private String descripcion;
private String fuente;
private String enlaceAlDocumento;
private String objetivoPedagogico;


public Material(String titulo, String categoria, String descripcion, String fuente, String enlaceAlDocumento,String objetivoPedagogico) {
	super();
	this.titulo = titulo;
	this.categoria = categoria;
	this.descripcion = descripcion;
	this.fuente = fuente;
	this.enlaceAlDocumento = enlaceAlDocumento;
	this.objetivoPedagogico = objetivoPedagogico;
	
}

public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getFuente() {
	return fuente;
}
public void setFuente(String fuente) {
	this.fuente = fuente;
}
public String getEnlaceAlDocumento() {
	return enlaceAlDocumento;
}
public void setEnlaceAlDocumento(String enlaceAlDocumento) {
	this.enlaceAlDocumento = enlaceAlDocumento;
}

public String getObjetivoPedagogico() {
	return objetivoPedagogico;
}

public void setObjetivoPedagogico(String objetivoPedagogico) {
	this.objetivoPedagogico = objetivoPedagogico;
}


}