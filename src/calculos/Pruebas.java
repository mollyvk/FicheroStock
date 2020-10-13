package calculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import vista.VentanaInicio;

public class Pruebas {

	public static void main(String[] args) {

		String rutaDestino = "";
		String lineaCopiar = "";
		ArrayList<String> bloqueCopiar = new ArrayList<String>();

		LinkedHashMap<String, Boolean> seccionesSeleccionadas = new LinkedHashMap<String, Boolean>();
		seccionesSeleccionadas.put("11  03  06 30", false);
		seccionesSeleccionadas.put("11  03  06 25", true);
		seccionesSeleccionadas.put("11  03  06 20", true);

		try {
			// Cargar el fichero y crear buffer

			FileReader entrada = new FileReader("/Users/pablofernandezmartinez/Desktop/257-Compact-Colmenar.txt");
			BufferedReader bufferLectura = new BufferedReader(entrada);

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
			e.printStackTrace();
		}

	}

}
