import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import domain.Empleado;
import domain.Departamento;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Sentencias empleado
		EmpleadoDAO empleadoDao = new EmpleadoDAO();

		// SENTENCIAS DE DEPARTAMENTO

		DepartamentoDAO departamentoDao = new DepartamentoDAO();

		// departamentoDao.insertar(departamentoNuevo);
		// departamentoDao.actualizar(departamentoModificar);
		// departamentoDao.delete(departamentoDelete);

		// EJECUCION
		List<Empleado> empleados = empleadoDao.seleccionar();

		List<Departamento> departamentos = departamentoDao.seleccionar();

		boolean ejecutar = true;

		while (ejecutar) {
			System.out.println("----------------MENU-----------------");
			System.out.println("1- Añadir Empleado");
			System.out.println("2- Borrar Empleado");
			System.out.println("3- Actualizar datos de empleado");
			System.out.println("4- Mostrar todos los empleados");
			System.out.println("5- Añadir Departamento");
			System.out.println("6- Borar Departamento");
			System.out.println("7- Actualizar departamento");
			System.out.println("8- Mostrar todos los Departamentos");
			System.out.println("0- Salir");

			System.out.print("Opcion: ");
			int op = teclado.nextInt();
			System.out.println();

			switch (op) {
			case 1:
				System.out.println("Añade un nuevo empleado");
				teclado.nextLine();

				System.out.print("Id: ");
				String idEmpleado = teclado.nextLine();

				System.out.print("Nombre: ");
				String nombre = teclado.nextLine();

				System.out.print("Sexo: ");
				String sexo1 = teclado.nextLine();
				char sexo = sexo1.charAt(0);

				System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
				String fecNac = teclado.nextLine();
				Date FeNAc = Date.valueOf(fecNac);

				System.out.print("Fecha de incorporación (yyyy-MM-dd): ");
				String fecIncorporacion = teclado.nextLine();
				Date FecIncorporacion = Date.valueOf(fecIncorporacion);

				System.out.print("Salario: ");
				float salario = teclado.nextFloat();

				System.out.print("Comisión: ");
				float comision = teclado.nextFloat();

				teclado.nextLine();

				System.out.print("Cargo: ");
				String cargo = teclado.nextLine();

				System.out.print("Id del jefe: ");
				String jefeId = teclado.nextLine();

				System.out.print("Código del departamento: ");
				String codDept = teclado.nextLine();

				Empleado empleadoNuevo = new Empleado(idEmpleado, nombre, sexo, FeNAc, FecIncorporacion, salario,
						comision, cargo, jefeId, codDept);

				empleadoDao.insertar(empleadoNuevo);

				break;

			case 2:
				System.out.println("Borra un empleado por su id");
				teclado.nextLine();

				System.out.print("Id empleado: ");
				String id = teclado.nextLine();

				Empleado empleadoDelete = new Empleado(id);
				empleadoDao.delete(empleadoDelete);
				break;

			case 3:
				System.out.println("Actualiza un empleado");
				teclado.nextLine();

				System.out.print("Id: ");
				String idEmpleadoNew = teclado.nextLine();

				System.out.print("Nombre: ");
				String nombreNew = teclado.nextLine();

				System.out.print("Sexo: ");
				String sexo1New = teclado.nextLine();
				char sexoNew = sexo1New.charAt(0);

				System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
				String fecNacNew = teclado.nextLine();
				Date FeNAcNew = Date.valueOf(fecNacNew);

				System.out.print("Fecha de incorporación (yyyy-MM-dd): ");
				String fecIncorporacionNew = teclado.nextLine();
				Date FecIncorporacionNew = Date.valueOf(fecIncorporacionNew);

				System.out.print("Salario: ");
				float salarioNew = teclado.nextFloat();

				System.out.print("Comisión: ");
				float comisionNew = teclado.nextFloat();

				teclado.nextLine();

				System.out.print("Cargo: ");
				String cargoNew = teclado.nextLine();

				System.out.print("Id del jefe: ");
				String jefeIdNew = teclado.nextLine();

				System.out.print("Código del departamento: ");
				String codDeptNew = teclado.nextLine();

				Empleado empleadoModificar = new Empleado(idEmpleadoNew, nombreNew, sexoNew, FeNAcNew,
						FecIncorporacionNew, salarioNew, comisionNew, cargoNew, jefeIdNew, codDeptNew);

				empleadoDao.actualizar(empleadoModificar);

				break;

			case 4:
				empleados.forEach(empleado -> {
					System.out.println(empleado);
				});
				break;

			case 5:
				System.out.println("Añade un nuevo Departamento");
				teclado.nextLine();

				System.out.print("Codigo de departamento: ");
				String codDepto = teclado.nextLine();

				System.out.print("Nombre del departamento: ");
				String nombreDpto = teclado.nextLine();

				System.out.print("Ciudad: ");
				String ciudad = teclado.nextLine();

				System.out.println("Codigo director: ");
				String codDirector = teclado.nextLine();

				Departamento departamentoNuevo = new Departamento(codDepto, nombreDpto, ciudad, codDirector);
				departamentoDao.insertar(departamentoNuevo);
				break;

			case 6:
				System.out.println("Borra un departamento por codDepto");
				teclado.nextLine();

				System.out.print("Codigo de departamento: ");
				String codDpto = teclado.nextLine();

				Departamento departamentoDelete = new Departamento(codDpto);
				departamentoDao.delete(departamentoDelete);
				break;

			case 7:
				System.out.println("Actualiza un Departamento:");
				teclado.nextLine();

				System.out.print("Codigo de departamento: ");
				String codDeptoNew = teclado.nextLine();

				System.out.print("Nombre del departamento: ");
				String nombreDptoNew = teclado.nextLine();

				System.out.print("Ciudad: ");
				String ciudadNew = teclado.nextLine();

				System.out.println("Codigo director: ");
				String codDirectorNew = teclado.nextLine();

				Departamento departamentoModificar = new Departamento(codDeptoNew, nombreDptoNew, ciudadNew,
						codDirectorNew);
				departamentoDao.actualizar(departamentoModificar);
				break;

			case 8:
				for (Departamento departamento : departamentos) {
					System.out.println(departamento);
				}
				break;

			case 0:
				System.out.println("Adios...");
				ejecutar = false;
				break;

			default:
				System.out.println("Seleciona una opcion!!!!");
				System.out.println("--------------------------");
				break;
			}

		}
		teclado.close();
	}
}