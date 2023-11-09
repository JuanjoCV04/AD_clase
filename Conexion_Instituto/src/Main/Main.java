package Main;

import domain.*;
import datos.*;
import Config.Config;
import java.util.List;
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
				System.out.println(Config.MENU_ALUMNO);
				Config.MenuAlumno(teclado, alumnoDAO);
				break;
			case 2:
				System.out.println(Config.MENU_DEPARTAMENTO);

				break;

			case 3:
				System.out.println(Config.MENU_PROFESOR);

				break;

			case 4:
				System.out.println(Config.MENU_EDIFICIO);

				break;

			case 5:
				System.out.println(Config.MENU_AULA);

				break;

			case 6:
				System.out.println(Config.MENU_CURSO);

				break;

			case 7:
				System.out.println(Config.MENU_TURNO);

				break;

			case 8:
				System.out.println(Config.MENU_GRUPO);

				break;

			case 9:
				System.out.println(Config.MENU_ASIGNATURA);

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
