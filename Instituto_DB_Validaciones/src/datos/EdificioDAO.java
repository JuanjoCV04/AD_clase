package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Edificio;

public class EdificioDAO {

    private static final String SQL_SELECT = "SELECT cod_edificio, nombre FROM edificio";

    private static final String SQL_INSERT = "INSERT INTO edificio(cod_edificio, nombre) VALUES(?,?)";

    private static final String SQL_UPDATE = "UPDATE edificio SET nombre=? WHERE cod_edificio=?";

    private static final String SQL_DELETE = "DELETE FROM edificio WHERE cod_edificio=?";

    public List<Edificio> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Edificio edificio = null;
        List<Edificio> edificios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String cod_edificio = rs.getString("cod_edificio");
                String nombre = rs.getString("nombre");

                edificio = new Edificio(cod_edificio, nombre);
                edificios.add(edificio);
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
        return edificios;
    }

    public int insertar(Edificio edificio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, edificio.getCod_edificio());
            stmt.setString(2, edificio.getNombre());

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

    public int actualizar(Edificio edificio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, edificio.getNombre());
            stmt.setString(2, edificio.getCod_edificio());

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

    public int eliminar(Edificio edificio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, edificio.getCod_edificio());

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
