package Vista;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.TPFinalDAO;
import modelo.Propuesta;

public class PropuestaAltaModificarPanel extends JPanel {
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEstado;
	private JTextField textDescripcion;
	private JTextField textOrigen;
	private JTextField textMotivacion;
	private JTextField textFecha;
	private JButton btnGuardar;
	private Propuesta propuesta;

	/**
	 * Create the panel.
	 */
	public PropuestaAltaModificarPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Motivacion");
		lblNewLabel.setBounds(231, 44, 64, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(27, 94, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Origen");
		lblNewLabel_2.setBounds(249, 19, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(27, 44, 46, 14);
		add(lblAutor);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(249, 69, 46, 14);
		add(lblFecha);
		
		JLabel lblNewLabel_3_1 = new JLabel("Titulo");
		lblNewLabel_3_1.setBounds(27, 19, 46, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Estado");
		lblNewLabel_3_2.setBounds(27, 63, 46, 27);
		add(lblNewLabel_3_2);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(103, 16, 86, 20);
		add(textTitulo);
		textTitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(103, 41, 86, 20);
		add(textAutor);
		textAutor.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(103, 66, 86, 20);
		add(textEstado);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(103, 91, 86, 20);
		add(textDescripcion);
		
		textOrigen = new JTextField();
		textOrigen.setColumns(10);
		textOrigen.setBounds(327, 16, 86, 20);
		add(textOrigen);
		
		textMotivacion = new JTextField();
		textMotivacion.setColumns(10);
		textMotivacion.setBounds(327, 41, 86, 20);
		add(textMotivacion);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(327, 66, 86, 20);
		add(textFecha);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
				String titulo = textTitulo.getText();
				String autor = textAutor.getText();
				String estado = textEstado.getText();
				String descripcion = textDescripcion.getText();
				String origen = textOrigen.getText();
				String motivacion = textMotivacion.getText();
				String fecha = textFecha.getText();
				
				TPFinalDAO aDao = new TPFinalDAO();
				
				if(esEdicion()) {
					Propuesta nuevo = new Propuesta(titulo);
					aDao.modificar(nuevo, propuesta.getTitulo());
				}
			}
		});
		btnGuardar.setBounds(165, 243, 89, 23);
		add(btnGuardar);

		
		
	}
	
	public PropuestaAltaModificarPanel (Propuesta e) {
		
		this();
		
		textTitulo.setText(e.getTitulo());
		textAutor.setText(e.getAutor());
		textEstado.setText(e.getEstado());
		textDescripcion.setText(e.getDescripcion());
		textOrigen.setText(e.getOrigen());
		textMotivacion.setText(e.getMotivacion());
		textFecha.setText(e.getFecha());
		
		this.propuesta = e;
	}
	
	public boolean esEdicion() {
		return this.propuesta != null;
		
	}
}
