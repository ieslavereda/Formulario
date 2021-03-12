package es.ieslavereda.Formulario;

import java.awt.EventQueue;

import es.ieslavereda.Formulario.controlador.Controlador;
import es.ieslavereda.Formulario.vistas.Formulario;

public class App {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					Controlador controlador = new Controlador(frame);
					controlador.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
