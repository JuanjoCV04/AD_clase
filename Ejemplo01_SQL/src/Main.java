import java.sql.*;

public class Main {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/empleadoss_departamentoss";

		try {

			// Class.forName("com.mysql.jdbc.Driver)
			Connection conexion = DriverManager.getConnection(url, "root", "root");

			Statement instruccion = conexion.createStatement();
			
			String sql = "Select codDepto , nombreDpto FROM departamentos;";
			
			ResultSet resultado = instruccion.executeQuery(sql);
			
			while(resultado.next()) {
				
				System.out.println("Departamento: " + resultado.getInt("codDepto") );
				System.out.println("Nombre: "+ resultado.getString("nombreDpto"));
				System.out.println("");
			}
			resultado.close();
			instruccion.close();
			conexion.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
