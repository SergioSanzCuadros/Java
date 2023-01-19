package CentroFormacion;

import java.io.Serializable;

public class Alumno implements Serializable {

	private int nExpediente;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String fechaNacimiento;
	private Curso c;
	
	public Alumno() {}
	
	public Alumno(Curso c) {
		this.c = c;
	}
	
	public Alumno(int nExpediente, String nombre, String apellidos, String direccion, String telefono, String fechaNacimiento, Curso c) {
		this.nExpediente = nExpediente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.c = c;
	}
	
	public int getNumeroExpediente() {
		return nExpediente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Curso getCurso(Curso c) {
		return c;
	}
	
	public void setNumeroExpediente(int nExpediente) {
		this.nExpediente = nExpediente;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setCurso(Curso c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Alumno [nExpediente=" + nExpediente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", c=" + c + "]";
	}
	
	
}
