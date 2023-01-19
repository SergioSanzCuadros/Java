package CentroFormacion;

import java.io.Serializable;

public class Profesor implements Serializable {

	private String dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private Curso c;
	
	public Profesor() {}
	
	public Profesor(String dni, String nombre, String direccion, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public Curso getCurso() {
		return c;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setCurso(Curso c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Profesor [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}



	
	
}
