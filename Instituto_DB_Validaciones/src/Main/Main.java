package Main;

import datos.*;
import Config.Config;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
		AulaDAO aulaDAO = new AulaDAO();
		CursoDAO cursoDAO = new CursoDAO();
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		EdificioDAO edificioDAO = new EdificioDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		ProfesorDAO profesorDAO = new ProfesorDAO();
		TurnoDAO turnoDAO = new TurnoDAO();

		boolean fin = true;

		while (fin) {
			System.out.println(Config.MENU_PRINCIPAL);
			System.out.print("Opcion: ");
			int op = teclado.nextInt();

			switch (op) {
			case 0:
				System.out.println("Cerrando..");
				fin = false;
				break;
			case 1:
				Config.MenuAlumno(teclado, alumnoDAO);
				break;
			case 2:
				Config.MenuDepartamento(teclado, departamentoDAO);
				break;

			case 3:
				Config.MenuProfesor(teclado, profesorDAO);
				break;

			case 4:
				Config.MenuEdificio(teclado, edificioDAO);
				break;

			case 5:
				Config.MenuAula(teclado, aulaDAO);
				break;

			case 6:
				Config.MenuCurso(teclado, cursoDAO);
				break;

			case 7:
				Config.MenuTurno(teclado, turnoDAO);
				break;

			case 8:
				Config.MenuGrupo(teclado, grupoDAO);
				break;

			case 9:
				Config.MenuAsignatura(teclado, asignaturaDAO);
				break;

			case 10:
				System.out.println("Proximamente...");
				break;
			default:
				System.err.println("Elige una opcion valida.");
				break;
			}
		}

	}

}
