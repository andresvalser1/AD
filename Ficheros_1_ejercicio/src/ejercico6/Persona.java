package ejercico6;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private StringBuilder nombre ;
	private StringBuilder apellido1 ;
	private StringBuilder apellido2 ;
	private Date nacimiento;
	
	public Persona() {
		
	}
	public Persona(StringBuilder nombre, StringBuilder apellido1, StringBuilder apellido2, Date nacimiento) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nacimiento = nacimiento;
	}
	public StringBuilder getNombre() {
		return nombre;
	}
	public void setNombre(StringBuilder nombre) {
		this.nombre = nombre;
	}
	public StringBuilder getApellido1() {
		return apellido1;
	}
	public void setApellido1(StringBuilder apellido1) {
		this.apellido1 = apellido1;
	}
	public StringBuilder getApellido2() {
		return apellido2;
	}
	public void setApellido2(StringBuilder apellido2) {
		this.apellido2 = apellido2;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public String toString() {
		return "\tNombre y Apellidos: \t"+ nombre + " " + apellido1 + " " + apellido2 + "\n\tfecha nacimiento: \t"
				+ new SimpleDateFormat("dd/MM/yyyy").format(nacimiento) + "\n";
	}
	
	

}
