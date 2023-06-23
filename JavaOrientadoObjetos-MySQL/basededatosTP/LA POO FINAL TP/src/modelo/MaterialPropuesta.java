package modelo;

import java.util.ArrayList;

public class MaterialPropuesta extends Material{
	
	private String tieneEnCuenta;
	 ArrayList<Propuesta> propuestasAsociadas = new ArrayList<Propuesta>();
	
	public MaterialPropuesta(String titulo, String categoria, String descripcion, String fuente,
			String enlaceAlDocumento, String objetivoPedagogico, String tieneEnCuenta) {
		super(titulo, categoria, descripcion, fuente, enlaceAlDocumento, objetivoPedagogico);
		this.tieneEnCuenta = tieneEnCuenta;
		
	}

	
	public String getTieneEnCuenta() {
		return tieneEnCuenta;
	}



	public void setTieneEnCuenta(String tieneEnCuenta) {
		this.tieneEnCuenta = tieneEnCuenta;
	}

	

	
}

