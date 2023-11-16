package Regex;

import datos.*;
import domain.*;

public class Regex {

	private static final String NRE_NRP = "^\\d{8}$";
	private static final String DNI = "^[0-9]{8}[A-Za-z]$";
	private static final String LETRAS = "^[A-Za-zÀ-ÖØ-öø-ÿ'-]+$";
	private static final String NUMEROS = "^\\d$";
	private static final String TELEFONO = "^[0-9]{9}$";
	private static final String CP = "^\\d{5}$";
	private static final String COD_DEP = "^\\d{3}$";
	private static final String FECHA = "^\\d{4}-\\d{2}-\\d{2}$";
	private static final String GMAIL = "^[a-zA-Z0-9_.]+@gmail\\.com$";

	public static boolean ValidarNre(String nre) {
		return nre.matches(NRE_NRP);
	}

	public static boolean ValidarSoloNumeros(String n) {
		return n.matches(NUMEROS);
	}

	public static boolean ExistenciaCurso(String cod, CursoDAO cursoDAO) {

		for (Curso cursos : cursoDAO.seleccionar()) {
			if (cod.equals(cursos.getCod_curso())) {
				return true;
			}
		}

		return false;
	}

	public static boolean ExistenciaAula(String cod_aula, AulaDAO aulaDAO) {

		for (Aula aulas : aulaDAO.seleccionar()) {
			if (cod_aula.equals(aulas.getNum_aula())) {
				return true;

			}
		}

		return false;

	}

	public static boolean ExistenciaEdificio(String cod_edf, EdificioDAO edificioDAO) {

		for (Edificio edificios : edificioDAO.seleccionar()) {
			if (cod_edf.equals(edificios.getCod_edificio())) {
				return true;
			}
		}

		return false;
	}

	public static boolean ExistenciaNre(String nre, AlumnoDAO alumnoDAO) {

		for (Alumno alumno : alumnoDAO.selecionar()) {
			if (nre.equals(alumno.getNre())) {
				return true;
			}
		}
		return false;

	}

	public static boolean ExistenciaNrp(String nrp, ProfesorDAO profesorDAO) {

		for (Profesor profesor : profesorDAO.seleccionar()) {
			if (nrp.equals(profesor.getNrp())) {
				return true;
			}
		}
		return false;

	}

	public static boolean ExisteCodigoPostal(String cp, CodigoPostalDAO codigopostalDAO) {

		for (CodigoPostal cps : codigopostalDAO.seleccionar()) {
			if (cp.equals(cps.getCp())) {
				return true;
			}
		}
		return false;
	}

	public static boolean ExistenciaDepartamento(String dep, DepartamentoDAO departamentoDAO) {

		for (Departamento deps : departamentoDAO.seleccionar()) {
			if (dep.equals(deps.getCod_departamento())) {
				return true;
			}
		}
		return false;
	}

	public static boolean ValidarCodDepartamento(String codDep) {
		return codDep.matches(COD_DEP);
	}

	public static boolean ValidarDNI(String dni) {
		return dni.matches(DNI);
	}

	public static boolean ValidarLetras(String letras) {
		return letras.matches(LETRAS);
	}

	public static boolean ValidarTelefono(String telefono) {
		return telefono.matches(TELEFONO);
	}

	public static boolean ValidarCp(String cp) {
		return cp.matches(CP);
	}

	public static boolean ValidarFecha(String fecha) {
		return fecha.matches(FECHA);
	}

	public static boolean ValidarGmail(String gmail) {
		return gmail.matches(GMAIL);
	}

}
