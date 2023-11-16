package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CodigoPostal;


public class CodigoPostalDAO {

	private static final String SQL_SELECT = "SELECT cp,poblacion,provincia FROM codigopostal";

	
	 public List<CodigoPostal> seleccionar() {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        CodigoPostal codigopostal = null;
	        List<CodigoPostal> codigopostales = new ArrayList<>();

	        try {
	            conn = Conexion.getConnection();
	            stmt = conn.prepareStatement(SQL_SELECT);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                String cp = rs.getString("cp");
	                String poblacion = rs.getString("poblacion");
	                String provincia = rs.getString("provincia");
	                
	                codigopostal = new CodigoPostal(cp, poblacion, provincia);
	                codigopostales.add(codigopostal);
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
	        return codigopostales;
	    }

	
	
}
