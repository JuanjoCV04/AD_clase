package Config;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import Regex.Regex;
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
	


	public static void MenuAlumno(Scanner teclado, AlumnoDAO alumnoDAO, CodigoPostalDAO codigopostalDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_ALUMNO);
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
				if(!Regex.ValidarNre(nre)) {
					System.err.println("Invalido nre");
					break;
				}
				if(Regex.ExistenciaNre(nre, alumnoDAO)) {
					System.err.println("Invalido, nre existente");
					break;
				
				}
				System.out.print("DNI: ");
				String dni = teclado.next();
				if(!Regex.ValidarDNI(dni)) {
					System.err.println("invalido dni");
					break;
				}
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				if(!Regex.ValidarLetras(nombre)) {
					System.err.println("invalido nombre");
					break;
				}
				System.out.print("Apellido1: ");
				String apellido1 = teclado.next();
				if(!Regex.ValidarLetras(apellido1)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Apellido2: ");
				String apellido2 = teclado.next();
				if(!Regex.ValidarLetras(apellido2)) {
					System.err.println("invalido apellido");
					break;
				}
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
				if(!Regex.ValidarCp(cp)) {
					System.err.println("Invalido codigo postal");
					break;
				}
				
				if(!Regex.ExisteCodigoPostal(cp, codigopostalDAO)) {
					System.err.println("Invalido, codigo postal no existente");
					break;
				}
				
				System.out.print("País: ");
				String pais = teclado.next();
				System.out.print("Teléfono fijo: ");
				String tlfn_fijo = teclado.next();
				if(!Regex.ValidarTelefono(tlfn_fijo)) {
					System.err.println("Invalido telefono fijo");
					break;
				}
				System.out.print("Teléfono móvil: ");
				String tlfn_movil = teclado.next();
				if(!Regex.ValidarTelefono(tlfn_movil)) {
					System.err.println("Invalido telefono movil");
					break;
				}
				System.out.print("Correo electrónico: ");
				String email = teclado.next();
				if(!Regex.ValidarGmail(email)) {
					System.err.println("Invalido Gmail");
					break;
				}
				System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
				String fechaNacimientoStr = teclado.next();
				if(!Regex.ValidarFecha(fechaNacimientoStr)) {
					System.err.println("Invalida fecha");
					break;
				}
				Date fechaNac = Date.valueOf(fechaNacimientoStr);
				System.out.print("Tutor: ");
				String tutor = teclado.next();

				Alumno nuevoAlumno = new Alumno(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero,
						escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fechaNac, tutor);
				alumnoDAO.insertar(nuevoAlumno);

				System.out.println("Alumno añadido correctamente.");
				break;

			case 3:
				// Modificar Alumno
				System.out.print("Ingrese el NRE del alumno a modificar: ");
				String nuevoNre = teclado.next();
				
				if(!Regex.ValidarNre(nuevoNre)) {
					System.err.println("Invalido nre");
					break;
				}
				if(!Regex.ExistenciaNre(nuevoNre, alumnoDAO)) {
					System.err.println("Invalido, nre no existe");
					break;
				
				}
				System.out.println("Ingrese los nuevos datos para el alumno:");

				System.out.print("Nuevo DNI: ");
				String nuevoDni = teclado.next();
				if(!Regex.ValidarDNI(nuevoDni)) {
					System.err.println("invalido dni");
					break;
				}
				System.out.print("Nuevo nombre: ");
				String nuevoNombre = teclado.next();
				if(!Regex.ValidarLetras(nuevoNombre)) {
					System.err.println("invalido nombre");
					break;
				}
				System.out.print("Nuevo apellido1: ");
				String nuevoApellido1 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido1)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Nuevo apellido2: ");
				String nuevoApellido2 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido2)) {
					System.err.println("invalido apellido");
					break;
				}
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
				if(!Regex.ValidarCp(nuevoCp)) {
					System.err.println("Invalido codigo postal");
					break;
				}
				
				if(!Regex.ExisteCodigoPostal(nuevoCp, codigopostalDAO)) {
					System.err.println("Invalido, codigo postal no registrado");
					break;
				}
				System.out.print("Nuevo país: ");
				String nuevoPais = teclado.next();
				System.out.print("Nuevo teléfono fijo: ");
				String nuevoTlfnFijo = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnFijo)) {
					System.err.println("Invalido telefono fijo");
					break;
				}
				System.out.print("Nuevo teléfono móvil: ");
				String nuevoTlfnMovil = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnMovil)) {
					System.err.println("Invalido telefono movil");
					break;
				}
				System.out.print("Nuevo correo electrónico: ");
				String nuevoEmail = teclado.next();
				if(!Regex.ValidarGmail(nuevoEmail)) {
					System.err.println("Invalido Gmail");
					break;
				}
				System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
				String nuevaFechaNacimientoStr = teclado.next();
				if(!Regex.ValidarFecha(nuevaFechaNacimientoStr)) {
					System.err.println("Invalida fecha");
					break;
				}
				Date nuevaFechaNac = Date.valueOf(nuevaFechaNacimientoStr);
				System.out.print("Nuevo tutor: ");
				String nuevoTutor = teclado.next();

				Alumno alumnoModificado = new Alumno(nuevoNre, nuevoDni, nuevoNombre, nuevoApellido1, nuevoApellido2,
						nuevoTipoVia, nuevoNombreVia, nuevoNumero, nuevaEscalera, nuevoPiso, nuevaPuerta, nuevoCp,
						nuevoPais, nuevoTlfnFijo, nuevoTlfnMovil, nuevoEmail, nuevaFechaNac, nuevoTutor);
				alumnoDAO.actualizar(alumnoModificado);

				System.out.println("Alumno modificado correctamente.");
				break;

			case 4:
				// Eliminar Alumno
				teclado.nextLine();
				System.out.print("Ingrese el NRE del alumno a eliminar: ");
				String idEliminar = teclado.nextLine();
				if(!Regex.ExistenciaNre(idEliminar, alumnoDAO)) {
					System.err.println("Invalido, nre no existe");
					break;
				
				}
				Alumno alumnoDelete = new Alumno(idEliminar);
				alumnoDAO.delete(alumnoDelete);

				System.out.println("Alumno eliminado correctamente.");
				break;

			case 0:
				fin = false;
				break;

			default:
				System.err.println("Escribe una opcion valida");
				break;
			}
		}

	}

	public static void MenuDepartamento(Scanner teclado, DepartamentoDAO departamentoDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_DEPARTAMENTO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				// Listar Departamentos
				List<Departamento> departamentos = departamentoDAO.seleccionar();
				for (Departamento dept : departamentos) {
					System.out.println(dept);
				}
				break;

			case 2:
				// Añadir Departamento
				System.out.print("Ingrese el código del departamento: ");
				String nuevoCodigo = teclado.next();
				
				if(!Regex.ValidarCodDepartamento(nuevoCodigo)) {
					System.err.println("Invalido formato Codigo departamento");
					break;
				}
				
				if(Regex.ExistenciaDepartamento(nuevoCodigo, departamentoDAO)) {
					System.err.println("Invalido, cod departamento existente");
					break;
				}
				System.out.print("Ingrese el nombre del departamento: ");
				String nuevoNombre = teclado.next();
				System.out.print("Ingrese la descripción del departamento: ");
				String nuevaDescripcion = teclado.next();

				Departamento nuevoDepartamento = new Departamento(nuevoCodigo, nuevoNombre, nuevaDescripcion);
				departamentoDAO.insertar(nuevoDepartamento);
				System.out.println("Departamento añadido correctamente.");
				break;

			case 3:
				// Modificar Departamento
				System.out.print("Ingrese el código del departamento: ");
				nuevoCodigo = teclado.next();
				if(!Regex.ValidarCodDepartamento(nuevoCodigo)) {
					System.err.println("Invalido formato Codigo departamento");
					break;
				}
				
				if(!Regex.ExistenciaDepartamento(nuevoCodigo, departamentoDAO)) {
					System.err.println("Invalido, cod departamento no existe");
					break;
				}
				System.out.print("Ingrese el nombre del departamento: ");
				nuevoNombre = teclado.next();
				System.out.print("Ingrese la descripción del departamento: ");
				nuevaDescripcion = teclado.next();

				Departamento departamentoModificado = new Departamento(nuevoCodigo, nuevoNombre, nuevaDescripcion);
				departamentoDAO.actualizar(departamentoModificado);
				System.out.println("Departamento modificado correctamente.");
				break;

			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del departamento a eliminar: ");
				String idEliminar = teclado.nextLine();
				if(!Regex.ExistenciaDepartamento(idEliminar, departamentoDAO)) {
					System.err.println("Invalido, cod departamento no existe");
					break;
				}
				Departamento departamentoDelete = new Departamento(idEliminar);
				departamentoDAO.eliminar(departamentoDelete);

				System.out.println("Departamento eliminado correctamente");
				break;
			case 0:
				fin = false;
				break;

			default:
				System.err.println("Escribe una opcion valida");
				break;
			}
		}
	}

	public static void MenuProfesor(Scanner teclado, ProfesorDAO profesorDAO, CodigoPostalDAO codigopostalDAO, DepartamentoDAO departamentoDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_PROFESOR);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {

			case 1:
				List<Profesor> profesores = profesorDAO.seleccionar();
				for (Profesor prof : profesores) {
					System.out.println(prof);
				}
				break;
			case 2:
				// Añadir Profesor
				System.out.print("Ingrese el NRP del profesor: ");
				String nuevoNrp = teclado.next();
				
				if(!Regex.ValidarNre(nuevoNrp)) {
					System.err.println("NRP formato invalido");
					break;
				}
				
				if(Regex.ExistenciaNrp(nuevoNrp, profesorDAO)) {
					System.err.println("Invalido, nrp existente");
					break;
				}
				
				
				System.out.print("Ingrese el DNI del profesor: ");
				String nuevoDni = teclado.next();
				if(!Regex.ValidarDNI(nuevoDni)) {
					System.err.println("invalido dni");
					break;
				}
				System.out.print("Ingrese el nombre del profesor: ");
				String nuevoNombre = teclado.next();
				if(!Regex.ValidarLetras(nuevoNombre)) {
					System.err.println("invalido nombre");
					break;
				}
				System.out.print("Ingrese el primer apellido del profesor: ");
				String nuevoApellido1 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido1)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Ingrese el segundo apellido del profesor: ");
				String nuevoApellido2 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido2)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Ingrese el tipo de vía: ");
				String nuevoTipoVia = teclado.next();
				System.out.print("Ingrese el nombre de la vía: ");
				String nuevoNombreVia = teclado.next();
				System.out.print("Ingrese el número: ");
				String nuevoNumero = teclado.next();
				System.out.print("Ingrese la escalera: ");
				String nuevaEscalera = teclado.next();
				System.out.print("Ingrese el piso: ");
				String nuevoPiso = teclado.next();
				System.out.print("Ingrese la puerta: ");
				String nuevaPuerta = teclado.next();
				System.out.print("Ingrese el código postal: ");
				String nuevoCp = teclado.next();
				if(!Regex.ValidarCp(nuevoCp)) {
					System.err.println("Invalido codigo postal");
					break;
				}
				
				if(!Regex.ExisteCodigoPostal(nuevoCp, codigopostalDAO)) {
					System.err.println("Invalido, codigo postal no existente");
					break;
				}
				
				System.out.print("Ingrese el país: ");
				String nuevoPais = teclado.next();
				System.out.print("Ingrese el teléfono fijo: ");
				String nuevoTlfnFijo = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnFijo)) {
					System.err.println("Invalido telefono fijo");
					break;
				}
				System.out.print("Ingrese el teléfono móvil: ");
				String nuevoTlfnMovil = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnMovil)) {
					System.err.println("Invalido telefono movil");
					break;
				}
				System.out.print("Ingrese el email: ");
				String nuevoEmail = teclado.next();
				if(!Regex.ValidarGmail(nuevoEmail)) {
					System.err.println("Invalido Gmail");
					break;
				}
				System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
				String nuevaFechaNacString = teclado.next();
				if(!Regex.ValidarFecha(nuevaFechaNacString)) {
					System.err.println("Invalida fecha");
					break;
				}
				Date nuevaFechaNac = Date.valueOf(nuevaFechaNacString);
				System.out.print("Ingrese el código del departamento: ");
				String nuevoCodDepartamento = teclado.next();
				if(!Regex.ValidarCodDepartamento(nuevoCodDepartamento)) {
					System.err.println("Invalido formato Codigo departamento");
					break;
				}
				
				if(!Regex.ExistenciaDepartamento(nuevoCodDepartamento, departamentoDAO)) {
					System.err.println("Invalido, cod departamento no existe");
					break;
				}
				Profesor nuevoProfesor = new Profesor(nuevoNrp, nuevoDni, nuevoNombre, nuevoApellido1, nuevoApellido2,
						nuevoTipoVia, nuevoNombreVia, nuevoNumero, nuevaEscalera, nuevoPiso, nuevaPuerta, nuevoCp,
						nuevoPais, nuevoTlfnFijo, nuevoTlfnMovil, nuevoEmail, nuevaFechaNac, nuevoCodDepartamento);
				profesorDAO.insertar(nuevoProfesor);
				System.out.println("Profesor añadido correctamente.");

				break;
				
			case 3:
				System.out.print("Ingrese el NRP del profesor: ");
				nuevoNrp = teclado.next();
				if(!Regex.ValidarNre(nuevoNrp)) {
					System.err.println("NRP formato invalido");
					break;
				}
				
				if(!Regex.ExistenciaNrp(nuevoNrp, profesorDAO)) {
					System.err.println("Invalido, nrp existente");
					break;
				}
				System.out.print("Ingrese el DNI del profesor: ");
				nuevoDni = teclado.next();
				if(!Regex.ValidarDNI(nuevoDni)) {
					System.err.println("invalido dni");
					break;
				}
				System.out.print("Ingrese el nombre del profesor: ");
				nuevoNombre = teclado.next();
				if(!Regex.ValidarLetras(nuevoNombre)) {
					System.err.println("invalido nombre");
					break;
				}
				System.out.print("Ingrese el primer apellido del profesor: ");
				nuevoApellido1 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido1)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Ingrese el segundo apellido del profesor: ");
				nuevoApellido2 = teclado.next();
				if(!Regex.ValidarLetras(nuevoApellido2)) {
					System.err.println("invalido apellido");
					break;
				}
				System.out.print("Ingrese el tipo de vía: ");
				nuevoTipoVia = teclado.next();
				System.out.print("Ingrese el nombre de la vía: ");
				nuevoNombreVia = teclado.next();
				System.out.print("Ingrese el número: ");
				nuevoNumero = teclado.next();
				System.out.print("Ingrese la escalera: ");
				nuevaEscalera = teclado.next();
				System.out.print("Ingrese el piso: ");
				nuevoPiso = teclado.next();
				System.out.print("Ingrese la puerta: ");
				nuevaPuerta = teclado.next();
				System.out.print("Ingrese el código postal: ");
				nuevoCp = teclado.next();
				if(!Regex.ValidarCp(nuevoCp)) {
					System.err.println("Invalido codigo postal");
					break;
				}
				
				if(!Regex.ExisteCodigoPostal(nuevoCp, codigopostalDAO)) {
					System.err.println("Invalido, codigo postal no existente");
					break;
				}
				System.out.print("Ingrese el país: ");
				nuevoPais = teclado.next();
				System.out.print("Ingrese el teléfono fijo: ");
				nuevoTlfnFijo = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnFijo)) {
					System.err.println("Invalido telefono fijo");
					break;
				}
				System.out.print("Ingrese el teléfono móvil: ");
				nuevoTlfnMovil = teclado.next();
				if(!Regex.ValidarTelefono(nuevoTlfnMovil)) {
					System.err.println("Invalido telefono movil");
					break;
				}
				System.out.print("Ingrese el email: ");
				nuevoEmail = teclado.next();
				if(!Regex.ValidarGmail(nuevoEmail)) {
					System.err.println("Invalido Gmail");
					break;
				}
				System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
				nuevaFechaNacString = teclado.next();
				if(!Regex.ValidarFecha(nuevaFechaNacString)) {
					System.err.println("Invalida fecha");
					break;
				}
				nuevaFechaNac = Date.valueOf(nuevaFechaNacString);
				System.out.print("Ingrese el código del departamento: ");
				nuevoCodDepartamento = teclado.next();
				if(!Regex.ValidarCodDepartamento(nuevoCodDepartamento)) {
					System.err.println("Invalido formato Codigo departamento");
					break;
				}
				
				if(!Regex.ExistenciaDepartamento(nuevoCodDepartamento, departamentoDAO)) {
					System.err.println("Invalido, cod departamento no existe");
					break;
				}
				Profesor profesorModificado = new Profesor(nuevoNrp, nuevoDni, nuevoNombre, nuevoApellido1,
						nuevoApellido2, nuevoTipoVia, nuevoNombreVia, nuevoNumero, nuevaEscalera, nuevoPiso,
						nuevaPuerta, nuevoCp, nuevoPais, nuevoTlfnFijo, nuevoTlfnMovil, nuevoEmail, nuevaFechaNac,
						nuevoCodDepartamento);
				profesorDAO.actualizar(profesorModificado);
				System.out.println("Profesor Modificado correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el NRP del Profesor a eliminar: ");
				String idEliminar = teclado.nextLine();
				if(!Regex.ValidarNre(idEliminar)) {
					System.err.println("NRP formato invalido");
					break;
				}
				Profesor profesorDelte = new Profesor(idEliminar);
				profesorDAO.eliminar(profesorDelte);

				System.out.println("Profesor eliminado correctamente");

				break;

			case 0:
				fin = false;
				break;

			default:
				System.err.println("Escribe una opcion valida");
				break;

			}
		}
	}

	public static void MenuEdificio(Scanner teclado, EdificioDAO edificioDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_EDIFICIO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Edificio> edificios = edificioDAO.seleccionar();
				for (Edificio edificio : edificios) {
					System.out.println(edificio);
				}
				break;
			case 2:
				System.out.print("Ingrese el código del Edificio: ");
				String nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(Regex.ExistenciaEdificio(nuevoCodigo, edificioDAO)) {
					System.err.println("Invalido, codigo ya existente");
					break;
				}
				
				System.out.print("Ingrese el nombre del Edificio: ");
				String nuevoNombre = teclado.next();

				Edificio nuevoEdificio = new Edificio(nuevoCodigo, nuevoNombre);
				edificioDAO.insertar(nuevoEdificio);
				System.out.println("Edificio añadido correctamente.");
				break;
			case 3:
				System.out.print("Ingrese el código del Edificio: ");
				nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(!Regex.ExistenciaEdificio(nuevoCodigo, edificioDAO)) {
					System.err.println("Invalido, codigo no existente");
					break;
				}
				System.out.print("Ingrese el nombre del Edificio: ");
				nuevoNombre = teclado.next();

				Edificio edificoModificado = new Edificio(nuevoCodigo, nuevoNombre);
				edificioDAO.actualizar(edificoModificado);
				System.out.println("Edificio actualizado correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del Edificio a eliminar: ");
				String idEliminar = teclado.nextLine();
				if(!Regex.ExistenciaEdificio(idEliminar, edificioDAO)) {
					System.err.println("Invalido, id no existente");
					break;
				}
				Edificio edificioEliminado = new Edificio(idEliminar);
				edificioDAO.eliminar(edificioEliminado);

				System.out.println("Edificio eliminado correctamente");

				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;

			}
		}
	}

	public static void MenuAula(Scanner teclado, AulaDAO aulaDAO,EdificioDAO edificioDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_AULA);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {

			case 1:
				List<Aula> aulas = aulaDAO.seleccionar();
				for (Aula aula : aulas) {
					System.out.println(aula);
				}
				break;

			case 2:
				System.out.print("Ingrese el código del Aula: ");
				String nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(Regex.ExistenciaAula(nuevoCodigo, aulaDAO)) {
					System.err.println("Codigo ya existe, invalido");
					break;
				}
				System.out.print("Ingrese el codigo del Edificio: ");
				String nuevoCodigoedf = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigoedf)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(Regex.ExistenciaEdificio(nuevoCodigoedf, edificioDAO)) {
					System.err.println("Invalido, codigo ya existente");
					break;
				}
				
				Aula nuevoAula = new Aula(nuevoCodigo, nuevoCodigoedf);
				aulaDAO.insertar(nuevoAula);
				System.out.println("Aula añadido correctamente.");
				break;
			case 3:
				System.out.print("Ingrese el código del Aula: ");
				nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				if(!Regex.ExistenciaAula(nuevoCodigo, aulaDAO)) {
					System.err.println("Codigo no existe, invalido");
					break;
				}
				System.out.print("Ingrese el codigo del Edificio: ");
				nuevoCodigoedf = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigoedf)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(!Regex.ExistenciaEdificio(nuevoCodigoedf, edificioDAO)) {
					System.err.println("Invalido, codigo ya existente");
					break;
				}

				Aula aulaModificar = new Aula(nuevoCodigo, nuevoCodigoedf);
				aulaDAO.actualizar(aulaModificar);
				System.out.println("Aula actualizada correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del Aula a eliminar: ");
				String idEliminar = teclado.nextLine();
				if(!Regex.ExistenciaAula(idEliminar, aulaDAO)) {
					System.err.println("Codigo no existe, invalido");
					break;
				}
				Aula aulaEliminar = new Aula(idEliminar);
				aulaDAO.eliminar(aulaEliminar);

				System.out.println("Aula eliminada correctamente");

				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;
			}
		}
	}

	public static void MenuCurso(Scanner teclado, CursoDAO cursoDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_CURSO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Curso> cursos = cursoDAO.seleccionar();
				for (Curso curso : cursos) {
					System.out.println(curso);
				}
				break;
			case 2:
				System.out.print("Ingrese el código del Curso: ");
				String nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				
				if(Regex.ExistenciaCurso(nuevoCodigo, cursoDAO)) {
					System.err.println("Codigo ya existe, invalido");
					break;
				}
				System.out.print("Ingrese el Nombre del Curso: ");
				String nuevoNombre = teclado.next();
				System.out.print("Ingrese la Descripcion del curso: ");
				String nuevaDescripcion = teclado.next();

				Curso nuevocoCurso = new Curso(nuevoCodigo, nuevoNombre, nuevaDescripcion);
				cursoDAO.insertar(nuevocoCurso);
				System.out.println("Curso añadido correctamente.");
				break;
			case 3:
				System.out.print("Ingrese el código del Curso: ");
				nuevoCodigo = teclado.next();
				if(!Regex.ValidarSoloNumeros(nuevoCodigo)) {
					System.err.println("Codigo formato invalido");
					break;
				}
				if(!Regex.ExistenciaCurso(nuevoCodigo, cursoDAO)) {
					System.err.println("Codigo no existe, invalido");
					break;
				}
				System.out.print("Ingrese el Nombre del Curso: ");
				nuevoNombre = teclado.next();
				System.out.print("Ingrese la Descripcion del curso: ");
				nuevaDescripcion = teclado.next();

				Curso Cursoactualizar = new Curso(nuevoCodigo, nuevoNombre, nuevaDescripcion);
				cursoDAO.actualizar(Cursoactualizar);
				System.out.println("Curso actualizado correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del Curso a eliminar: ");
				String idEliminar = teclado.nextLine();
				
				if(!Regex.ExistenciaCurso(idEliminar, cursoDAO)) {
					System.err.println("Codigo no existe, invalido");
					break;
				}
				
				Curso cursoDelete = new Curso(idEliminar);
				cursoDAO.eliminar(cursoDelete);

				System.out.println("Curso eliminada correctamente");
				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;

			}
		}
	}

	public static void MenuTurno(Scanner teclado, TurnoDAO turnoDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_TURNO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Turno> turnos = turnoDAO.seleccionar();
				for (Turno turno : turnos) {
					System.out.println(turno);
				}
				break;
			case 2:
				System.out.print("Ingrese el código del Turno: ");
				String nuevoCodigo = teclado.next();
				
				System.out.print("Ingrese el Horario del turno: ");
				String nuevohorario = teclado.next();

				Turno nuevoTurno = new Turno(nuevoCodigo, nuevohorario);
				turnoDAO.insertar(nuevoTurno);
				System.out.println("Turno añadido correctamente.");
				break;
			case 3:
				System.out.print("Ingrese el código del Turno: ");
				nuevoCodigo = teclado.next();
				System.out.print("Ingrese el Horario del turno: ");
				nuevohorario = teclado.next();

				Turno actualizarTurno = new Turno(nuevoCodigo, nuevohorario);
				turnoDAO.actualizar(actualizarTurno);
				System.out.println("Turno actualizado correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del Turno a eliminar: ");
				String idEliminar = teclado.nextLine();

				Turno turnoDelete = new Turno(idEliminar);
				turnoDAO.eliminar(turnoDelete);

				System.out.println("Turno eliminado correctamente");
				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;
			}
		}
	}

	public static void MenuGrupo(Scanner teclado, GrupoDAO grupoDAO) {
		
		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_GRUPO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Grupo> grupos = grupoDAO.seleccionar();
				for (Grupo grupo : grupos) {
					System.out.println(grupo);
				}
				break;
			case 2:
				System.out.print("Ingrese el código del grupo: ");
				String nuevoCodigo = teclado.next();
				System.out.print("Ingrese el codigo del curso: ");
				String nuecoCodCurso = teclado.next();
				System.out.print("Ingrese el nuevo del nombre: ");
				String nuevoNombre = teclado.next();
				System.out.print("Ingrese el Codigo del turno: ");
				String nuevoTurno = teclado.next();
				System.out.print("Ingrese el nuevo nº del Maximo de Alumnos: ");
				int nuevoMaxAlumnos = teclado.nextInt();

				Grupo nuevoGrupo = new Grupo(nuevoCodigo, nuecoCodCurso, nuevoNombre, nuevoTurno, nuevoMaxAlumnos);

				grupoDAO.insertar(nuevoGrupo);
				System.out.println("Grupo añadido correctamente.");
				break;
			case 3:
				System.out.print("Ingrese el código del grupo: ");
				nuevoCodigo = teclado.next();
				System.out.print("Ingrese el codigo del curso: ");
				nuecoCodCurso = teclado.next();
				System.out.print("Ingrese el nuevo del nombre: ");
				nuevoNombre = teclado.next();
				System.out.print("Ingrese el Codigo del turno: ");
				nuevoTurno = teclado.next();
				System.out.print("Ingrese el nuevo nº del Maximo de Alumnos: ");
				nuevoMaxAlumnos = teclado.nextInt();

				Grupo actualizarGrupo = new Grupo(nuevoCodigo, nuecoCodCurso, nuevoNombre, nuevoTurno, nuevoMaxAlumnos);

				grupoDAO.actualizar(actualizarGrupo);
				System.out.println("Grupo actualizado correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID del Grupo a eliminar: ");
				String idEliminar = teclado.nextLine();

				Grupo eliminarGrupo = new Grupo(idEliminar);
				grupoDAO.eliminar(eliminarGrupo);

				System.out.println("Grupo eliminado correctamente");
				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;
			}

		}
	}

	public static void MenuAsignatura(Scanner teclado, AsignaturaDAO asignaturaDAO) {

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_GRUPO);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 1:
				List<Asignatura> asinaturas = asignaturaDAO.seleccionar();
				for (Asignatura asignatura : asinaturas) {
					System.out.println(asignatura);
				}
				break;
			case 2:
				System.out.print("Ingrese el código del asignatura: ");
				String nuevoCodigo = teclado.next();
				System.out.print("Ingrese el codigo del interno: ");
				String nuevoCodInterno = teclado.next();
				System.out.print("Ingrese la nueva descripcion: ");
				String nuevaDescripcion = teclado.next();
				System.out.print("Ingrese el nuevo nº de horas: ");
				int nuevoNHoras = teclado.nextInt();
				System.out.print("Ingrese el Codigo del curso: ");
				String nuevoCodCurso = teclado.next();
			

				Asignatura nuevaAsignatura = new Asignatura(nuevoCodigo, nuevoCodInterno, nuevaDescripcion, nuevoNHoras, nuevoCodCurso);
				asignaturaDAO.insertar(nuevaAsignatura);
				
				System.out.println("Asignatura añadida correctamente.");
				break;
				
			case 3:
				System.out.print("Ingrese el código del asignatura: ");
				 nuevoCodigo = teclado.next();
				System.out.print("Ingrese el codigo del interno: ");
				 nuevoCodInterno = teclado.next();
				System.out.print("Ingrese la nueva descripcion: ");
				 nuevaDescripcion = teclado.next();
				System.out.print("Ingrese el nuevo nº de horas: ");
				 nuevoNHoras = teclado.nextInt();
				System.out.print("Ingrese el Codigo del curso: ");
				 nuevoCodCurso = teclado.next();
			

				Asignatura actualizarAsignatura = new Asignatura(nuevoCodigo, nuevoCodInterno, nuevaDescripcion, nuevoNHoras, nuevoCodCurso);
				asignaturaDAO.actualizar(actualizarAsignatura);
				
				System.out.println("Asignatura actualizada correctamente.");
				break;
			case 4:
				teclado.nextLine();
				System.out.print("Ingrese el ID de la Asignatura a eliminar: ");
				String idEliminar = teclado.nextLine();

				Asignatura AsignaturaDelete = new Asignatura(idEliminar);
				asignaturaDAO.eliminar(AsignaturaDelete);

				System.out.println("Asignatura eliminado correctamente");
				break;
			case 0:
				fin = false;
				break;
			default:
				System.err.println("Escribe una opcion valida");
				break;
			}
		}
	}

}
