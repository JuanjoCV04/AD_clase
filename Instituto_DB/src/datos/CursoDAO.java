package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Curso;

public class CursoDAO {

    private static final String SQL_SELECT = "SELECT cod_curso, nombre, descripcion FROM curso";

    private static final String SQL_INSERT = "INSERT INTO curso(cod_curso, nombre, descripcion) VALUES(?,?,?)";

    private static final String SQL_UPDATE = "UPDATE curso SET nombre=?, descripcion=? WHERE cod_curso=?";

    private static final String SQL_DELETE = "DELETE FROM curso WHERE cod_curso=?";

    public List<Curso> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cod_curso = rs.getString("cod_curso");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                curso = new Curso(cod_curso, nombre, descripcion);
                cursos.add(curso);
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
        return cursos;
    }

    public int insertar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, curso.getCod_curso());
            stmt.setString(2, curso.getNombre());
            stmt.setString(3, curso.getDescripcion());

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

    public int actualizar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getCod_curso());

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

    public int eliminar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, curso.getCod_curso());

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
