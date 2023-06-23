package app;


import javax.swing.JFrame;

import vista.EstudianteAltaEdicionPanel;
import vista.EstudiantePanel;

public class App {

	public static void main(String[] args) {
		JFrame marco = new JFrame();
		marco.setBounds(0, 0, 800, 600);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setContentPane(new EstudiantePanel());
		marco.validate();
	}

}
