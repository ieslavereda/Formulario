package es.ieslavereda.Formulario.controlador;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import es.ieslavereda.Formulario.vistas.Formulario;

public class Controlador implements ActionListener {
	
	private Formulario vista;

	public Controlador(Formulario vista) {
		super();
		this.vista = vista;
		
		inicializar();
	}

	private void inicializar() {
		
		// Add ActionListener
		vista.getButtonPrevious().addActionListener(this);
		vista.getButtonNext().addActionListener(this);
		vista.getButtonNew().addActionListener(this);
		vista.getButtonAdd().addActionListener(this);
		
		// Add ActionCommand
		vista.getButtonPrevious().setActionCommand("Previous");
		vista.getButtonNext().setActionCommand("Next");
		vista.getButtonNew().setActionCommand("New");
		vista.getButtonAdd().setActionCommand("Add");
		
	}

	public void go() {
		vista.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		
		if(comando.equals("New")) {
			newPerson();
		} else if(comando.equals("Add")) {
			
		}
		
		
	}

	private void newPerson() {
		
		fieldsEnabled(true);
			
		vista.getRdbtnMen().setEnabled(true);
		vista.getRdbtnMen().setSelected(true);
		vista.getRdbtnWomen().setEnabled(true);
		vista.getButtonAdd().setEnabled(true);
		vista.getButtonNew().setEnabled(false);
//		vista.getTxtFieldName().setEnabled(true);
//		vista.getTxtFieldSurname().setEnabled(true);
//		vista.getTxtFieldAddress().setEnabled(true);
//		vista.getTxtFieldDNI().setEnabled(true);
//		vista.getTxtFieldPhone().setEnabled(true);


	}

	private void fieldsEnabled(boolean b) {
		for ( Component c : vista.getPanelDatos().getComponents()) {
			if(c instanceof JTextField) {
				((JTextField)c).setEnabled(b);
				((JTextField)c).setText("");
			}
			if(c instanceof JComboBox) {
				((JComboBox<?>)c).setEnabled(b);
				((JComboBox<?>)c).setSelectedIndex(0);
			}
		}
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}






