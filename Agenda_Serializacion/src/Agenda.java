import java.util.*;

import java.io.*;

public class Agenda {

	static Scanner tec = new Scanner(System.in);
	static ArrayList<Usuario> agenda = new ArrayList<Usuario>();
	static Usuario user;
	
	public static void main(String[] args) {
		
		String opcion="";
		
		while(!opcion.equals("0")) {
			opcion=menu();
			switch(opcion) {
			
			case "1":
				System.out.println("Alta");
				alta(agenda, "agenda.ser");
				break;
			case "2":
				System.out.println("Baja");
				baja(agenda, "agenda.ser");
				break;
			case "3":
				System.out.println("Buscar");
				buscar("agenda.ser");
				break;
			case "4":
				System.out.println("Modificar");
				modificar(agenda, "agenda.ser");
				break;
			case "5":
				System.out.println("Mostrar todos");
				mostrarTodos(agenda);
				break;
			case "6":
				System.out.println("Leer");
				leer(agenda, "agenda.ser");
				break;
			case "0":
				System.out.println("PROGRAMA FINALIZADO");
				break;
			}
		}
	}
	
	public static String menu() {
		System.out.println("---AGENDA SERIALIZABLE---");
		System.out.println("1. ALTA");
		System.out.println("2. BAJA");
		System.out.println("3. BUSQUEDA");
		System.out.println("4. MODIFICAR");
		System.out.println("5. MOSTRAR TODOS");
		System.out.println("6. LEER");
		System.out.println("0. SALIR");
		
		System.out.println("Introduce una opcion: ");
		String numOpcion = tec.nextLine();
		
		return numOpcion;
	}
	
	public static void alta(ArrayList<Usuario> agenda, String fichero) {
		
		System.out.print("Nombre: ");
		String nombre = tec.nextLine();
		System.out.print("Apellidos: ");
		String apellido = tec.nextLine();
		System.out.print("Direccion: ");
		String direccion = tec.nextLine();
		System.out.print("Telefono: ");
		String telefono = tec.nextLine();
		System.out.print("Edad: ");
		int edad = -1;
		while(edad == -1) {
			try {
				edad = tec.nextInt();
			}
			catch(Exception e) {
				
			}
		}
		
		user = new Usuario(nombre, apellido, direccion, telefono, edad);
		agenda.add(user);
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			oos.writeObject(agenda);
			
			oos.close();
			fos.close();
			
			System.out.println("Contacto creado y guardado...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void baja(ArrayList<Usuario> agenda, String fichero) {

		try {
			File file = new File(fichero);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			System.out.println("Introduce el apellido: ");
			String apellido = tec.nextLine();
			
			boolean encontrado = false;
			
			for(Usuario u : agenda) {
				if(u.getApellido().trim().equalsIgnoreCase(apellido)) {
					System.out.println("Estas seguro de que deseas borrar (s/n): ");
					String respuesta = tec.nextLine();
					if(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s")) {
						agenda.remove(u);
						System.out.println("Usuario eliminado");
					}
					encontrado = true;	
				}
			}
			
			if(!encontrado) {
				System.out.println("No se borro el usuario");
			}
			
			oos.writeObject(agenda);

			oos.close();
			fos.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public static void modificar(ArrayList<Usuario> agenda, String fichero) {
		
		try {
			File file = new File(fichero);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			System.out.print("Introduce el apellido: ");
			String apellido = tec.nextLine();

			boolean encontrado = false;
			
			for(Usuario u : agenda) {
				if(u.getApellido().trim().equalsIgnoreCase(apellido)) {
					System.out.print("Introduce el nuevo apellido: ");
					String nuevo = tec.nextLine();
					u.apellido(nuevo);
					
					encontrado = true;	
				}
			}
			System.out.println("Apellido modificado con exito");
			
			if(!encontrado) {
				System.out.println("No se encontro el usuario");
			}
			
			oos.writeObject(agenda);
			oos.close();
			fos.close();
		}
		catch(Exception e) {
			
		}
	}
	
	/*public static void buscar(ArrayList<Usuario> agenda) {
		
		System.out.print("Introduce el apellido del usuario: ");
		String apellido = tec.nextLine();
		boolean encontrado = false;
		
		for(Usuario u : agenda) {
			if(u.getApellido().trim().equalsIgnoreCase(apellido)) {
				System.out.println(u);
				System.out.println("Usuario encontrado.");
			}
			encontrado = true;
		}
		
		if(!encontrado) {
			System.out.println("No se ha encontrado el usuario");
		}
	}*/
	
	public static void buscar(String fichero) {
		
		try {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.print("Introduce el apellido del usuario: ");
			String apellido = tec.nextLine();
			boolean encontrado = false;
			
			for(Usuario u : agenda) {
				u = (Usuario) ois.readObject();
				if(u.getApellido().trim().equalsIgnoreCase(apellido)) {
					System.out.println(u);
					encontrado = true;
				}
				ois.close();
				fis.close();	
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public static void mostrarTodos(ArrayList<Usuario> agenda) {
		
		for(Usuario u : agenda) {
			System.out.println(u.toString());
		}
	}
	
	public static void leer(ArrayList<Usuario> agenda, String fichero) {
			
		try {
				
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
				
			agenda = (ArrayList<Usuario>) ois.readObject();
			System.out.println(agenda);
				
			ois.close();
			fis.close();
		}
		catch(Exception e) {
			System.out.println("No se pudo leer el fichero.");
		}

	}
	
}
