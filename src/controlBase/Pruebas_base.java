package controlBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Pruebas_base {

	public static void main(String[] args) {

		// Código de conexión SSH con key pair copiado de
		// https://ayoub.io/2016/06/29/using-jsch-for-ssh-port-forwarding-java.html
		JSch j = new JSch();
		Session session = null;
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
			session.setPortForwardingL(8085, "localhost", 3306);

			Connection conexion = null;

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:8085/stc_lm", "pablo",
					"jucvE7-kiqzor-mavjob");

			Statement st = conexion.createStatement();

			String sql = "SELECT * FROM `prueba`";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				System.out.println(rs.getString(1) + " - " + rs.getString(2));
			}

		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
