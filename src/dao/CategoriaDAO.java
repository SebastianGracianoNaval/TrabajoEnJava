package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Categoria;

public class CategoriaDAO {

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
	
	public ArrayList<Categoria> mostrarCategorias() {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `categorias`.`idCategorias`, `categorias`.`nombreCategoria` FROM `fretesgracianoespejo`.`categorias`;";
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String nombre = rs.getString("nombreCategoria");
				int id = rs.getInt("idCategorias");
				Categoria categoria = new Categoria(nombre, id);
				categorias.add(categoria);
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
		return categorias;

	}
		
	public int categoriaNombreToInt() {
		int id = 0;
		Connection c = null;
		try {
		c = conectar();
		String sql = "SELECT `idCategorias` FROM `categorias` where 'nombreCategorias' = '?'";
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		while (rs.next()) {
			 id = rs.getInt("idcategoria");
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
		
		return id;
	}
}
