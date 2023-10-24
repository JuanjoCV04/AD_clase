
import domain.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {

	private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";

	private static final String SQL_INSERT = "INSERT INTO empleados(nDIEmp,nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto) VALUES(?,?,?,?,?,?,?,?,?,?)";

	private static final String SQL_UPDATE = "UPDATE empleados SET nomEmp=?, sexEmp=?, fecNac=?, fecIncorporacion=?, salEmp=?, comisionE=?, cargoE=?, jefeID=?, codDepto=? WHERE nDIEmp=?";
	
	private static final String SQL_DELETE = "DELETE FROM empleados WHERE nDIEmp=?"; 
	
	public List<Empleado> seleccionar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Empleado empleado = null;
		List<Empleado> empleados = new ArrayList<>();

		try {

			conn = Conexion.getConnection();

			stmt = conn.prepareStatement(SQL_SELECT);

			rs = stmt.executeQuery();

			while (rs.next()) {
				String idEmpleado = rs.getString("nDIEmp");
				String nombre = rs.getString("nomEmp");
				String sexo = rs.getString("sexEmp");
				Date fecNac = rs.getDate("fecNac");
				Date fecIncorp = rs.getDate("fecIncorporacion");
				float salario = rs.getFloat("salEmp");
				float comision = rs.getFloat("comisionE");
				String cargo = rs.getString("cargoE");
				String jefe = rs.getString("jefeID");
				String departamento = rs.getString("codDepto");

				empleado = new Empleado(idEmpleado, nombre, sexo.charAt(0), fecNac, fecIncorp, salario, comision, cargo,
						jefe, departamento);

				empleados.add(empleado);
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

		return empleados;
	}

	public int insertar(Empleado empleado) {

		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;

		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);

			stmt.setString(1, empleado.getIdEmpleado());
			stmt.setString(2, empleado.getNombre());
			stmt.setString(3, empleado.getSexo());
			stmt.setDate(4, (java.sql.Date) empleado.getFecNac());
			stmt.setDate(5, (java.sql.Date) empleado.getFecIncorporacion());
			stmt.setFloat(6, empleado.getSalario());
			stmt.setFloat(7, empleado.getComision());
			stmt.setString(8, empleado.getCargo());
			stmt.setString(9, empleado.getJefeId());
			stmt.setString(10, empleado.getCodDept());

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
	
	public int actualizar(Empleado empleado) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, empleado.getNombre());
			stmt.setString(2, empleado.getSexo());
			stmt.setDate(3, (java.sql.Date) empleado.getFecNac());
			stmt.setDate(4, (java.sql.Date) empleado.getFecIncorporacion());
			stmt.setFloat(5, empleado.getSalario());
			stmt.setFloat(6, empleado.getComision());
			stmt.setString(7, empleado.getCargo());
			stmt.setString(8, empleado.getJefeId());
			stmt.setString(9, empleado.getCodDept());
			stmt.setString(10, empleado.getIdEmpleado());

			registro = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {

				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);

			}
		}
		
		return registro;
	}
	
	public int delete(Empleado empleado) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registro = 0;
		
		try {
			conn = Conexion.getConnection();
			System.out.println("Ejecuntando Consulta: " + SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setString(1, empleado.getIdEmpleado());
			
			
			registro = stmt.executeUpdate();
			System.err.println("REGISTROS ELIMINADOS: " +registro);
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
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
