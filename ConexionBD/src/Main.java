import java.sql.Date;
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

		Empleado empleadoNuevo = new Empleado("11.000.111", "Pepe Shanchez", 'V',
				new Date(TimeUnit.SECONDS.toMillis(972294917)), new Date(2000 - 10 - 10), 20000.00f, 2000.00f,
				"Pringao", "11.111.111", "4000");

		Empleado empleadoModificar = new Empleado("Jose Shanchez", 'V', new Date(TimeUnit.SECONDS.toMillis(972294917)),
				new Date(TimeUnit.SECONDS.toMillis(1698054917)), 20000.00f, 2000.00f, "Pringao", "11.111.111", "4000",
				"11.000.111");

		Empleado empleadoDelete = new Empleado("11.000.111");
		// empleadoDao.insertar(empleadoNuevo);
		// empleadoDao.actualizar(empleadoModificar);
		// empleadoDao.delete(empleadoDelete);

		// SENTENCIAS DE DEPARTAMENTO

		DepartamentoDAO departamentoDao = new DepartamentoDAO();

		Departamento departamentoNuevo = new Departamento("5000", "MARKETING", "MURCIA", "22.222.222");

		Departamento departamentoModificar = new Departamento("MARKETING", "MURCIA", "31.178.144", "5000");

		Departamento departamentoDelete = new Departamento("5000");

		departamentoDao.insertar(departamentoNuevo);
		//departamentoDao.actualizar(departamentoModificar);
		//departamentoDao.delete(departamentoDelete);
		
		//EJECUCION
		List<Empleado> empleados = empleadoDao.seleccionar();

		List<Departamento> departamentos = departamentoDao.seleccionar();

		System.out.println("Elige la tabla:");
		System.out.println("1- Empleados");
		System.out.println("2- Departamentos");
		System.out.print("Opcion: ");
		int op = teclado.nextInt();
		System.out.println();

		if (op == 1) {
			empleados.forEach(empleado -> {
				System.out.println(empleado);
			});
		} else if (op == 2) {
			for (Departamento departamento : departamentos) {
				System.out.println(departamento);
			}
		}
	}
}