package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Asignatura;

public class AsignaturaDAO {

    private static final String SQL_SELECT = "SELECT cod_asignatura, cod_interno, descripcion, nHoras, cod_curso FROM asignatura";

    private static final String SQL_INSERT = "INSERT INTO asignatura(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso) VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE asignatura SET cod_interno=?, descripcion=?, nHoras=?, cod_curso=? WHERE cod_asignatura=?";

    private static final String SQL_DELETE = "DELETE FROM asignatura WHERE cod_asignatura=?";

    public List<Asignatura> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Asignatura asignatura = null;
        List<Asignatura> asignaturas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cod_asignatura = rs.getString("cod_asignatura");
                String cod_interno = rs.getString("cod_interno");
                String descripcion = rs.getString("descripcion");
                int nHoras = rs.getInt("nHoras");
                String cod_curso = rs.getString("cod_curso");

                asignatura = new Asignatura(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso);
                asignaturas.add(asignatura);
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
        return asignaturas;
    }

    public int insertar(Asignatura asignatura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, asignatura.getCod_asignatura());
            stmt.setString(2, asignatura.getCod_interno());
            stmt.setString(3, asignatura.getDescripcion());
            stmt.setInt(4, asignatura.getnHoras());
            stmt.setString(5, asignatura.getCod_curso());

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

    public int actualizar(Asignatura asignatura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, asignatura.getCod_interno());
            stmt.setString(2, asignatura.getDescripcion());
            stmt.setInt(3, asignatura.getnHoras());
            stmt.setString(4, asignatura.getCod_curso());
            stmt.setString(5, asignatura.getCod_asignatura());

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

    public int eliminar(Asignatura asignatura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, asignatura.getCod_asignatura());

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
