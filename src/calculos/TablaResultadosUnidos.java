package calculos;

import java.io.*;
import java.sql.*;
import javax.swing.*;

import controlBase.UtilBase;

public class TablaResultadosUnidos {

	public static void main(String[] args) {

		try {
			crearTablaResultadosUnidos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void crearTablaResultadosUnidos() throws IOException, SQLException {

		String numero_tienda = "";
		String referencia = "";
		String cantidad = "";
		String lineaLeida = "";
		Connection conexion = UtilBase.createConnection();
		CallableStatement statement = conexion.prepareCall("{call insert_resultados_unidos(?,?,?)}");

		JOptionPane.showMessageDialog(null, "Hola");
		
		// Capturar el número de tienda.
		File[] ruta = null;
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		chooser.setMultiSelectionEnabled(true);
		int seleccion = chooser.showOpenDialog(null);

		switch (seleccion) {
		case JFileChooser.APPROVE_OPTION:
			ruta = chooser.getSelectedFiles();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Selecciona la ruta de inicio", "Error al seleccionar",
					JOptionPane.ERROR_MESSAGE, null);
			break;
		}

		for (File file : ruta) {

			String nombre_fichero = file.getName();

			numero_tienda = nombre_fichero.substring(7, 10);
			
			statement.setString(1, numero_tienda);

			BufferedReader buffer = ControlFicheros.getBufferFicheroFile(file);

			while ((lineaLeida = buffer.readLine()) != null) {
				
				String [] fields = lineaLeida.split(";");
				
				//referencia = lineaLeida.substring(0,8);
				referencia = fields[0];				
				cantidad = fields[5];
				
				statement.setString(2, referencia);
				statement.setString(3, cantidad);
				
				statement.execute();
				
				
			}
		}

	}

}
