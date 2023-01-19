import java.io.Serializable;

public class Usuario implements Serializable{

	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private int edad;
	
	public Usuario(String nombre, String apellido, String direccion, String telefono, int edad) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public String getApellido() {
		
		return apellido;
	}
	
	public String getDireccion() {
		
		return direccion;
	}
	
	public String getTelefono() {
		
		return telefono;
	}
	
	public int getEdad() {
		
		return edad;
	}
	
	public void nombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void apellido(String apellido) {
		
		this.apellido = apellido;
	}
	
	public void direccion(String direccion) {
		
		this.direccion = direccion;
	}
	
	public void telefono(String telefono) {
		
		this.telefono = telefono;
	}
	
	public void edad(int edad) {
		
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono="
				+ telefono + ", edad=" + edad + "]";
	}
	
}