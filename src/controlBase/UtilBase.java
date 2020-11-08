package controlBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlDataSource;

public class UtilBase {

	private static Session session = null;
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		JSch j = new JSch();
		Session session = null;
		Connection conexion = null;

		try {
			j.addIdentity(
					"/Users/pablofernandezmartinez/Dropbox/_Formación/_GS DAM/Otras cosas/LightsailDefaultKey-eu-west-3.pem");

			j.setKnownHosts("/home/reporting/.ssh/known_hosts");

			session = j.getSession("bitnami", "15.188.23.247", 22);

			// Ojo, este código parece que puede crear alguna inseguiridad. Seguir la pista
			// de
			// https://stackoverflow.com/questions/2003419/com-jcraft-jsch-jschexception-unknownhostkey

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			///// Hasta aquí

			session.connect();
			session.setPortForwardingL(8086, "localhost", 3306);

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:8086/stc_lm", "pablo",
					"jucvE7-kiqzor-mavjob");

			// Recuerda crear un método para cerrar las conexiones. 
			
			
//		Connection conexion = null;
//
//		conexion = DriverManager.getConnection(
//				"jdbc:mysql://localhost:8889/stc_lm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//				"root", "root");
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexion;

	}

	public static Statement getStatement() throws SQLException {

		Statement statement = getConnection().createStatement();

		return statement;

	}

	public static TreeMap<String, String> getTiendas() throws SQLException {

		TreeMap<String, String> listaTiendas = null;

		listaTiendas = new TreeMap<>();

		Statement statement = UtilBase.getStatement();

		String sql = "SELECT `nTienda`, `tienda` FROM tiendasConNumero";

		ResultSet resulset = statement.executeQuery(sql);

		cerrarPuertos();
		
		while (resulset.next()) {

			listaTiendas.put(resulset.getString(1), resulset.getString(2));

		}

		for (Map.Entry<String, String> entrada : listaTiendas.entrySet()) {

			System.out.println(entrada.getKey() + " - " + entrada.getValue());
		}

		return listaTiendas;
	}

	public static String[] getNumerosTiendas() {

		TreeMap<String, String> listaTiendas = null;
		try {
			listaTiendas = getTiendas();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error al cargar el listado de tiendas");
			e.printStackTrace();
		}

		String[] arrayNumeros = new String[listaTiendas.size()];

		int contador = 0;

		for (Map.Entry<String, String> entrada : listaTiendas.entrySet()) {

			arrayNumeros[contador] = entrada.getKey();

			contador++;
		}

		return arrayNumeros;
	}
	
	public static void cerrarPuertos() {
		//try {
			 // session.delPortForwardingL(8086);
			//  session.disconnect();
		//	} catch (JSchException e) {
		//	  e.printStackTrace();
		//	}
	}

}
