package calculos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import controlBase.UtilBase;

public class SepararSegmentación {

	public static void main(String[] args) {

		separarSegmentacion(null, null, null, 0, new UtilBase());
	}

	public static void separarSegmentacion(String ruta, Date fecha_inicio, Date fecha_fin, int tiendas, UtilBase utilBase) {

		try {

			
			Statement st = UtilBase.getConnexion().createStatement();

			String sql = "SELECT * FROM tiendasConNumero";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Error al acceder a la base.");
			e.printStackTrace();
		}

	}

}
