package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Grupo;

public class GrupoDAO {

    private static final String SQL_SELECT = "SELECT cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos FROM grupo";

    private static final String SQL_INSERT = "INSERT INTO grupo(cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos) VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE grupo SET cod_curso=?, nombre=?, cod_turno=?, nMaxAlumnos=? WHERE cod_grupo=?";

    private static final String SQL_DELETE = "DELETE FROM grupo WHERE cod_grupo=?";

    public List<Grupo> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Grupo grupo = null;
        List<Grupo> grupos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cod_grupo = rs.getString("cod_grupo");
                String cod_curso = rs.getString("cod_curso");
                String nombre = rs.getString("nombre");
                String cod_turno = rs.getString("cod_turno");
                int nMaxAlumnos = rs.getInt("nMaxAlumnos");

                grupo = new Grupo(cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos);
                grupos.add(grupo);
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
        return grupos;
    }

    public int insertar(Grupo grupo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, grupo.getCod_grupo());
            stmt.setString(2, grupo.getCod_curso());
            stmt.setString(3, grupo.getNombre());
            stmt.setString(4, grupo.getCod_turno());
            stmt.setInt(5, grupo.getnMaxAlumnos());

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

    public int actualizar(Grupo grupo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, grupo.getCod_curso());
            stmt.setString(2, grupo.getNombre());
            stmt.setString(3, grupo.getCod_turno());
            stmt.setInt(4, grupo.getnMaxAlumnos());
            stmt.setString(5, grupo.getCod_grupo());

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

    public int eliminar(Grupo grupo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, grupo.getCod_grupo());

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
