package calculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.metal.MetalBorders.MenuItemBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * Esta clase sirve para hacer los cálculos necesarios para la interfaz gráfica.
 * Debe recibir una ruta al fichero que se quiere tratar.
 * 
 * @author pablofernandezmartinez
 *
 * @version 0.00
 *
 */
public class Calculos {

	public Calculos(BufferedReader buffer) {

		// ArrayList<String> datos = recuperarFichero();
		obtenerDatosFichero(buffer);

	}

	// public ArrayList<String> recuperarFichero() {
	public void obtenerDatosFichero(BufferedReader bufferRecibido) {
		ArrayList<Seccion> listadoFamilias = new ArrayList<Seccion>();
		Seccion seccionObj = new Seccion(null);
		String linea = "";
		int referenciasDiaria = 0;
		int cantidadDiaria = 0;

		try {

			BufferedReader buffer = bufferRecibido;

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

	public static DefaultTableModel getModeloTabla(String ruta) {

		String linea = "";
		ArrayList<String> listaSecciones = new ArrayList<String>();
		Object[] arraySecciones = null;
		// DefaultTableModel model = null;
		MiModelo model = null;
		Seccion seccionObj = null;
		ArrayList<Seccion> arrayListObj = new ArrayList<Seccion>();
		int cantidadDiaria = 0;
		int referenciasDiaria = 0;

		try {
			// Creamos el modelo de la tabla
			// model = new DefaultTableModel();
			model = new MiModelo();

			// Pedimos el buffer
			BufferedReader buffer = ControlFicheros.getBufferFichero(ruta);

			// Recorremos el fichero y guardamos las familias en un arrayList
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
					familia += "  ";
					familia += linea.charAt(49);
					familia += linea.charAt(50);
					familia += "  ";
					familia += linea.charAt(53);
					familia += linea.charAt(54);
					familia += " ";
					familia += linea.charAt(56);
					familia += linea.charAt(57);

					listaSecciones.add(familia);

					seccionObj = new Seccion(familia);
					// System.out.println(seccionObj.getNombre());
					arrayListObj.add(seccionObj);

				} else {
					if (linea.length() >= 15) {
						String codigoInterno = linea.substring(15, 23);
						String cantidad = linea.substring(68, 72);
						cantidad = cantidad.replace(" ", ""); // Podemos hacerlo con trim

						if (codigoInterno.matches("[0-9]{8}")) {
							Integer cantidadInt = Integer.parseInt(cantidad);

							// System.out.println(codigoInterno + " - "+ cantidad);
							seccionObj.anadirReferencia(codigoInterno, cantidadInt);

							// System.out.println(seccionObj.getReferenciasCantidades());
						}
					}
				}

			}

			arraySecciones = new String[listaSecciones.size()];

			arraySecciones = listaSecciones.toArray(arraySecciones);

			// SUMAR LAS REFERENCIAS Y CANTIDADES

			Object[] arraySumaReferencias = new Object[arrayListObj.size()];
			Object[] arraySumaCantidades = new Object[arrayListObj.size()];
			ArrayList<Object> arrayDePaso = new ArrayList<Object>();
			ArrayList<Object> arrayDePaso2 = new ArrayList<Object>();
			Boolean[] arraySeleccionado = new Boolean[arrayListObj.size()];
			int contador = 0;

			for (Seccion seccion : arrayListObj) {
				arraySeleccionado[contador] = true;
				arrayDePaso.add(seccion.getTotalReferencias());
				arrayDePaso2.add(seccion.getTotalCantidades());
				referenciasDiaria += seccion.getTotalReferencias();
				cantidadDiaria += seccion.getTotalCantidades();
				contador++;
			}
			arraySumaReferencias = arrayDePaso.toArray(arraySumaReferencias);
			arraySumaCantidades = arrayDePaso2.toArray(arraySumaCantidades);

			model.addColumn("Seleccionado", arraySeleccionado);
			model.addColumn("Secciones", arraySecciones);
			model.addColumn("Referencias", arraySumaReferencias);
			model.addColumn("Cantidades", arraySumaCantidades);

			JOptionPane.showMessageDialog(null, "Se han encontrado. \n\tFamilias: " + arrayListObj.size()
					+ "\n\tReferencias: " + referenciasDiaria + "\n\tCantidades: " + cantidadDiaria);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	/**
	 * Método para separar los ficheros
	 * 
	 * @param ruta                   dirección donde vamos a recoger el fichero.
	 * @param seccionesSeleccionadas LinkedHashMap con la relación de familias y si
	 *                               han sido seleccionadas.
	 */
	public static void separaFicheros(String ruta, LinkedHashMap<String, Boolean> seccionesSeleccionadas) {
		
		
		String rutaDestino = "";
		String lineaCopiar = "";
		ArrayList<String> bloqueCopiar = new ArrayList<String>();

		

		try {
			// Cargar el fichero y crear buffer

			//FileReader entrada = new FileReader("/Users/pablofernandezmartinez/Desktop/257-Compact-Colmenar.txt");
			BufferedReader bufferLectura = ControlFicheros.getBufferFichero(ruta);

			// Pedir ruta del fichero resultado

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));
			fileChooser.setDialogTitle("Elige la carpeta de destino");
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {

				File fichero = fileChooser.getSelectedFile();

				rutaDestino = fichero.getAbsolutePath();

				rutaDestino += "/SeccionesElegidas.txt";

				System.out.println(rutaDestino);

			}

			// rutaDestino = "/Users/pablofernandezmartinez/Desktop/SeccionesElegidas.txt";

			// Crear fichero modificado

			FileWriter archivoEscritura = new FileWriter(rutaDestino);

			BufferedWriter bufferEscritura = new BufferedWriter(archivoEscritura);

			// bloqueCopiar.add(bufferLectura.readLine());

			while ((lineaCopiar = bufferLectura.readLine()) != null) {

				if (lineaCopiar.contains("creflash")) {

					// bloqueCopiar.add(lineaCopiar);
					// System.out.println(lineaCopiar);

					if (bloqueCopiar.size() >= 2) {

						// Recorrer el map y pasar por parámetros la seccion al

						for (Map.Entry<String, Boolean> entradaMap : seccionesSeleccionadas.entrySet()) {

							if (entradaMap.getValue() == true) {
								if (bloqueCopiar.get(2).contains(entradaMap.getKey())
										|| bloqueCopiar.get(1).contains(entradaMap.getKey())) {

									for (String string : bloqueCopiar) {

										System.out.println(string);

										bufferEscritura.write(string);
										bufferEscritura.newLine();
									}

								}
							}
						}
						bloqueCopiar.clear();
						bloqueCopiar.add(lineaCopiar);
					}
				} else {

					bloqueCopiar.add(lineaCopiar);
					// System.out.println(lineaCopiar);
				}

			}

			if (lineaCopiar == null) {

				if (bloqueCopiar.size() >= 2) {

					// Recorrer el map y pasar por parámetros la seccion al

					for (Map.Entry<String, Boolean> entradaMap : seccionesSeleccionadas.entrySet()) {

						if (entradaMap.getValue() == true) {
							if (bloqueCopiar.get(2).contains(entradaMap.getKey())
									|| bloqueCopiar.get(1).contains(entradaMap.getKey())) {

								for (String string : bloqueCopiar) {

									System.out.println(string);

									bufferEscritura.write(string);
									bufferEscritura.newLine();
								}

							}
						}
					}
					bloqueCopiar.clear();
				}

			}

			bufferEscritura.flush();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha habido un error al separar el fichero", "¡Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}

/**
 * Clase para el modelo de la tabla principal.
 * 
 * @author pablofernandezmartinez
 *
 */
class MiModelo extends DefaultTableModel {

	/**
	 * Método que cambia el tipo de datos de las tablas.
	 */
	public Class getColumnClass(int columna) {
		if (columna == 0)
			return Boolean.class;
		return Object.class;
	}
}
