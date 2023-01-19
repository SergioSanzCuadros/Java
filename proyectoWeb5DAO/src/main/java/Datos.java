import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Datos {
	String URL = "jdbc:mariadb://localhost:3306/";
	String USER = "root";
	String CLAVE = "alumno";
	Connection con = null;
	
	public Datos() {
		try{
		    //Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.mariadb.jdbc.Driver");
		    con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
		    crearBaseDatos();
		}catch(Exception e){
		    System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void crearBaseDatos() {
		try{
			  Statement s = con.createStatement();
			  s.executeUpdate("create database if not exists proyectoWebDAO");
			  s.executeUpdate("use proyectoWebDAO");
			  
			  s.executeUpdate("create table if not exists contactos(nombre varchar(25), apellidos varchar(50))");
			  s.close();
		}catch(Exception e){
		    System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void insertar(String nombre, String apellidos) {
		
		try{
			  Statement s = con.createStatement();
			  s.executeUpdate("INSERT INTO contactos values ('"+nombre+"','"+apellidos+"')");
			  s.close();
		}catch(Exception e){
		    System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void baja(String apellidos) {
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate("DELETE FROM contactos WHERE apellidos='"+apellidos+"')");
		} catch(Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	public void modificar(String apellidos) {
		
		try {
			Statement s = con.createStatement();
			s.executeUpdate("UPDATE FROM contactos WHERE apellidos='"+apellidos+"')");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<String[]> consultarTodo() {
		ArrayList<String[]> lista = new ArrayList<String[]>();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from contactos");
			
			while (rs.next()) {
				String campos[] = new String[2];
				campos[0] = rs.getString(1);
				campos[1] = rs.getString(2);
				lista.add(campos);
			}
			rs.close();
			s.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			lista = null;
		}
		return lista;
	}
	
	public void cerrar() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
