package calculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ControlFicheros {

	String ruta = "";
	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BufferedReader getBufferFichero(String ruta) throws FileNotFoundException {
		// Ponemos la ruta del archivo. AQUI HABRÍA QUE PONER LA RUTA
		FileReader entrada = new FileReader(ruta);

		// Creamos en buffer
		BufferedReader buffer = new BufferedReader(entrada);
		return buffer;
	}
	
	public static BufferedReader getBufferFicheroFile(File ruta) throws FileNotFoundException {
		// Ponemos la ruta del archivo. AQUI HABRÍA QUE PONER LA RUTA
		FileReader entrada = new FileReader(ruta);

		// Creamos en buffer
		BufferedReader buffer = new BufferedReader(entrada);
		return buffer;
	}
}
