package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.PropuestaDAO;
import modelo.Propuesta;

public class PropuestaPanel extends JPanel {
	private ArrayList<Propuesta> propuestas;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PropuestaPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 61, 335, 159);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Autor", "Estado", "Descripcion", "Fecha"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);
		cargarTabla(dataModel);
		JButton btnVerDetalles = new JButton("Ver Detalles");
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerDetalles.setBounds(74, 231, 89, 23);
		add(btnVerDetalles);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Propuesta p = obtenerPropuestaSeleccionada();
				PropuestaDAO pDao = new PropuestaDAO();
				pDao.eliminar(p.getTitulo());
				cargarTabla(dataModel);
			}
		});
		btnEliminar.setBounds(221, 231, 89, 23);
		add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Propuesta p = obtenerPropuestaSeleccionada();
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) ae.getSource());
				marco.setContentPane(new PropuestaNuevoModificarPanel(p));
				marco.validate();
			}
		
		});
		btnModificar.setBounds(74, 265, 89, 23);
		add(btnModificar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFrame marco = 
						(JFrame) SwingUtilities.getWindowAncestor((JComponent) ae.getSource());
				marco.setContentPane(new PropuestaNuevoModificarPanel());
				marco.validate();
			}
		});
		btnCrear.setBounds(221, 265, 89, 23);
		add(btnCrear);
		
		JLabel lblListaPropuestas = new JLabel("Lista Propuestas");
		lblListaPropuestas.setBounds(161, 35, 89, 14);
		add(lblListaPropuestas);
	
	}
	
	private void cargarTabla(DefaultTableModel dataModel) {
		dataModel.setRowCount(0);
		PropuestaDAO pDao = new PropuestaDAO();
		propuestas = pDao.mostrarPropuestas();
		for (Propuesta propuesta : propuestas) {
			Object[] fila = new Object[] {propuesta.getTitulo(), propuesta.getAutor(),propuesta.getEstado(), propuesta.getDescripcion(), propuesta.getFecha()};
			dataModel.addRow(fila);
		}
	}
	
	private Propuesta obtenerPropuestaSeleccionada() {
		// TODO Mejorar (evitar relacionar el índice de la tabla con el índice del ArrayList)
		int filaSeleccionada = table.getSelectedRow();
		return propuestas.get(filaSeleccionada);
	}
}
