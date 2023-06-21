package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.CategoriaDAO;
import dao.PropuestaDAO;
import modelo.Categoria;
import modelo.Propuesta;

public class PropuestaNuevoModificarPanel extends JPanel {

	private Propuesta propuesta;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEstado;
	private JTextField textDescripcion;
	private JTextField textFecha;
	private JTextField textOrigen;
	private JTextField textMotivacion;

	/**
	 * Create the panel.
	 */
	public PropuestaNuevoModificarPanel() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(68, 53, 46, 14);
		add(lblTitulo);
		
		JLabel lblCategoria = new JLabel("Autor");
		lblCategoria.setBounds(68, 78, 56, 14);
		add(lblCategoria);
		
		JLabel lblEnlace = new JLabel("Estado");
		lblEnlace.setBounds(68, 103, 46, 14);
		add(lblEnlace);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(68, 128, 56, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Origen");
		lblNewLabel_5.setBounds(68, 153, 46, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(68, 203, 56, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Motivacion");
		lblNewLabel_7.setBounds(68, 178, 56, 14);
		add(lblNewLabel_7);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(136, 50, 86, 20);
		add(textTitulo);
		textTitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(136, 75, 86, 20);
		add(textAutor);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(136, 100, 86, 20);
		add(textEstado);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(136, 125, 86, 20);
		add(textDescripcion);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(136, 200, 86, 20);
		add(textFecha);
		
		textOrigen = new JTextField();
		textOrigen.setColumns(10);
		textOrigen.setBounds(136, 150, 86, 20);
		add(textOrigen);
		
		textMotivacion = new JTextField();
		textMotivacion.setColumns(10);
		textMotivacion.setBounds(136, 175, 86, 20);
		add(textMotivacion);
		
		JComboBox<String> cmbCategoria = new JComboBox<String>();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		ArrayList<Categoria> categorias = categoriaDAO.mostrarCategorias();
		for(Categoria categoria : categorias) {
			cmbCategoria.addItem(categoria.getNombre());
			
		}
		
		cmbCategoria.setBounds(136, 233, 128, 22);
		add(cmbCategoria);

		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
				String titulo = textTitulo.getText();
				String autor = textAutor.getText();
				String estado = textEstado.getText();
				String descripcion = textDescripcion.getText();
				String origen = textOrigen.getText();
				String motivacion = textMotivacion.getText();
				String fecha = textFecha.getText();
				String categoria =  cmbCategoria.getSelectedItem().toString();
				
				PropuestaDAO pDao = new PropuestaDAO();
				if(esEdicion()) {
					Propuesta nuevo = new Propuesta(titulo, autor, estado, descripcion, origen, motivacion, fecha, categoria);
					pDao.modificar(nuevo, propuesta.getTitulo());
				}else {
					Propuesta propuesta = new Propuesta(titulo, autor, estado, descripcion, origen, motivacion, fecha, categoria);
					pDao.guardar(propuesta);
				}
				
				
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) a.getSource());
				marco.setContentPane(new PropuestaPanel());
				marco.validate();
			}
		});
		btnGuardar.setBounds(89, 266, 89, 23);
		add(btnGuardar);
		
			
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(68, 228, 64, 14);
		add(lblNewLabel);

		
	}
	
	public PropuestaNuevoModificarPanel(Propuesta p) {
		this();
		textTitulo.setText(p.getTitulo());
		textAutor.setText(p.getAutor());
		textEstado.setText(p.getEstado());
		textDescripcion.setText(p.getDescripcion());
		textOrigen.setText(p.getOrigen());
		textMotivacion.setText(p.getMotivacion());
		textFecha.setText(p.getFecha());
		this.propuesta = p;
		
	}
	
	public boolean esEdicion() {
		return propuesta != null;
	}
	
}
