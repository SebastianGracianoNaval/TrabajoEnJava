package modelo;

public class MaterialInstitucional extends Material{
private String procedencia;
private boolean tratamientoPrioritario;


	public MaterialInstitucional(String titulo, String categoria, String descripcion, String fuente,
		String enlaceAlDocumento, String procedencia, boolean tratamientoPrioritario, String objetivoPedagogico) {
	super( titulo,categoria,  descripcion, fuente,  enlaceAlDocumento, objetivoPedagogico);
	this.procedencia = procedencia;
	this.tratamientoPrioritario = tratamientoPrioritario;
}

public String getProcedencia() {
	return procedencia;
}
public void setProcedencia(String procedencia) {
	this.procedencia = procedencia;
}
public boolean isTratamientoPrioritario() {
	return tratamientoPrioritario;
}
public void setTratamientoPrioritario(boolean tratamientoPrioritario) {
	this.tratamientoPrioritario = tratamientoPrioritario;
}


}