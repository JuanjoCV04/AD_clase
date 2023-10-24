import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Departamento;
import domain.Empleado;

public class DepartamentoDAO {
	private static final String SQL_SELECT = "SELECT codDepto,nombreDpto,ciudad,codDirector FROM departamentos";

	private static final String SQL_INSERT = "INSERT INTO departamentos(codDepto,nombreDpto,ciudad,codDirector) VALUES(?,?,?,?)";

	private static final String SQL_UPDATE = "UPDATE departamentos SET nombreDpto=? ,ciudad=? ,codDirector=? WHERE codDepto=?";

	private static final String SQL_DELETE = "DELETE FROM departamentos WHERE codDepto=?";

	

	public List<Departamento> seleccionar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Departamento departamento = null;
		List<Departamento> departamentos = new ArrayList<>();

		try {

			conn = Conexion.getConnection();

			stmt = conn.prepareStatement(SQL_SELECT);

			rs = stmt.executeQuery();

			while (rs.next()) {
				String codDepto = rs.getString("codDepto");
				String nombreDpto = rs.getString("nombreDpto");
				String ciudad = rs.getString("ciudad");
				String codDirector = rs.getString("codDirector");

				departamento = new Departamento(codDepto, nombreDpto, ciudad, codDirector);

				departamentos.add(departamento);
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

		return departamentos;
	}

	public int insertar(Departamento departamento) {

		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);

			stmt.setString(1, departamento.getCodDepto());
			stmt.setString(2, departamento.getNombreDepto());
			stmt.setString(3, departamento.getCiudad());
			stmt.setString(4, departamento.getCodDirector());
			

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

	public int actualizar(Departamento departamento) {

		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);

			stmt.setString(1, departamento.getNombreDepto());
			stmt.setString(2, departamento.getCiudad());
			stmt.setString(3, departamento.getCodDirector());
			stmt.setString(4, departamento.getCodDepto());

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

	public int delete(Departamento departamento) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			System.out.println("Ejecuntando Consulta: " + SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);

			stmt.setString(1, departamento.getCodDepto());

			registro = stmt.executeUpdate();
			System.err.println("REGISTROS ELIMINADOS: " + registro);

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
