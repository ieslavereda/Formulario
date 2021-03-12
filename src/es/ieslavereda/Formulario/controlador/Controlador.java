package es.ieslavereda.Formulario.controlador;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import es.ieslavereda.Formulario.modelo.Persona;
import es.ieslavereda.Formulario.modelo.Persona.Sexo;
import es.ieslavereda.Formulario.vistas.Formulario;

public class Controlador implements ActionListener {

	private Formulario vista;

	private ArrayList<Persona> personas;
	private int index;

	public Controlador(Formulario vista) {
		super();
		this.vista = vista;
		
		index = 0;
		personas = new ArrayList<Persona>();

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

		if (comando.equals("New")) {
			newPerson();
		} else if (comando.equals("Add")) {
			crearPersona();
			fieldsEnabled(false);
			vista.getButtonAdd().setEnabled(false);
			vista.getButtonNew().setEnabled(true);
			
			actualizarFormulario();

		}

	}

	private void actualizarFormulario() {
		
		Persona p = personas.get(index);
		
		
		
	}

	private void crearPersona() {

		Persona p;

		String name = vista.getTxtFieldName().getText();
		String surname = vista.getTxtFieldSurname().getText();
		String address = vista.getTxtFieldAddress().getText();
		String DNI = vista.getTxtFieldDNI().getText();
		String phone = vista.getTxtFieldPhone().getText();
		String city = vista.getComboBoxCity().getSelectedItem().toString();
		int age = vista.getComboBoxAge().getSelectedIndex() + 1;
		Sexo sexo;
		if (vista.getRdbtnMen().isSelected())
			sexo = Sexo.HOMBRE;
		else
			sexo = Sexo.MUJER;

		p = new Persona(name, surname, address, DNI, phone, city, age, sexo);

		personas.add(p);
	}

	private void newPerson() {

		fieldsEnabled(true);
		vista.getRdbtnMen().setSelected(true);

//		vista.getTxtFieldName().setEnabled(true);
//		vista.getTxtFieldSurname().setEnabled(true);
//		vista.getTxtFieldAddress().setEnabled(true);
//		vista.getTxtFieldDNI().setEnabled(true);
//		vista.getTxtFieldPhone().setEnabled(true);

	}

	private void fieldsEnabled(boolean b) {
		for (Component c : vista.getPanelDatos().getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setEnabled(b);
				((JTextField) c).setText("");
			}
			if (c instanceof JComboBox) {
				((JComboBox<?>) c).setEnabled(b);
				((JComboBox<?>) c).setSelectedIndex(0);
			}
		}
		vista.getRdbtnMen().setEnabled(b);
		vista.getRdbtnWomen().setEnabled(b);

		vista.getButtonAdd().setEnabled(b);
		vista.getButtonNew().setEnabled(!b);

	}

}
