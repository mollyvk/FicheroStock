package calculos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ControlFicheros {

	
	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BufferedReader getBufferFichero() throws FileNotFoundException {
		// Ponemos la ruta del archivo. AQUI HABRÍA QUE PONER LA RUTA
		FileReader entrada = new FileReader("/Users/pablofernandezmartinez/Desktop/037-Salamanca.txt");

		// Creamos en buffer
		BufferedReader buffer = new BufferedReader(entrada);
		return buffer;
	}
}
