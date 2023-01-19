import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static String fichero1 = "agenda.txt";
	static String fichero2 = "agenda.ddr";
	static String fichero3 = "agenda.ser";
	
	static Scanner sc = new Scanner(System.in);
	static Ficheros f = new Ficheros();
	static ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
	
	public static void main(String[] args) {
		
		String opcion = "";
		
		while(!opcion.equals("0")) {
			opcion = menu();
			switch (opcion) {
				case "1":
					alta(listaContactos, fichero1, fichero2, fichero3);
					break;
				case "2":
					baja(listaContactos, fichero1, fichero2, fichero3);
					break;
				case "3":
					modificar(listaContactos, fichero1, fichero2, fichero3);
					break;
				case "4":
					buscar(fichero3);
					break;
				case "5":
					mostrar(fichero1);
					break;
				case "0":
					System.out.println("FIN DEL PROGRAMA");
					break;
				default:
					System.out.println("Opción no valida");
			}
		}
	}
	
	// MENU
	public static String menu() {
		
		System.out.println("AGENDA");
		System.out.println("-------------");
		System.out.println("0. SALIR");
		System.out.println("1. ALTA");
		System.out.println("2. BAJA");
		System.out.println("3. MODIFICACION");
		System.out.println("4. BUSCAR");
		System.out.println("5. MOSTRAR TODOS");
		System.out.println("Escoja una opción: ");
		String opcion = sc.next();
		
		return opcion;
	}
	
	// ALTA
	public static void alta(ArrayList<Contacto> listaContactos, String fichero1, String fichero2, String fichero3) {
		
		System.out.println("Introduce el nombre: ");
		String nombre = sc.next().trim();
		System.out.println("Introduce los apellidos: ");
		String apellidos = sc.next();
		System.out.println("Introduce la dirección: ");
		String direccion = sc.next().trim();
		System.out.println("Introduce el telefono: ");
		String telefono = sc.next().trim();
		System.out.println("Introduce la edad: ");
		int edad = -1;
		while(edad == 1) {
			try {
				edad = Integer.parseInt(sc.next().trim());
			} catch(Exception e) {}
		}
		
		Contacto c = new Contacto(nombre, apellidos, direccion, telefono, edad);
		listaContactos.add(c);
		
		f.ficherosTexto(fichero1, c.toString());
		f.ficherosBinarios(fichero2, c.toString());
		f.ficherosSerializables(fichero3, listaContactos);
		
		System.out.println("Alta realizada con éxito");
	}
	
	// BAJA
	public static void baja(ArrayList<Contacto> listaContactos, String fichero1, String fichero2, String fichero3) {
		
		System.out.println("Introduce los apellidos que deseas eliminar: ");
		String apellidos = sc.next().trim();
		boolean encontrado = false;
		
		for(int i = 0; i < listaContactos.size(); i++) {
			Contacto c = listaContactos.get(i);
			if(c.getApellidos().equalsIgnoreCase(apellidos)) {
				System.out.println(c);
				System.out.println("¿Estás seguro?(s/n): ");
				String opcion = sc.next().trim();
				listaContactos.remove(i);
				System.out.println("Contacto eliminado");
			}
			encontrado = true;
		}
		
		if(!encontrado) {
			System.out.println("Contacto no encontrado");
		}
		
		f.eliminarFichero(fichero1);
		f.eliminarFichero(fichero2);
		
		for(Contacto c : listaContactos) {
			f.ficherosTexto(fichero1, c.toString());
			f.ficherosBinarios(fichero2, c.toString());
		}
		
		f.ficherosSerializables(fichero3, listaContactos);
	}
	
	// MODIFICAR
	public static void modificar(ArrayList<Contacto> listaContactos, String fichero1, String fichero2, String fichero3) {
		
		System.out.println("Introduce apellidos que deseas modificar: ");
		String apellidos = sc.next();
		boolean encontrado = false;
		
		for(Contacto c : listaContactos) {
			if(c.getApellidos().trim().equalsIgnoreCase(apellidos)) {
				System.out.println(c);
				System.out.println("¿Estás seguro?(s/n): ");
				String opcion = sc.next().trim();
				if(opcion.equalsIgnoreCase("SI") || opcion.equalsIgnoreCase("s")) {
					// Nuevo Nombre
					System.out.println("Introduce nuevo nombre: ");
					String nuevoNombre = sc.next().trim();
					if(nuevoNombre.equals(null)) {
						nuevoNombre = c.getNombre();
					} else {
						c.setNombre(nuevoNombre);
					}
					
					// Nuevo Apellidos
					System.out.println("Introduce nuevos apellidos: ");
					String nuevoApellidos = sc.next().trim();
					if(nuevoApellidos.equals(null)) {
						nuevoApellidos = c.getApellidos();
					} else {
						c.setApellidos(nuevoApellidos);
					}
					
					// Nuevo Direccion
					System.out.println("Introduce nueva dirección: ");
					String nuevoDireccion = sc.next().trim();
					if(nuevoDireccion.equals(null)) {
						nuevoDireccion = c.getDireccion();
					} else {
						c.setDireccion(nuevoDireccion);
					}
					
					// Nuevo Telefono
					System.out.println("Introducenuevo telefono: ");
					String nuevoTelefono = sc.next().trim();
					if(nuevoTelefono.equals(null)) {
						nuevoTelefono = c.getTelefono();
					} else {
						c.setTelefono(nuevoTelefono);
					}
					
					// Nuevo Edad
					System.out.println("Introduce nueva edad: ");
					int nuevoEdad = Integer.parseInt(sc.next().trim());
					c.setEdad(nuevoEdad);
				}
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			System.out.println("Contacto no encontrado");
		}
		
		f.eliminarFichero(fichero1);
		f.eliminarFichero(fichero2);
		
		for(Contacto c : listaContactos) {
			f.ficherosTexto(fichero1, c.toString());
			f.ficherosBinarios(fichero2, c.toString());
		}
		
		f.ficherosSerializables(fichero3, listaContactos);
		
		System.out.println("Contacto modificado con exito");
	}
	
	// BUSCAR
	public static void buscar(String fichero) {
		
		try {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.println("Introduce los apellidos a buscar: ");
			String apellidos = sc.next().trim();
			boolean encontrado = false;
			
			ArrayList<Contacto> listaContactos = (ArrayList<Contacto>)ois.readObject();
			
			for(Contacto c : listaContactos) {
				if(c.getApellidos().equals(apellidos)) {
					System.out.println(c);
					System.out.println("Contacto encontrado");
				}
				encontrado = true;
			}
			
			if(!encontrado) {
				System.out.println("Contacto no existe");
			}
		} catch(Exception e) {
			System.out.println("ERROR, no se enccuentra CONTACTO");
		}
	}
	
	// MOSTRAR
	public static void mostrar(String fichero) {
		
		f.leerFicheroTexto(fichero);
	}
}
