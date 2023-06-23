package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.TPFinalDAO;
import modelo.Propuesta;

public class PropuestaPanel extends JPanel {
	private JTable table;
	private ArrayList<Propuesta> propuestas;
	/**
	 * Create the panel.
	 */
	public PropuestaPanel() {
		setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(62, 232, 89, 23);
		add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(272, 232, 89, 23);
		add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(62, 266, 89, 23);
		add(btnActualizar);
		
		JButton btnVerDetalle = new JButton("Ver Detalle");
		btnVerDetalle.setBounds(272, 266, 89, 23);
		add(btnVerDetalle);
		
		JLabel lblNewLabel = new JLabel("Propuestas");
		lblNewLabel.setBounds(182, 11, 98, 26);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 48, 236, 159);
		add(scrollPane);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo"
			}
		);
		table.setModel(dataModel);
		scrollPane.setViewportView(table);

	}
	
}
