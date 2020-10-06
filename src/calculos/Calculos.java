package calculos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

public class Calculos {

	public Calculos() {

		// ArrayList<String> datos = recuperarFichero();
		recuperarFichero();

	}

	/**
	 * 
	 */
	// public ArrayList<String> recuperarFichero() {
	public void recuperarFichero() {
		ArrayList<Seccion> listadoFamilias = new ArrayList<Seccion>();
		Seccion seccionObj =  new Seccion(null);;
		String linea = "";
		int referenciasDiaria = 0;
		int cantidadDiaria = 0;

		try {

			// Ponemos la ruta del archivo.
			FileReader entrada = new FileReader("/Users/pablofernandezmartinez/Desktop/287-Compact-Oleiros.txt");

			// Creamos en buffer
			BufferedReader buffer = new BufferedReader(entrada);

			// Recuperamos el número de líneas del fichero

//			long lNumeroLineas = 0;
//
//			while ((sCadena = buffer.readLine())!=null) {
//			  lNumeroLineas++;
//			}

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

					//System.out.println(seccionObj.getNombre());

					listadoFamilias.add(seccionObj);

				} else {
					if (linea.length() >= 15) {
						String substr = linea.substring(15, 23);
						String cantidad = linea.substring(68,72);
						cantidad = cantidad.replace(" ", "");
						
						
						if (substr.matches("[0-9]{8}")) {
							Integer cantidadInt = Integer.parseInt(cantidad);
							//System.out.println(substr + " - "+ cantidad);
							seccionObj.anadirReferencia(substr, cantidadInt);
							
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
