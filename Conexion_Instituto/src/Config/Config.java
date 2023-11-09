package Config;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import datos.*;
import domain.*;

public class Config {

	public static final String MENU_PRINCIPAL = "----------------MENU-----------------\n" + "1- Tabla alumno.\n"
			+ "2- Tabla departamento.\n" + "3- Tabla profesor.\n" + "4- Tabla edificio.\n" + "5- Tabla aula.\n"
			+ "6- Tabla curso.\n" + "7- Tabla turno.\n" + "8- Tabla grupo.\n" + "9- Tabla asignatura.\n"
			+ "10- Proximamente...\n" + "0- Salir";

	public static final String MENU_ALUMNO = "------------ALUMNO MENU--------------\n" + "1- Listar Alumnos\n"
			+ "2- Añadir Alumno\n" + "3- Modificar un Alumno\n" + "4- Eliminar un Alumno\n" + "0- Atras";

	public static final String MENU_DEPARTAMENTO = "---------DEPARTAMENTO MENU-----------\n"
			+ "1- Listar Departamentos\n" + "2- Añadir Departamento\n" + "3- Modificar un Departamento\n"
			+ "4- Eliminar un Departamento\n" + "0- Atras";

	public static final String MENU_PROFESOR = "------------PROFESOR MENU-------------\n" + "1- Listar Profesores\n"
			+ "2- Añadir Profesor\n" + "3- Modificar un Profesor\n" + "4- Eliminar un Profesor\n" + "0- Atras";

	public static final String MENU_EDIFICIO = "------------EDIFICIO MENU-------------\n" + "1- Listar Edificios\n"
			+ "2- Añadir Edificio\n" + "3- Modificar un Edificio\n" + "4- Eliminar un Edificio\n" + "0- Atras";

	public static final String MENU_AULA = "---------------AULA MENU---------------\n" + "1- Listar Aulas\n"
			+ "2- Añadir Aula\n" + "3- Modificar un Aula\n" + "4- Eliminar un Aula\n" + "0- Atras";

	public static final String MENU_CURSO = "--------------CURSO MENU---------------\n" + "1- Listar Cursos\n"
			+ "2- Añadir Curso\n" + "3- Modificar un Curso\n" + "4- Eliminar un Curso\n" + "0- Atras";

	public static final String MENU_TURNO = "--------------TURNO MENU---------------\n" + "1- Listar Turnos\n"
			+ "2- Añadir Turno\n" + "3- Modificar un Turno\n" + "4- Eliminar un Turno\n" + "0- Atras";

	public static final String MENU_GRUPO = "--------------GRUPO MENU---------------\n" + "1- Listar Grupos\n"
			+ "2- Añadir Grupo\n" + "3- Modificar un Grupo\n" + "4- Eliminar un Grupo\n" + "0- Atras";

	public static final String MENU_ASIGNATURA = "----------ASIGNATURA MENU------------\n" + "1- Listar Asignaturas\n"
			+ "2- Añadir Asignatura\n" + "3- Modificar una Asignatura\n" + "4- Eliminar una Asignatura\n" + "0- Atras";

