package CentroFormacion;

import java.util.*;

public class Main {

	static String archivoProfesores="profesorado.ser";
	static String archivoAlumnos="alumnado.ser";
	static String archivoCursos="docencia.txt";
	
	static Scanner tec = new Scanner(System.in);
	static ProgramaMetodos metodos = new ProgramaMetodos(); // Instanciar a los metodos
	static ArrayList<Profesor> profesorado = new ArrayList<Profesor>(); // Lista de profesores
	static ArrayList<Alumno> alumnado = new ArrayList<Alumno>(); // Lista de alumnos
	static ArrayList<Curso> docencia = new ArrayList<Curso>(); // Lista de cursos
	
	// Menu principal
	public static void main(String[] args) {
		
		String opcion="";
		
		while(!opcion.equals("4")) {
			
			opcion=escogerModalidad();
			
			switch(opcion) {
				case "1":
					escogerOpcionProfesor();
					break;
				case "2":
					escogerOpcionAlumno();
					break;
				case "3":
					escogerOpcionCurso();
					break;
				case "4":
					System.out.println("Programa finalizado.");
					break;
			}
		}
	}
	
	// Menu que escoge la modalidad(Profesor, Alumno o Curso)
	public static String escogerModalidad() {
		
		System.out.println("<--- MENU --->");
		System.out.println("1 - PROFESOR");
		System.out.println("2 - ALUMNO");
		System.out.println("3 - CURSO");
		System.out.println("4 - SALIR");
		
		System.out.println("Escoja una modalidad: ");
		String modalidad = tec.nextLine();
		
		return modalidad;
	}
	
	// Menu de profesor
	public static String escogerOpcionProfesor() {
		
		System.out.println("<-- PROFESOR -->");
		System.out.println("1 - CREAR");
		System.out.println("2 - BORRAR");
		System.out.println("3 - MODIFICAR");
		System.out.println("4 - CONSULTAR"); //Buscar
		System.out.println("5 - MOSTRAR");
		System.out.println("6 - VOLVER AL MENU");
		
		System.out.println("Escoja una opcion: ");
		String opcion = tec.nextLine();
		
		switch(opcion) {
		
			case "1":
				System.out.println("Crear");
				metodos.altaProfesor(profesorado, archivoProfesores);
				break;
			case "2":
				System.out.println("Borrar");
				metodos.bajaProfesor(profesorado, archivoProfesores);
				break;
			case "3":
				System.out.println("Modificar");
				metodos.modificarProfesor(profesorado, archivoProfesores);
				break;
			case "4":
				System.out.println("Consultar");
				break;
			case "5":
				System.out.println("Mostrar");
				metodos.mostrarProfesorado(profesorado);
				//metodos.leerProfesorado(profesorado, archivoProfesores);
				break;
			case "6":
				escogerModalidad(); // Volver al menu principal
				break;
			default:
				System.err.println("Opcion no valida.");
		}
		//ArrayList<Profesor> profesorado = new ArrayList<Profesor>();
		return opcion;
	}
	
	// Menu de alumno
	public static String escogerOpcionAlumno() {
		
		System.out.println("<-- ALUMNO -->");
		System.out.println("1 - CREAR");
		System.out.println("2 - BORRAR");
		System.out.println("3 - MODIFICAR");
		System.out.println("4 - CONSULTAR"); //Buscar
		System.out.println("5 - MOSTRAR");
		System.out.println("6 - VOLVER AL MENU");
		
		System.out.println("Escoja una opcion: ");
		String opcion = tec.nextLine();
		
		switch(opcion) {
		
			case "1":
				System.out.println("Crear");
				break;
			case "2":
				System.out.println("Borrar");
				break;
			case "3":
				System.out.println("Modificar");
				break;
			case "4":
				System.out.println("Consultar");
				break;
			case "5":
				System.out.println("Mostrar");
				break;
			case "6":
				escogerModalidad(); // Volver al menu principal
				break;
			default:
				System.err.println("Opcion no valida.");
		}
		return opcion;
	}
	
	// Menu de curso
	public static String escogerOpcionCurso() {
		
		System.out.println("<-- CURSO -->");
		System.out.println("1 - CREAR");
		System.out.println("2 - BORRAR");
		System.out.println("3 - MODIFICAR");
		System.out.println("4 - CONSULTAR"); //Buscar cursos
		System.out.println("5 - MOSTRAR");
		System.out.println("6 - VOLVER AL MENU");
		
		System.out.println("Escoja una opcion: ");
		String opcion = tec.nextLine();
		
		switch(opcion) {
		
			case "1":
				System.out.println("Crear");
				metodos.altaCurso(docencia, archivoCursos);
				break;
			case "2":
				System.out.println("Borrar");
				metodos.bajaCurso(docencia, archivoCursos);
				break;
			case "3":
				System.out.println("Modificar");
				break;
			case "4":
				System.out.println("Consultar");
				break;
			case "5":
				System.out.println("Mostrar");
				metodos.mostrarCursos(docencia, archivoCursos);
				break;
			case "6":
				escogerModalidad(); // Volver al menu principal
				break;
			default:
				System.err.println("Opcion no valida.");
		}
		return opcion;
	}
}
