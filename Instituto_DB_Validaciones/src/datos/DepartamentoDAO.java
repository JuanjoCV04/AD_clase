package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Departamento;

public class DepartamentoDAO {

    private static final String SQL_SELECT = "SELECT cod_departamento, nombre, descripcion FROM departamento";

    private static final String SQL_INSERT = "INSERT INTO departamento(cod_departamento, nombre, descripcion) VALUES(?,?,?)";

    private static final String SQL_UPDATE = "UPDATE departamento SET nombre=?, descripcion=? WHERE cod_departamento=?";

    private static final String SQL_DELETE = "DELETE FROM departamento WHERE cod_departamento=?";

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
                String cod_departamento = rs.getString("cod_departamento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                departamento = new Departamento(cod_departamento, nombre, descripcion);
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

            stmt.setString(1, departamento.getCod_departamento());
            stmt.setString(2, departamento.getNombre());
            stmt.setString(3, departamento.getDeescripcion());

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

            stmt.setString(1, departamento.getNombre());
            stmt.setString(2, departamento.getDeescripcion());
            stmt.setString(3, departamento.getCod_departamento());

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

    public int eliminar(Departamento departamento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, departamento.getCod_departamento());

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
