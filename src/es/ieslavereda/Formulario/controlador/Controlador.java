package es.ieslavereda.Formulario.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.ieslavereda.Formulario.modelo.Persona;
import es.ieslavereda.Formulario.modelo.Persona.Sexo;
import es.ieslavereda.Formulario.vistas.Formulario;
import es.ieslavereda.Formulario.vistas.VistaTabla;

public class Controlador implements ActionListener {

	private Formulario vista;
	private VistaTabla vistaTabla;

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
		vista.getMntmOpen().addActionListener(this);
		vista.getMntmSave().addActionListener(this);
		vista.getMntmTabla().addActionListener(this);
		
		// Add ActionCommand
		vista.getButtonPrevious().setActionCommand("Previous");
		vista.getButtonNext().setActionCommand("Next");
		vista.getButtonNew().setActionCommand("New");
		vista.getButtonAdd().setActionCommand("Add");
		vista.getMntmOpen().setActionCommand("Open");
		vista.getMntmSave().setActionCommand("Save");
		vista.getMntmTabla().setActionCommand("Tabla");
		

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
		} else if (comando.equals("Next")) {			
			next();
		} else if (comando.equals("Previous")) {			
			previous();
		} else if (comando.equals("Save")) {
			save();
		} else if (comando.equals("Open")) {
			open();
		} else if (comando.equals("Tabla")) {
			tabla();
		} else if (comando.equals("Delete row")) {
			deleteRow();
		}
		

	}

	private void deleteRow() {
		
		int fila = vistaTabla.getTable().getSelectedRow();
		
		if(fila ==-1) {
			JOptionPane.showMessageDialog(vista, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			int opcion = JOptionPane.showConfirmDialog(vista, "¿Esta seguro de eliminar la fila seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
			
			if(opcion == JOptionPane.YES_OPTION) {
				
				vistaTabla.getDtm().removeRow(fila);
				personas.remove(fila);
				index--;
				actualizarFormulario();
				
			}
		}
		
	}

	private void tabla() {
		
		vistaTabla = new VistaTabla();
		
		vistaTabla.getBtnDelete().addActionListener(this);
		vistaTabla.getBtnDelete().setActionCommand("Delete row");
		
		vistaTabla.setVisible(true);
		
		int i=0;
		for(Persona persona : personas) {
			vistaTabla.getDtm().addRow(new String[] {
				String.valueOf(i),
				persona.getDNI(),
				persona.getName(),
				persona.getSurname()
			});
			i++;
		}
		
//		Vector<String> fila;
//		for(Persona persona : personas) {
//			
//			fila = new Vector<String>();
//			
//			fila.add(String.valueOf(i));
//			fila.add(persona.getDNI());
//			fila.add(persona.getName());
//			fila.add(persona.getSurname());
//			
//			tabla.getDtm().addRow(fila);
//			
//			i++;
//		}
		
	}

	private void open() {
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("Formulario file", "app", "miapp"));
		
		int opcion = jfc.showOpenDialog(vista);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()))){
				
				personas = (ArrayList<Persona>)ois.readObject();
				
				index=0;
				
				actualizarFormulario();
				
				if(index<personas.size()-1)
					vista.getButtonNext().setEnabled(true);
				
				if(index>0)
					vista.getButtonPrevious().setEnabled(true);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	private void save() {
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("Formulario file", "app", "miapp"));
		
		int opcion = jfc.showSaveDialog(vista);
		
		if(opcion==JFileChooser.APPROVE_OPTION) {
			
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(jfc.getSelectedFile()))){
				
				oos.writeObject(personas);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		
	}

	private void next() {
		
		vista.getButtonPrevious().setEnabled(true);
		
		index++;
		
		if(index==personas.size()-1)
			vista.getButtonNext().setEnabled(false);
		
		actualizarFormulario();
	}
	private void previous() {
		
		vista.getButtonNext().setEnabled(true);
		
		index--;
		
		if(index==0)
			vista.getButtonPrevious().setEnabled(false);
		
				
		actualizarFormulario();
			
	}

	private void add() {
		
		crearPersona();
		fieldsEnabled(false);					
		actualizarFormulario();
		
		if(index<personas.size()-1)
			vista.getButtonNext().setEnabled(true);
		
		if(index>0)
			vista.getButtonPrevious().setEnabled(true);
		
		
	}

	private void actualizarFormulario() {
		
		Persona p = personas.get(index);	
		
		vista.getTxtFieldName().setText(p.getName());
		vista.getTxtFieldSurname().setText(p.getSurname());
		vista.getTxtFieldAddress().setText(p.getAddress());
		vista.getTxtFieldDNI().setText(p.getDNI());
		vista.getTxtFieldPhone().setText(p.getPhone());
		vista.getComboBoxCity().setSelectedItem(p.getCity());
		vista.getRdbtnMen().setSelected(p.getSexo().equals(Sexo.HOMBRE));
		vista.getRdbtnWomen().setSelected(p.getSexo().equals(Sexo.MUJER));
		vista.getDatePicker().setDate(p.getBirthday());
	}

	private void crearPersona() {

		Persona p;

		String name = vista.getTxtFieldName().getText();
		String surname = vista.getTxtFieldSurname().getText();
		String address = vista.getTxtFieldAddress().getText();
		String DNI = vista.getTxtFieldDNI().getText();
		String phone = vista.getTxtFieldPhone().getText();
		String city = vista.getComboBoxCity().getSelectedItem().toString();
		LocalDate birthday = vista.getDatePicker().getDate();
		Sexo sexo;
		if (vista.getRdbtnMen().isSelected())
			sexo = Sexo.HOMBRE;
		else
			sexo = Sexo.MUJER;

		p = new Persona(name, surname, address, DNI, phone, city, birthday, sexo);

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
		
		vista.getButtonNext().setEnabled(false);
		vista.getButtonPrevious().setEnabled(false);

	}

}
