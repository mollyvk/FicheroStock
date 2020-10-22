package controlBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Driver;

public class UtilBase {

	public static Connection getConnection() throws SQLException {

		Connection conexion = null;

		conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:8889/stc_lm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "root");

		return conexion;

	}

	public static Statement getStatement() throws SQLException {
		
		Statement statement = getConnection().createStatement();
		
		return statement;
		
	}
}
