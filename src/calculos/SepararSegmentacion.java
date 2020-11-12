package calculos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import controlBase.UtilBase;

public class SepararSegmentacion {

	
	private static UtilBase utilBase;
	
	public static void main(String[] args) {

		String inicio = "2020-11-12";

		String fin = "2020-11-13";

		String ruta = "/Users/pablofernandezmartinez/Desktop/JAR/segmentacion/";

		separarSegmentacion(ruta, inicio, fin, "*");
		
		
	}

	public static void separarSegmentacion(String ruta, String fecha_inicio, String fecha_fin, String tiendas) {

		try {

			utilBase = new UtilBase();
			
			double tiempo_inicio_conexion = System.currentTimeMillis();

			CallableStatement statement = utilBase.getConnexion().prepareCall("{call getSegmentacionIntervaloFechas(?, ?)}");


			statement.setString(1, fecha_inicio);

			statement.setString(2, fecha_fin);

			System.out.println("Tiempo de conexión: " + (System.currentTimeMillis() - tiempo_inicio_conexion));

			double tiempo_inicio_consulta = System.currentTimeMillis();

			ResultSet rs = statement.executeQuery();

			System.out.println("Tiempo de consulta: " + (System.currentTimeMillis() - tiempo_inicio_consulta));

			int nLineas = 0;

			double tiempo_inicio_escritura = System.currentTimeMillis();

			while (rs.next()) {

				String linea = rs.getString(10) + ";" + rs.getString(5) + rs.getString(1) + ";" + rs.getString(2) + ";"
						+ rs.getString(3) + ";" + rs.getString(4) + ";" + ";" + rs.getString(6) + ";" + rs.getString(7)
						+ ";" + rs.getString(8) + ";" + rs.getString(9).replaceAll("\\r", "") + "\n";

				FileWriter escritura = new FileWriter(ruta + rs.getString(5) + ".csv", true);

				escritura.write(linea);

				escritura.close();

				nLineas++;

			}

			System.out.println("Tiempo de escritura: " + (System.currentTimeMillis() - tiempo_inicio_escritura));

			System.out.println(nLineas);
			System.out.println("Tiempo total: " + (System.currentTimeMillis() - tiempo_inicio_conexion));

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error al acceder a la base.");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al escribir el fichero.");
			e.printStackTrace();
		} finally {

			utilBase.cerrarPuertos();

		}

	}

}
