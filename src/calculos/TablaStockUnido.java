package calculos;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import calculos.pojo.Linea;
import calculos.pojo.Tienda;
import controlBase.UtilBase;

/**
 * Esta clase tiene los métodos para pedir un fichero de stock txt (de momento
 * va a tener el de todas la tiendas unido) y devolver un arrayList<Tiendas> con
 * la información de todo el fichero parseada.
 * 
 * Se utilizan las clases Tienda y Linea.
 * 
 * @author pablofernandezmartinez
 *
 */
public class TablaStockUnido {

	public static void main(String[] args) {

		try {

			ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>();
			listaTiendas = crearTablaStockUnido();

			for (Tienda tienda : listaTiendas) {
				System.out.println(tienda.getNumero());
				tienda.printLineas();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static ArrayList<Tienda> crearTablaStockUnido() throws IOException, SQLException {

		ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>();
		ArrayList<String> listaNumeros = new ArrayList<String>();
		Tienda tienda = null;
		Linea linea = null;
		String lineaLectura = "";
		String numeroTienda = "";

		String s = "";
		String ss = "";
		String t = "";
		String st = "";
		String referencia = "";

		// Localizar el fichero y crear el buffer

		File ruta = null;
		JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
		chooser.setFileFilter(filtro);
		int seleccion = chooser.showOpenDialog(null);

		switch (seleccion) {
		case JFileChooser.APPROVE_OPTION:
			ruta = chooser.getSelectedFile();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Debes seleccionar un fichero", "Error al seleccionar",
					JOptionPane.ERROR_MESSAGE, null);
			break;
		}

		BufferedReader buffer = ControlFicheros.getBufferFicheroFile(ruta);

		// Recorro el fichero guardando en un ArrayList

		// Creo el archivo con los números de tienda
		while ((lineaLectura = buffer.readLine()) != null) { // Recorro el fichero hasta que acabe

			if (lineaLectura.length() >= 8) {
				referencia = "";
				referencia += lineaLectura.charAt(15);
				referencia += lineaLectura.charAt(16);
				referencia += lineaLectura.charAt(17);
				referencia += lineaLectura.charAt(18);
				referencia += lineaLectura.charAt(19);
				referencia += lineaLectura.charAt(20);
				referencia += lineaLectura.charAt(21);
				referencia += lineaLectura.charAt(22);

			}

			if (lineaLectura.contains("Inventario de")) { // Si tiene la secuencia capturo el número de tienda

				numeroTienda = "";
				numeroTienda += lineaLectura.charAt(4);
				numeroTienda += lineaLectura.charAt(5);
				numeroTienda += lineaLectura.charAt(6);

				if (!listaNumeros.contains(numeroTienda)) { // si el número de tienda no está en el listado de números
															// lo añado y añado una Tienda al listado de tiendas
					listaNumeros.add(numeroTienda);
					tienda = new Tienda(numeroTienda);
					listaTiendas.add(tienda);

				}

				s = "";
				ss = "";
				t = "";
				st = "";

				s += lineaLectura.charAt(45);
				s += lineaLectura.charAt(46);

				ss += lineaLectura.charAt(49);
				ss += lineaLectura.charAt(50);

				t += lineaLectura.charAt(53);
				t += lineaLectura.charAt(54);

				st += lineaLectura.charAt(56);
				st += lineaLectura.charAt(57);

			} else if (referencia.matches("[0-9]{8}")) {

				linea = new Linea(s, ss, t, st);
				linea.setSeccion(s);
				linea.setSubSeccion(ss);
				linea.setTipo(t);
				linea.setSubTipo(st);

				linea.setReferencia(referencia);

				String cantidad = "";

				cantidad = lineaLectura.substring(68, 72);
				cantidad = cantidad.trim();
				//cantidad = Integer.parseInt(cantidadString);
				linea.setCantidad(cantidad);

				tienda.addLinea(linea);

			}

		}

		// Conecto a la base
		UtilBase utilBase = new UtilBase();
		CallableStatement statement = utilBase.getConnexion().prepareCall("{call update_stock_unido(?,?,?,?,?,?,?)}");

		// Recorro el ArrayList guardando en la base
		for (Tienda tienda_bucle : listaTiendas) {
			statement.setString(1, tienda_bucle.getNumero());
			ArrayList<Linea> listaLineas = tienda_bucle.getLineas();
			for (Linea linea_bucle : listaLineas) {
				
				statement.setString(2, linea_bucle.getSeccion());
				statement.setString(3, linea_bucle.getSubSeccion());
				statement.setString(4, linea_bucle.getTipo());
				statement.setString(5, linea_bucle.getSubTipo());
				statement.setString(6, linea_bucle.getReferencia());
				statement.setString(7, linea_bucle.getCantidad());
				statement.execute();
			}

		}

		// Cierro todo

		return listaTiendas;

	}

}
