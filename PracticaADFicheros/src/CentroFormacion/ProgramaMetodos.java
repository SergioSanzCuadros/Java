package CentroFormacion;

import java.io.*;
import java.util.*;

public class ProgramaMetodos {

	Scanner tec = new Scanner(System.in);
	ArrayList<Profesor> profesorado = new ArrayList<Profesor>();
	
	// ------------------- PROFESOR
	
	// Dar de alta a un profesor
	public void altaProfesor(ArrayList<Profesor> profesorado, String fichero) {
		
		System.out.println("Introduce el DNI: "); // Introducir DNI
		String dni = tec.nextLine();
		System.out.println("Introduce el nombre: "); // Introducir nombre
		String nombre = tec.nextLine();
		System.out.println("Introduce la direccion: "); // Introducir direccion
		String direccion = tec.nextLine();
		System.out.println("Introduce el telefono: "); // Introducir telefono
		String telefono = tec.nextLine();
		
		Profesor p = new Profesor(dni, nombre, direccion, telefono);
		profesorado.add(p);
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(p); // Guardar profesor en un fichero
			
			oos.close();
			fos.close();
			
			System.out.println("Profesor dado de alta."); // Mensaje de alta exitosa
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Dar de baja a un profesor
	public void bajaProfesor(ArrayList<Profesor> profesorado, String fichero) {
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			System.out.println("Introduce el DNI del profesor: ");
			String dni = tec.nextLine();
			boolean encontrado = false;
			
			for(Profesor p : profesorado) {
				if(p.getDNI().trim().equals(dni)) {
					System.out.println(p);
					System.out.println("¿Estas seguro de que quieres dar de baja a este profesor (s/n)?");
					String respuesta = tec.nextLine();
					if(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("s")) {
						profesorado.remove(p);
						System.out.println("Profesor dado de baja");
					}
					encontrado = true;
				}
			}
			
			if(!encontrado) {
				System.out.println("Profesor no localizado");
			}
			
			oos.writeObject(profesorado); //Sobreescribir el listado de profesores
			
			oos.close();
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Modificar el DNI de un profesor
	public void modificarProfesor(ArrayList<Profesor> profesorado, String fichero) {
		
		System.out.println("Introduzca el DNI del profesor: ");
		String dni = tec.nextLine();
		boolean encontrado = false;
		
		for(Profesor p : profesorado) {
			if(p.getDNI().trim().equals(dni)) {
				System.out.println(p);
				System.out.println("¿Estas seguro de que desea modificar (s/n)?");
				String respuesta = tec.nextLine();
				if(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("s")) {
					System.out.println("Introduce el nuevo DNI: ");
					String dniNuevo = tec.nextLine();
					p.setDNI(dniNuevo);
					System.out.println("Se ha modificado correctamente.");
				}
				encontrado = true;
			}	
		}
		
		if(!encontrado) {
			System.out.println("Profesor no modificado.");
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(profesorado);
			
			oos.close();
			fos.close();
		}
		catch(Exception e) {}
	}
	
	// Mostrar listado de profesores
	public void mostrarProfesorado(ArrayList<Profesor> profesorado) {
		
		for(Profesor p : profesorado) {
			System.out.println(p.toString());
		}
	}
	
	public void consultar(ArrayList<Profesor> profesorado, String fichero) {
		
	}
	// Leer el listado de los profesores desde el fichero
	public void leerProfesorado(ArrayList<Profesor> profesorado, String fichero) {
		
		try {
			FileInputStream fis = new FileInputStream(fichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			profesorado = (ArrayList<Profesor>) ois.readObject();
			System.out.println(profesorado);
			
			ois.close();
			fis.close();
		}
		catch(Exception e) {
		}
	}
	
	// ------------------- ALUMNO
	
	
	
	
	
	// ------------------- CURSO
	
	// Crear un curso
	public void altaCurso(ArrayList<Curso> docencia, String fichero) {
		
		System.out.println("Introduce el nombre del curso: ");
		String nombre = tec.nextLine();
		
		System.out.println("Introduce la descripcion: ");
		String descripcion = tec.nextLine();
		
		Curso curso = new Curso(nombre, descripcion);
		docencia.add(curso);
		
		try {
			FileWriter fw = new FileWriter(fichero, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(curso.toString() + "\n");
			
			bw.close();
			fw.close();
			
			System.out.println("Curso guardado con exito.");
		}
		catch(Exception e) {
			System.err.println("No se pudo guardar el curso en fichero");
		}
	}
	
	// Borrar un curso
	public void bajaCurso(ArrayList<Curso> docencia, String fichero) {
		
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("Introduce el codigo del curso: ");
			int codigo = tec.nextInt();
			boolean encontrado = false;
			
			for(Curso c : docencia) {
				if(c.getCodigo()==codigo) {
					System.out.println(c.toString());
					System.out.println("¿Estas seguro de que deseas borrar el curso (s/n)?");
					String respuesta = tec.nextLine();
					if(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s")) {
						docencia.remove(c);
						System.out.println("Curso eliminado con exito");
					}
					encontrado = true;
				}
			}
			
			if(!encontrado) {
				System.out.println("El curso no esta inscrito.");
			}
			
			for(Curso c : docencia) {
				bw.write(c.toString());
			}
			bw.close();
			fw.close();
			System.out.println("Datos cambiados correctamente.");
		}
		catch(Exception e) {
			System.err.println("No se pudo realizar la operacion.");
		}
	}
	// Mostrar el listado de los profesores desde fichero
	public void mostrarCursos(ArrayList<Curso> docencia, String fichero) {
		
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.err.println("No se pudieron mostrar los datos de los cursos.");
		}
	}
	
}
