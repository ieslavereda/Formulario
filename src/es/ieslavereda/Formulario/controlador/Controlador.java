package es.ieslavereda.Formulario.controlador;

import java.awt.Component;
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
			add();
		}

	}

	private void add() {
		crearPersona();
		fieldsEnabled(false);
					
		actualizarFormulario();		
	}

	private void actualizarFormulario() {
		
		Persona p = personas.get(index);	
		
		vista.getTxtFieldName().setText(p.getName());
		vista.getTxtFieldSurname().setText(p.getSurname());
		vista.getTxtFieldAddress().setText(p.getAddress());
		vista.getTxtFieldDNI().setText(p.getDNI());
		vista.getTxtFieldPhone().setText(p.getPhone());
		vista.getComboBoxCity().setSelectedItem(p.getCity());
		vista.getComboBoxAge().setSelectedIndex(p.getAge()-1);
		vista.getRdbtnMen().setSelected(p.getSexo().equals(Sexo.HOMBRE));
		vista.getRdbtnWomen().setSelected(p.getSexo().equals(Sexo.MUJER));
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
