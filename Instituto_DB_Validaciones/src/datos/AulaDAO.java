package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Aula;

public class AulaDAO {

    private static final String SQL_SELECT = "SELECT num_aula, cod_edificio FROM aula";

    private static final String SQL_INSERT = "INSERT INTO aula(num_aula, cod_edificio) VALUES(?,?)";

    private static final String SQL_UPDATE = "UPDATE aula SET cod_edificio=? WHERE num_aula=?";

    private static final String SQL_DELETE = "DELETE FROM aula WHERE num_aula=?";

    public List<Aula> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aula aula = null;
        List<Aula> aulas = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String num_aula = rs.getString("num_aula");
                String cod_edificio = rs.getString("cod_edificio");

                aula = new Aula(num_aula, cod_edificio);
                aulas.add(aula);
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
        return aulas;
    }

    public int insertar(Aula aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, aula.getNum_aula());
            stmt.setString(2, aula.getCod_edificio());

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

    public int actualizar(Aula aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, aula.getCod_edificio());
            stmt.setString(2, aula.getNum_aula());

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

    public int eliminar(Aula aula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, aula.getNum_aula());

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
