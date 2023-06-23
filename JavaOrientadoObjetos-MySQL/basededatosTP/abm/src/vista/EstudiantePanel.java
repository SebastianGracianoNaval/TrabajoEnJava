package vista;


import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.EstudianteDAO;
import modelo.Estudiante;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstudiantePanel extends JPanel {
	private JTable table;
	private ArrayList<Estudiante> estudiantes;

	/**
	 * Create the panel.
	 */
	public EstudiantePanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 76, 236, 159);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Edad"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) ae.getSource());
				marco.setContentPane(new EstudianteAltaEdicionPanel());
				marco.validate();
			}
		});
		btnNuevo.setBounds(295, 73, 89, 23);
		add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				Estudiante e = obtenerEstudianteSeleccionado();
				EstudianteDAO eDao = new EstudianteDAO();
				eDao.eliminar(e.getDni());
				cargarTabla(dataModel);
			}
		});
		btnEliminar.setBounds(295, 107, 89, 23);
		add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Estudiante e = obtenerEstudianteSeleccionado();
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) ae.getSource());
				marco.setContentPane(new EstudianteAltaEdicionPanel(e));
				marco.validate();

			}
		});
		btnModificar.setBounds(295, 144, 89, 23);
		add(btnModificar);

		cargarTabla(dataModel);

		
	}

	private void cargarTabla(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		EstudianteDAO eDao = new EstudianteDAO();
		estudiantes = eDao.traerTodes();
		for (Estudiante e : estudiantes) {
			Object[] fila = new Object[] {e.getDni(), e.getNombre(), e.getEdad()};
			dataModel.addRow(fila);
		}
	}

	private Estudiante obtenerEstudianteSeleccionado() {
		// TODO Mejorar (evitar relacionar el índice de la tabla con el índice del ArrayList)
		int filaSeleccionada = table.getSelectedRow();
		return estudiantes.get(filaSeleccionada);
	}
}
