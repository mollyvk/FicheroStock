package calculos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

/**
 * 
 * Esta clase sirve para hacer los cálculos necesarios para la interfaz gráfica. Debe recibir una ruta al fichero que se quiere tratar.
 * 
 * @author pablofernandezmartinez
 *
 * @version 0.00
 *
 */
public class Calculos {

	public Calculos() {

		// ArrayList<String> datos = recuperarFichero();
		obtenerDatosFichero();

	}

	
	// public ArrayList<String> recuperarFichero() {
	public void obtenerDatosFichero() {
		ArrayList<Seccion> listadoFamilias = new ArrayList<Seccion>();
		Seccion seccionObj = new Seccion(null);
		;
		String linea = "";
		int referenciasDiaria = 0;
		int cantidadDiaria = 0;

		try {

			BufferedReader buffer = ControlFicheros.getBufferFichero();


			// Recorremos el fichero
			while ((linea = buffer.readLine()) != null) {

				String familia = "";
				// linea = buffer.readLine();

				if (linea.contains("  creflash")) {

					// Guardamos la seccion
					buffer.readLine();
					linea = buffer.readLine();
					// System.out.println(linea);

					familia += linea.charAt(45);
					familia += linea.charAt(46);
					familia += "-";
					familia += linea.charAt(49);
					familia += linea.charAt(50);
					familia += "-";
					familia += linea.charAt(53);
					familia += linea.charAt(54);
					familia += "-";
					familia += linea.charAt(56);
					familia += linea.charAt(57);

					// creamos el objeto seccion y guarmaos su nombre
					seccionObj = new Seccion(familia);

					// System.out.println(seccionObj.getNombre());

					listadoFamilias.add(seccionObj);

				} else {
					if (linea.length() >= 15) {
						String codigoInterno = linea.substring(15, 23);
						String cantidad = linea.substring(68, 72);
						cantidad = cantidad.replace(" ", ""); // Podemos hacerlo con trim

						if (codigoInterno.matches("[0-9]{8}")) {
							Integer cantidadInt = Integer.parseInt(cantidad);
							// System.out.println(substr + " - "+ cantidad);
							seccionObj.anadirReferencia(codigoInterno, cantidadInt);

						}
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Seccion seccion : listadoFamilias) {
			System.out.println(seccion.getNombre());
			System.out.println("Las cantidades de esta sección son: " + seccion.getTotalCantidades());
			System.out.println(seccion.getReferenciasCantidades());
			cantidadDiaria += seccion.getTotalCantidades();
			referenciasDiaria += seccion.getTotalReferencias();
		}

		System.out.println("TOTAL DE FAMILIAS: " + listadoFamilias.size());
		System.out.println("TOTAL DE REFERENCIAS: " + referenciasDiaria);
		System.out.println("TOTAL DE CANTIDADES: " + cantidadDiaria);
	}



	
	
}
