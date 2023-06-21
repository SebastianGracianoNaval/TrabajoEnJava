package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.Propuesta;

public class PropuestaDAO {
	private Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/fretesgracianoespejo";
		String usr = "root";
		String pass = "seba";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return c;
	}
	
	public ArrayList<Propuesta> mostrarPropuestas(){
	ArrayList<Propuesta> propuestas = new ArrayList<Propuesta>();
	Connection c = null;
	
	try {
		c = conectar();
		String sql = "SELECT `tituloPropuesta`, `autorPropuesta`, estadoPropuesta, descripcionPropuesta, fechaPropuesta FROM `fretesgracianoespejo`.`propuestas`;";
		Statement stmt = c.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String titulo = rs.getString("tituloPropuesta");
			String autor = rs.getString("autorPropuesta");
			String estado = rs.getString("estadoPropuesta");
			String descripcion = rs.getString("descripcionPropuesta");
			String fecha = rs.getString("fechaPropuesta");
			Propuesta propuesta = new Propuesta(titulo, autor, estado, descripcion, fecha);
			propuestas.add(propuesta);
		}

	} catch (SQLException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	} finally {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	return propuestas;

}
	
	
	public boolean guardar (Propuesta p) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "INSERT INTO propuestas (tituloPropuesta,autorPropuesta,estadoPropuesta, descripcionPropuesta, motivoRechazoPropuesta, origenPropuesta, motivacionPropuesta, fechaPropuesta, nombrecategoria)values (?, ?, ?, ?, null, ?,?,?,?)";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, p.getTitulo());
			pStmt.setString(2, p.getAutor());
			pStmt.setString(3, p.getEstado());
			pStmt.setString(4, p.getDescripcion());
			pStmt.setString(5, p.getOrigen());
			pStmt.setString(6, p.getMotivacion());
			pStmt.setString(7, p.getFecha());
			pStmt.setString(8, p.getCategoria());
			filasAfectadas = pStmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;
	
}
	
	public boolean eliminar(String titulo) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c= conectar();
			String sql = "DELETE FROM `propuestas` where `tituloPropuesta` = ?";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, titulo);
			
			filasAfectadas = pStmt.executeUpdate();
		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;

	}
		
	public boolean modificar(Propuesta p, String titulo) {
		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "UPDATE propuestas SET tituloPropuesta = ?, autorPropuesta = ?, estadoPropuesta = ?, descripcionPropuesta = ?, motivoRechazoPropuesta = null, origenPropuesta = ?, motivacionPropuesta = ?, fechaPropuesta = ?, nombrecategoria = ? WHERE tituloPropuesta = ?";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setString(1, p.getTitulo());
			pStmt.setString(2, p.getAutor());
			pStmt.setString(3, p.getEstado());
			pStmt.setString(4, p.getDescripcion());
			pStmt.setString(5, p.getOrigen());
			pStmt.setString(6, p.getMotivacion());
			pStmt.setString(7, p.getFecha());
			pStmt.setString(8, p.getCategoria());
			pStmt.setString(9, titulo);
			filasAfectadas = pStmt.executeUpdate();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return filasAfectadas != 0;
	
}
	}
	
	
