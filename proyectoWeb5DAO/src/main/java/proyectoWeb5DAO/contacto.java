package proyectoWeb5DAO;

public class contacto {
	
	private String nombre;
	private String apellidos;
	
	public contacto(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "contacto [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	

}
