package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.PropuestaPanel;

public class App {

	public static void main(String[] args) {
		
		JFrame marco = new JFrame();
		marco.setBounds(0, 0, 800, 600);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setContentPane(new PropuestaPanel());
		marco.validate();
	}

}

	/**
	 * Create the frame.
	 */

