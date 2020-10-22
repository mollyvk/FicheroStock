package calculos;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JOptionPane;

import controlBase.UtilBase;

public class AccionesBotonesBase implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String botonSeleccionado = e.getActionCommand();

		switch (botonSeleccionado) {
		case "Borrar base":
			try {
				// Conectar base
				Connection conexion = UtilBase.getConnection();

				// Crear el statement
				Statement statement = conexion.createStatement();

				// Ejecutar la consulta
				statement.executeUpdate("DELETE FROM `prueba`");
				JOptionPane.showMessageDialog(null, "Se ha borrado la base de datos");

			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ha habido un error al borrar la base", "Error de conexión",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		case "Cargar base":
			try {

				// Obtener statement
				Statement statement = UtilBase.getStatement();

				statement.execute(
						"LOAD DATA LOCAL INFILE '/Users/pablofernandezmartinez/Desktop/Segmentación/fichero1.csv' INTO TABLE `prueba` FIELDS TERMINATED BY ';' ENCLOSED BY '\\\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\n'\n");

				// VALE, ESTO NO FUNCIONA "The used command is not allowed with this MySQL version"

				JOptionPane.showMessageDialog(null, "Importación terminada");

			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ha habido un error al cargar a la base", "Error de conexión",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
			
			
		case "Conseguir stock por día y tienda":
			
			break;

		default:
			break;
		}

	}

}