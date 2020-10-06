package calculos;

import java.util.*;

/**
 * 
 * Esta clase sirve para guardar los datos de una sección. Se basa en un nombre
 * que se refiere a la sección, subsección, tipo y subtipo y un Map de
 * referencias internas y cantidades.
 * 
 * Además tiene los métodos para acceder a sus datos y otros que hacen
 * resúmenes.
 * 
 * @author pablofernandezmartinez
 *
 */
public class Seccion {

	/**
	 * Aquí se guardará la sección, subsección, tipo y subtipo.
	 */
	private String nombre = "";
	
	/**
	 * Un mapa en el que se guardan las referencias y cantidades. Como no se pueden
	 * usar tipos primitivos recurrimos a la clase envoltorio Integer.
	 */
	private LinkedHashMap<String, Integer> listadoReferenciaCantidad = new LinkedHashMap<String, Integer>();

	/**
	 * Constructor que recibe el nombre (tipo, subtipo...) 
	 * @param nombre
	 */
	public Seccion(String nombre) {

		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Método empleado para añadir una pareja de valores al mapa
	 * listadoReferenciaCantidad
	 * 
	 * @param codigoInterno Código interno del producto. A pesar de ser un número es
	 *                      un String porque no se hacen operaciones que él.
	 * @param cantidad      Cantidades que hay de cada referencia.
	 */
	public void anadirReferencia(String codigoInterno, Integer cantidad) {
		listadoReferenciaCantidad.put(codigoInterno, cantidad);
	}

	/**
	 * Método que se utiliza cuando quieres recibir un String con los códigos y
	 * cantidades de cada uno que hay dentro del objeto.
	 * 
	 * @return devuelve una cadena de texto con la información de la referencia y la
	 *         cantidad.
	 */
	public String getReferenciasCantidades() {
		String resultado = "";

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado += "\t" + "Código: " + entrada.getKey() + " - Cantidad: " + entrada.getValue() + "\n";

		}

		return resultado;
	}

	/**
	 * Método utilizado para recibir el número de cantidades totales que hay en el
	 * map deun objeto Sección. Recorre la lista sumando las cantidades en cada
	 * vuelta.
	 * 
	 * @return devuelve la suma de todas las cantidades que hay en el listado.
	 */
	public int getTotalCantidades() {

		int resultado = 0;

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado += entrada.getValue();

		}

		return resultado;
	}

	/**
	 * Método utilizado para recibir el total de referencias que tenemos en el map
	 * de un objeto sección. Recorre la lista aumentando un contador.
	 * 
	 * @return devuelve el número de entradas que hay en el listado.
	 */
	public int getTotalReferencias() {

		int resultado = 0;

		for (Map.Entry<String, Integer> entrada : listadoReferenciaCantidad.entrySet()) {

			// System.out.println("Código: " + entrada.getKey() + " - Cantidad: " +
			// entrada.getValue());
			resultado++;

		}

		return resultado;
	}
}
