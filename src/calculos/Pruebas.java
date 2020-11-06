package calculos;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.JFileChooser;

import controlBase.UtilBase;
import vista.VentanaSepararStockDiario;

public class Pruebas {

	public static void main(String[] args) {

		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:8084/stc_lm",
					"root", "root");

			Statement statement = conexion.createStatement();

			String sql = "Select * FROM prueba";

			ResultSet resultset = statement.executeQuery(sql);

			while (resultset.next()) {

				System.out.println(resultset.getString(0) + " - " + resultset.getString(1));

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
