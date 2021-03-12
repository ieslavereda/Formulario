package es.ieslavereda.Formulario.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldName;
	private JTextField txtFieldSurname;
	private JTextField txtFieldAddress;
	private JTextField txtFieldDNI;
	private JTextField txtFieldPhone;
	private DefaultComboBoxModel<String> dcmCity;
	private DefaultComboBoxModel<Integer> dcmAge;
	private JComboBox<Integer> comboBoxAge;
	private JComboBox comboBoxCity;
	private JRadioButton rdbtnWomen;
	private JRadioButton rdbtnMen;
	private JButton buttonAdd;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton buttonNew;
	private JPanel panelDatos;

	/**
	 * Create the frame.
	 */
	public Formulario() {
		
		String[] city = new String[] {"Madrid","Almería","Cádiz","Córdoba","Granada","Huelva","Jaén","Málaga","Sevilla","Huesca","Teruel","Zaragoza","Asturias","Baleares","LasPalmas","Santa Cruz de Tenerife","Cantabria","Albacete","Ciudad Real","Cuenca","Guadalajara","Toledo","Ávila","Burgos","León","Palencia","Salamanca","Segovia","Soria","Valladolid","Zamora","Barcelona","Gerona","Lérida","Tarragona","Alicante","Castellón","Valencia","Badajoz","Cáceres","La Coruña","Lugo","Orense","Pontevedra","La Rioja","Regiónde Murcia","Navarra","Álava","Guipúzcoa","Vizcaya"};
		Vector<String> vCity = new Vector<String>();
		for(String c : city)
			vCity.add(c);
		vCity.sort((c1,c2)->c1.compareToIgnoreCase(c2));
		
		dcmCity = new DefaultComboBoxModel<String>(vCity);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setEnabled(false);
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDatos = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panelDatos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		buttonPrevious = new JButton("<");
		buttonPrevious.setEnabled(false);
		panel_1.add(buttonPrevious);
		
		buttonNext = new JButton(">");
		buttonNext.setEnabled(false);
		panel_1.add(buttonNext);
		
		buttonNew = new JButton("New");
		panel_1.add(buttonNew);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		buttonAdd = new JButton("Add");
		buttonAdd.setEnabled(false);
		panel_2.add(buttonAdd);
		panelDatos.setLayout(new MigLayout("", " [71.00][grow][][]", "[][31.00][31.00][31.00][29.00][23.00][24.00]"));
		
		JLabel lblName = new JLabel("Name");
		panelDatos.add(lblName, "cell 0 1,alignx trailing");
		
		txtFieldName = new JTextField();
		txtFieldName.setEnabled(false);
		panelDatos.add(txtFieldName, "cell 1 1 3 1,growx");
		txtFieldName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Surname");
		panelDatos.add(lblNewLabel, "cell 0 2,alignx trailing");
		
		txtFieldSurname = new JTextField();
		txtFieldSurname.setEnabled(false);
		panelDatos.add(txtFieldSurname, "cell 1 2 3 1,growx");
		txtFieldSurname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		panelDatos.add(lblAddress, "cell 0 3,alignx trailing");
		
		txtFieldAddress = new JTextField();
		txtFieldAddress.setEnabled(false);
		panelDatos.add(txtFieldAddress, "cell 1 3 3 1,growx");
		txtFieldAddress.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		panelDatos.add(lblCity, "cell 0 4,alignx trailing");
		
		comboBoxCity = new JComboBox();
		comboBoxCity.setEnabled(false);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Valencia", "Madrid", "Barcelona"}));
		comboBoxCity.setModel(dcmCity);
		panelDatos.add(comboBoxCity, "cell 1 4,growx");
		
		JLabel lblDni = new JLabel("DNI");
		panelDatos.add(lblDni, "cell 0 5,alignx trailing");
		
		txtFieldDNI = new JTextField();
		txtFieldDNI.setEnabled(false);
		panelDatos.add(txtFieldDNI, "cell 1 5,growx");
		txtFieldDNI.setColumns(10);
		
		JLabel lblYears = new JLabel("Age");
		panelDatos.add(lblYears, "cell 2 5,alignx trailing");
		
		comboBoxAge = new JComboBox<Integer>();
		comboBoxAge.setEnabled(false);
		dcmAge = new DefaultComboBoxModel<Integer>();
		comboBoxAge.setModel(dcmAge);
		panelDatos.add(comboBoxAge, "cell 3 5,growx");
		
		JLabel lblPhone = new JLabel("Phone");
		panelDatos.add(lblPhone, "cell 0 6,alignx trailing");
		
		txtFieldPhone = new JTextField();
		txtFieldPhone.setEnabled(false);
		panelDatos.add(txtFieldPhone, "cell 1 6,growx");
		txtFieldPhone.setColumns(10);		
		
		rdbtnMen = new JRadioButton("Men");
		rdbtnMen.setEnabled(false);
		panelDatos.add(rdbtnMen, "cell 2 6");
		
		rdbtnWomen = new JRadioButton("Women");
		rdbtnWomen.setEnabled(false);
		panelDatos.add(rdbtnWomen, "cell 3 6");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnWomen);
		bg.add(rdbtnMen);
		
		rdbtnMen.setSelected(true);		
		
		contentPane.setLayout(gl_contentPane);
		
		inicializar();
	}

	private void inicializar() {
		
		for(int i=1;i<=100;i++)
			dcmAge.addElement(i);
		
		dcmAge.setSelectedItem(18);
		
	}

	public void setTxtFieldName(JTextField txtFieldName) {
		this.txtFieldName = txtFieldName;
	}

	public void setTxtFieldSurname(JTextField txtFieldSurname) {
		this.txtFieldSurname = txtFieldSurname;
	}

	public void setTxtFieldAddress(JTextField txtFieldAddress) {
		this.txtFieldAddress = txtFieldAddress;
	}

	public void setTxtFieldDNI(JTextField txtFieldDNI) {
		this.txtFieldDNI = txtFieldDNI;
	}

	public void setTxtFieldPhone(JTextField txtFieldPhone) {
		this.txtFieldPhone = txtFieldPhone;
	}

	public void setDcmCity(DefaultComboBoxModel<String> dcmCity) {
		this.dcmCity = dcmCity;
	}

	public void setDcmAge(DefaultComboBoxModel<Integer> dcmAge) {
		this.dcmAge = dcmAge;
	}

	public void setComboBoxAge(JComboBox<Integer> comboBoxAge) {
		this.comboBoxAge = comboBoxAge;
	}

	public void setComboBoxCity(JComboBox comboBoxCity) {
		this.comboBoxCity = comboBoxCity;
	}

	public void setRdbtnWomen(JRadioButton rdbtnWomen) {
		this.rdbtnWomen = rdbtnWomen;
	}

	public void setRdbtnMen(JRadioButton rdbtnMen) {
		this.rdbtnMen = rdbtnMen;
	}

	public JButton getButtonAdd() {
		return buttonAdd;
	}

	public void setButtonAdd(JButton buttonAdd) {
		this.buttonAdd = buttonAdd;
	}

	public JButton getButtonPrevious() {
		return buttonPrevious;
	}

	public void setButtonPrevious(JButton buttonPrevious) {
		this.buttonPrevious = buttonPrevious;
	}

	public JButton getButtonNext() {
		return buttonNext;
	}

	public void setButtonNext(JButton buttonNext) {
		this.buttonNext = buttonNext;
	}

	public JButton getButtonNew() {
		return buttonNew;
	}

	public void setButtonNew(JButton buttonNew) {
		this.buttonNew = buttonNew;
	}

	public JTextField getTxtFieldName() {
		return txtFieldName;
	}

	public JTextField getTxtFieldSurname() {
		return txtFieldSurname;
	}

	public JTextField getTxtFieldAddress() {
		return txtFieldAddress;
	}

	public JTextField getTxtFieldDNI() {
		return txtFieldDNI;
	}

	public JTextField getTxtFieldPhone() {
		return txtFieldPhone;
	}

	public DefaultComboBoxModel<String> getDcmCity() {
		return dcmCity;
	}

	public DefaultComboBoxModel<Integer> getDcmAge() {
		return dcmAge;
	}

	public JComboBox<Integer> getComboBoxAge() {
		return comboBoxAge;
	}

	public JComboBox getComboBoxCity() {
		return comboBoxCity;
	}

	public JRadioButton getRdbtnWomen() {
		return rdbtnWomen;
	}

	public JRadioButton getRdbtnMen() {
		return rdbtnMen;
	}

	public JPanel getPanelDatos() {
		return panelDatos;
	}
	
	
	
}
