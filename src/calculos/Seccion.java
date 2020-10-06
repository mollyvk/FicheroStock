package calculos;

import java.util.*;

public class Seccion {

	private String nombre = "";
	private LinkedHashMap<String, Integer> listadoReferenciaCantidad = new LinkedHashMap<String, Integer>();

	public Seccion(String nombre) {

		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public void anadirReferencia(String ean, Integer cantidad) {
		listadoReferenciaCantidad.put(ean, cantidad);
	}

	public String getReferenciasCantidades() {
		String resultado = "";

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado += "\t" + "Código: " + entrada.getKey() + " - Cantidad: " + entrada.getValue() + "\n";

		}

		return resultado;
	}

	public int getTotalCantidades() {

		int resultado = 0;

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado += entrada.getValue();

		}

		return resultado;
	}

	public int getTotalReferencias() {

		int resultado = 0;

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado ++;

		}

		return resultado;
	}
}
