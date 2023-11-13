package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Turno;

public class TurnoDAO {

    private static final String SQL_SELECT = "SELECT cod_turno, horario FROM turno";

    private static final String SQL_INSERT = "INSERT INTO turno(cod_turno, horario) VALUES(?,?)";

    private static final String SQL_UPDATE = "UPDATE turno SET horario=? WHERE cod_turno=?";

    private static final String SQL_DELETE = "DELETE FROM turno WHERE cod_turno=?";

    public List<Turno> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Turno turno = null;
        List<Turno> turnos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cod_turno = rs.getString("cod_turno");
                String horario = rs.getString("horario");

                turno = new Turno(cod_turno, horario);
                turnos.add(turno);
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
        return turnos;
    }

    public int insertar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, turno.getCod_turno());
            stmt.setString(2, turno.getHorario());

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

    public int actualizar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, turno.getHorario());
            stmt.setString(2, turno.getCod_turno());

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

    public int eliminar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, turno.getCod_turno());

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
