package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.EstudianteDAO;
import modelo.Estudiante;

public class EstudianteAltaEdicionPanel extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtDNI;
	private Estudiante estudiante;

	/**
	 * Create the panel.
	 */
	public EstudianteAltaEdicionPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(40, 24, 46, 14);
		add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(96, 21, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(96, 52, 86, 20);
		add(txtEdad);
		txtEdad.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String nombre = txtNombre.getText();
				int edad = Integer.valueOf(txtEdad.getText());
				int dni = Integer.valueOf(txtDNI.getText());
				
				EstudianteDAO eDao = new EstudianteDAO();
				if (esEdicion()) {
					// Es una modificación
					Estudiante nuevo = new Estudiante(dni, nombre, edad);
					eDao.modificar(nuevo, estudiante.getDni());
				} else {
					// Es un alta.
					Estudiante estudiante = new Estudiante(dni, nombre, edad);
					
					eDao.guardar(estudiante);
				}
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) ae.getSource());
				marco.setContentPane(new EstudiantePanel());
				marco.validate();

			}

		});
		btnGuardar.setBounds(96, 116, 89, 23);
		add(btnGuardar);

		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setBounds(40, 55, 46, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("DNI");
		lblNewLabel_1_1.setBounds(40, 86, 46, 14);
		add(lblNewLabel_1_1);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(96, 83, 86, 20);
		add(txtDNI);

	}

	public EstudianteAltaEdicionPanel(Estudiante e) {
		// Ejecuto primero el constructor sin argumentos para que se contruya la pantalla.
		this();
		// Cargo los datos del objeto estudiante en los campos de texto.
		txtDNI.setText(""+ e.getDni());
		txtNombre.setText(e.getNombre());
		txtEdad.setText("" + e.getEdad());
		this.estudiante = e;
		
	}
	
	public boolean esEdicion() {
		return this.estudiante != null;
		
	}

}
