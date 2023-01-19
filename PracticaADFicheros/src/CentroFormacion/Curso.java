package CentroFormacion;

import java.io.Serializable;

public class Curso implements Serializable {

	private static int codigo=0;
	private String nombre;
	private String descripcion;
	private Profesor p;
	
	public Curso() {
		incrementarCodigo();
	}
	
	public Curso(String nombre, String descripcion/*, Profesor p*/) {
		this.codigo = getCodigo();
		this.nombre = nombre;
		this.descripcion = descripcion;
		incrementarCodigo();
		//this.p = p;
	}
	
	private static void incrementarCodigo() {
		codigo++;
	}
	
	public static int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	/*public Profesor getProfesor() {
		return p;
	}*/
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*public void setProfesor(Profesor p) {
		this.p = p;
	}*/
	
	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
