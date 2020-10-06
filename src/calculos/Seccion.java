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

}
