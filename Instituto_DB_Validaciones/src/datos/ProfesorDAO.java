package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Profesor;

public class ProfesorDAO {

    private static final String SQL_SELECT = "SELECT nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento FROM profesor";

    private static final String SQL_INSERT = "INSERT INTO profesor(nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE profesor SET dni=?, nombre=?, apellido1=?, apellido2=?, tipo_via=?, nombre_via=?, numero=?, escalera=?, piso=?, puerta=?, cp=?, pais=?, tlfn_fijo=?, tlfn_movil=?, email=?, fecha_nac=?, cod_departamento=? WHERE nrp=?";

    private static final String SQL_DELETE = "DELETE FROM profesor WHERE nrp=?";

    public List<Profesor> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profesor profesor = null;
        List<Profesor> profesores = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

            	String nrp = rs.getString("nrp");
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
            	String cod_departamento = rs.getString("cod_departamento");

            	profesor = new Profesor(nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso,
            	    puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento);
            	profesores.add(profesor);

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
        return profesores;
    }

    public int insertar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, profesor.getNrp());
            stmt.setString(2, profesor.getDni());
            stmt.setString(3, profesor.getNombre());
            stmt.setString(4, profesor.getApellido1());
            stmt.setString(5, profesor.getApellido2());
            // Resto de los campos...

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

    public int actualizar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, profesor.getDni());
            stmt.setString(2, profesor.getNombre());
            stmt.setString(3, profesor.getApellido1());
            stmt.setString(4, profesor.getApellido2());
            // Resto de los campos...
            stmt.setString(18, profesor.getNrp());

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

    public int eliminar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, profesor.getNrp());

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
}
