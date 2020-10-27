package calculos.pojo;

public class Linea {

	private String seccion;
	private String subSeccion;
	private String tipo;
	private String subTipo;
	private String referencia;
	private String cantidad;
	
	public Linea (String s, String ss, String t, String st) {
		seccion = s;
		subSeccion = ss;
		tipo = t;
		subTipo = st;
		
	}
	
	public Linea(String seccion, String subSeccion, String tipo, String subTipo, String referencia, String cantidad) {
		this.seccion = seccion;
		this.subSeccion = subSeccion;
		this.tipo = tipo;
		this.subTipo = subTipo;
		this.referencia = referencia;
		this.cantidad = cantidad;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getSubSeccion() {
		return subSeccion;
	}

	public void setSubSeccion(String subSeccion) {
		this.subSeccion = subSeccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
