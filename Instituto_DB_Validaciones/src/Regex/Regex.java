package Regex;


import datos.AlumnoDAO;
import domain.Alumno;

public class Regex {

	private static final String NRE = "^\\d{8}$";
	private static final String DNI = "^[0-9]{8}[A-Za-z]$";
	private static final String LETRAS = "^[A-Za-zÀ-ÖØ-öø-ÿ'-]+$";
	private static final String TELEFONO = "^[0-9]{9}$";
	private static final String CP = "^\\d{5}$";
	private static final String FECHA = "^\\d{4}-\\d{2}-\\d{2}$";
	private static final String GMAIL = "^[a-zA-Z0-9_.]+@gmail\\.com$";


	public static boolean ValidarNre(String nre) {
		return nre.matches(NRE);
	}

	public static boolean ExistenciaNre(String nre, AlumnoDAO alumnoDAO) {

		for (Alumno alumno : alumnoDAO.selecionar()) {
			if (nre.equals(alumno.getNre())) {
				return true;
			}
		}
		return false;

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
