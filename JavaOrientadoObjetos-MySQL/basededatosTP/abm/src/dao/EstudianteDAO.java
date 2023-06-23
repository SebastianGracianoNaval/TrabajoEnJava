package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Estudiante;

public class EstudianteDAO {

	private Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/estudiante";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return c;

	}

	public boolean guardar(Estudiante e) {

		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "INSERT INTO `estudiantes` (`dni_estudiante`, `nombre_estudiante`, `edad_estudiante`) VALUES (?, ?, ?)";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, e.getDni());
			pStmt.setString(2, e.getNombre());
			pStmt.setInt(3, e.getEdad());

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

	public boolean modificar(Estudiante e, int dni) {

		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "UPDATE `estudiantes` SET `dni_estudiante` = ?, `nombre_estudiante` = ?, `edad_estudiante` = ? WHERE `dni_estudiante` = ?";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, e.getDni());
			pStmt.setString(2, e.getNombre());
			pStmt.setInt(3, e.getEdad());
			pStmt.setInt(4, dni);

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

	public boolean eliminar(int dni) {

		int filasAfectadas = 0;
		Connection c = null;
		try {
			c = conectar();
			String sql = "DELETE FROM `estudiantes` WHERE dni_estudiante = ?";
			PreparedStatement pStmt = c.prepareStatement(sql);
			pStmt.setInt(1, dni);

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

	public ArrayList<Estudiante> traerTodes() {
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `idestudiante`, `dni_estudiante`, `nombre_estudiante`, `edad_estudiante` FROM `estudiantes`";
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int dni = rs.getInt("dni_estudiante");
				String nombre = rs.getString("nombre_estudiante");
				int edad = rs.getInt("edad_estudiante");
				// Estudiante e = new Estudiante(dni, nombre, edad);
				estudiantes.add(new Estudiante(nombre));
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
		return estudiantes;

	}
}
