package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Alumno;

public class AlumnoDAO {

	private static final String SQL_SELECT = "SELECT nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno";

	private static final String SQL_INSERT = "INSERT INTO alumno(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SQL_UPDATE = "UPDATE alumno SET nre=?, dni=?, nombre=?, apellido1=?, apellido2=?, tipo_via=?, nombre_via=?, numero=?, escalera=?, piso=?, puerta=?, cp=?, pais=?, tlfn_fijo=?, tlfn_movil=?, email=?, fecha_nac=?, tutor=? WHERE nre=?";

	private static final String SQL_DELETE = "DELETE FROM alumno WHERE nre=?";

	public List<Alumno> selecionar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Alumno alumno = null;
		List<Alumno> alumnos = new ArrayList<>();

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();

			while (rs.next()) {

				String nre = rs.getString("nre");
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				String tipo_via = rs.getString("tipo_via");
				String nombre_via = rs.getString("nombre_via");
				String numero = rs.getString("numero");
				String escalera = rs.getString("escalera");
				String piso = rs.getString("piso");
				String puerta = rs.getString("puerta");
				String cp = rs.getString("cp");
				String pais = rs.getString("pais");
				String tlfn_fijo = rs.getString("tlfn_fijo");
				String tlfn_movil = rs.getString("tlfn_movil");
				String email = rs.getString("email");
				Date fecha_nac = rs.getDate("fecha_nac");
				String tutor = rs.getString("tutor");

				alumno = new Alumno(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera,
						piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor);
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return alumnos;

	}

	public int insertar(Alumno alumno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);

			stmt.setString(1, alumno.getNre());
			stmt.setString(2, alumno.getDni());
			stmt.setString(3, alumno.getNombre());
			stmt.setString(4, alumno.getApellido1());
			stmt.setString(5, alumno.getApellido2());
			stmt.setString(6, alumno.getTipo_via());
			stmt.setString(7, alumno.getNombre_via());
			stmt.setString(8, alumno.getNumero());
			stmt.setString(9, alumno.getEscalera());
			stmt.setString(10, alumno.getPiso());
			stmt.setString(11, alumno.getPuerta());
			stmt.setString(12, alumno.getCp());
			stmt.setString(13, alumno.getPais());
			stmt.setString(14, alumno.getTlfn_fijo());
			stmt.setString(15, alumno.getTlfn_movil());
			stmt.setString(16, alumno.getEmail());
			stmt.setDate(17, alumno.getFecha_nac());
			stmt.setString(18, alumno.getTutor());

			registro = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {

				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);

			}
		}

		return registro;

	}

	public int actualizar(Alumno alumno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);

			stmt.setString(1, alumno.getDni());
			stmt.setString(2, alumno.getNombre());
			stmt.setString(3, alumno.getApellido1());
			stmt.setString(4, alumno.getApellido2());
			stmt.setString(5, alumno.getTipo_via());
			stmt.setString(6, alumno.getNombre_via());
			stmt.setString(7, alumno.getNumero());
			stmt.setString(8, alumno.getEscalera());
			stmt.setString(9, alumno.getPiso());
			stmt.setString(10, alumno.getPuerta());
			stmt.setString(11, alumno.getCp());
			stmt.setString(12, alumno.getPais());
			stmt.setString(13, alumno.getTlfn_fijo());
			stmt.setString(14, alumno.getTlfn_movil());
			stmt.setString(15, alumno.getEmail());
			stmt.setDate(16, alumno.getFecha_nac());
			stmt.setString(17, alumno.getTutor());
			stmt.setString(18, alumno.getNre());

			registro = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {

				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);

			}
		}

		return registro;

	}

	public int delete(Alumno alumno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			System.out.println("Ejecutando Consulta: " + SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);

			stmt.setString(1, alumno.getNre());

			registro = stmt.executeUpdate();
			System.out.println("REGISTROS ELIMINADOS: " + registro);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		}

		return registro;

	}
}
