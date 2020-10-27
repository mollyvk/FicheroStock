package calculos.pojo;

import java.util.ArrayList;

public class Tienda {

	private String numero;
	private ArrayList<Linea> lineas = new ArrayList<Linea>();

	public Tienda(String numero) {

		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<Linea> lineas) {
		this.lineas = lineas;
	}

	public void printLineas() {
		for (Linea linea : lineas) {
			System.out.println("\t" + linea.getSeccion() + " - " + linea.getSubSeccion() + " - " + linea.getTipo()
					+ " - " + linea.getSubTipo() + " --> " + linea.getReferencia() + ": " + linea.getCantidad());
		}
	}

//	public void addLinea(String s, String ss, String t, String st, String referencia, int cantidad) {
//		lineas.add(new Linea(s,ss,t,st,referencia,cantidad));
//	}
	public void addLinea(Linea linea) {
		lineas.add(linea);
	}

}