	public static void MenuAlumno(Scanner teclado, AlumnoDAO alumnoDAO) {

		boolean fin = true;

		while (fin) {
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Alumno> alumnos = alumnoDAO.selecionar();

				alumnos.forEach(alumno -> {
					System.out.println(alumno);
				});
				break;

			case 2:
				 System.out.println("Ingrese los datos del nuevo alumno:");

				    System.out.print("NRE: ");
				    String nre = teclado.next();
				    System.out.print("DNI: ");
				    String dni = teclado.next();
				    System.out.print("Nombre: ");
				    String nombre = teclado.next();
				    System.out.print("Apellido1: ");
				    String apellido1 = teclado.next();
				    System.out.print("Apellido2: ");
				    String apellido2 = teclado.next();
				    System.out.print("Tipo de vía: ");
				    String tipo_via = teclado.next();
				    System.out.print("Nombre de la vía: ");
				    String nombre_via = teclado.next();
				    System.out.print("Número: ");
				    String numero = teclado.next();
				    System.out.print("Escalera: ");
				    String escalera = teclado.next();
				    System.out.print("Piso: ");
				    String piso = teclado.next();
				    System.out.print("Puerta: ");
				    String puerta = teclado.next();
				    System.out.print("Código Postal: ");
				    String cp = teclado.next();
				    System.out.print("País: ");
				    String pais = teclado.next();
				    System.out.print("Teléfono fijo: ");
				    String tlfn_fijo = teclado.next();
				    System.out.print("Teléfono móvil: ");
				    String tlfn_movil = teclado.next();
				    System.out.print("Correo electrónico: ");
				    String email = teclado.next();
				    System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
				    String fechaNacimientoStr = teclado.next();
				    Date fechaNac = Date.valueOf(fechaNacimientoStr);
				    System.out.print("Tutor: ");
				    String tutor = teclado.next();

				    Alumno nuevoAlumno = new Alumno(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fechaNac, tutor);
				    alumnoDAO.insertar(nuevoAlumno);

				    System.out.println("Alumno añadido correctamente.");
                break;

			case 3:
			    // Modificar Alumno
			    System.out.print("Ingrese el NRE del alumno a modificar: ");
			    String nuevoNre = teclado.next();

			    System.out.println("Ingrese los nuevos datos para el alumno:");

			    System.out.print("Nuevo DNI: ");
			    String nuevoDni = teclado.next();
			    System.out.print("Nuevo nombre: ");
			    String nuevoNombre = teclado.next();
			    System.out.print("Nuevo apellido1: ");
			    String nuevoApellido1 = teclado.next();
			    System.out.print("Nuevo apellido2: ");
			    String nuevoApellido2 = teclado.next();
			    System.out.print("Nuevo tipo de vía: ");
			    String nuevoTipoVia = teclado.next();
			    System.out.print("Nuevo nombre de la vía: ");
			    String nuevoNombreVia = teclado.next();
			    System.out.print("Nuevo número: ");
			    String nuevoNumero = teclado.next();
			    System.out.print("Nueva escalera: ");
			    String nuevaEscalera = teclado.next();
			    System.out.print("Nuevo piso: ");
			    String nuevoPiso = teclado.next();
			    System.out.print("Nueva puerta: ");
			    String nuevaPuerta = teclado.next();
			    System.out.print("Nuevo código postal: ");
			    String nuevoCp = teclado.next();
			    System.out.print("Nuevo país: ");
			    String nuevoPais = teclado.next();
			    System.out.print("Nuevo teléfono fijo: ");
			    String nuevoTlfnFijo = teclado.next();
			    System.out.print("Nuevo teléfono móvil: ");
			    String nuevoTlfnMovil = teclado.next();
			    System.out.print("Nuevo correo electrónico: ");
			    String nuevoEmail = teclado.next();
			    System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
			    String nuevaFechaNacimientoStr = teclado.next();
			    Date nuevaFechaNac = Date.valueOf(nuevaFechaNacimientoStr);
			    System.out.print("Nuevo tutor: ");
			    String nuevoTutor = teclado.next();

			    Alumno alumnoModificado = new Alumno(nuevoNre, nuevoDni, nuevoNombre, nuevoApellido1, nuevoApellido2, nuevoTipoVia, nuevoNombreVia, nuevoNumero, nuevaEscalera, nuevoPiso, nuevaPuerta, nuevoCp, nuevoPais, nuevoTlfnFijo, nuevoTlfnMovil, nuevoEmail, nuevaFechaNac, nuevoTutor);
			    alumnoDAO.actualizar(alumnoModificado);

			    System.out.println("Alumno modificado correctamente.");
			    break;


            case 4:
                // Eliminar Alumno
                System.out.print("Ingrese el ID del alumno a eliminar: ");
                int idEliminar = teclado.nextInt();


                System.out.println("Alumno eliminado correctamente.");
                break;

            case 0:
                fin = false;
                break;

			default:
				System.out.println("Proximamente...");
				break;
			}
		}


		

	}

}
