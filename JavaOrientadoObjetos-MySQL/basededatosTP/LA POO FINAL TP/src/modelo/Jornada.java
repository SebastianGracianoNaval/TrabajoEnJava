package modelo;

import java.util.ArrayList;

public class Jornada {
	
	private String referenteInstitucionalCreador;
	private String objetico;
	private String titulo;

	ArrayList<Material> materiales = new ArrayList<Material>();

	public Jornada(String referenteInstitucionalCreador, String objetico, String titulo) {
	super();
	this.referenteInstitucionalCreador = referenteInstitucionalCreador;
	this.objetico = objetico;
	this.titulo = titulo;
	
	}

	public String getReferenteInstitucionalCreador() {
		return referenteInstitucionalCreador;
	}

	public void setReferenteInstitucionalCreador(String referenteInstitucionalCreador) {
		this.referenteInstitucionalCreador = referenteInstitucionalCreador;
	}

	public String getObjetico() {
		return objetico;
	}

	public void setObjetico(String objetico) {
		this.objetico = objetico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	


}