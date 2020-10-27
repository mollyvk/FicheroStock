package calculos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import vista.VentanaSepararStockDiario;

public class Pruebas {

	public static void main(String[] args) {

	ArrayList<String> lista = new ArrayList<String>();
	
	lista.add("a");
	lista.add("b");
	lista.add("c");
	lista.add("d");
	lista.add("e");
	
	
	String buscado = "c";
	
	System.out.println(lista.indexOf(buscado));
	
	}

}
