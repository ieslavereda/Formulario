package es.ieslavereda.Formulario.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
	
	private String name;
	private String surname;
	private String address;
	private String DNI;
	private String phone;
	private String city;
	private LocalDate birthday;
	private Sexo sexo;
	
	public static enum Sexo {
		HOMBRE, MUJER
	}

	public Persona(String name, String surname, String address, String dNI, String phone, String city, LocalDate birthday,
			Sexo sexo) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		DNI = dNI;
		this.phone = phone;
		this.city = city;
		this.birthday = birthday;
		this.sexo = sexo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", address=" + address + ", DNI=" + DNI + ", phone="
				+ phone + ", city=" + city + ", birthday=" + birthday + ", sexo=" + sexo + "]";
	}
	

}
