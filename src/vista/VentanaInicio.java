package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import calculos.Calculos;
import calculos.ControlFicheros;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	String ruta = "";
	private JTable table_1;
	JButton btnSeparar;
	DefaultTableModel model;
	LinkedHashMap<String, Boolean> seccionesSeleccionadas = new LinkedHashMap<String, Boolean>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 314);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Selecciona el fichero");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton btnSeleccionarFichero = new JButton("Selecciona fichero");
		btnSeleccionarFichero.addActionListener(new cargarFicheroTabla());

		panel_1.add(btnSeleccionarFichero);

		btnSeparar = new JButton("Crear ficheros");
		btnSeparar.addActionListener(new separarFicheros());
		panel_1.add(btnSeparar);
		btnSeparar.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

	}

	private class cargarFicheroTabla implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Ventana para recibir el string con la ruta del fichero.
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(VentanaInicio.this);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				System.out.println(seleccion);

				File fichero = fileChooser.getSelectedFile();

				ruta = fichero.getAbsolutePath();

			}

			// Pedimos el modelo de la tabla dando a Calculos la ruta
			model = Calculos.getModeloTabla(ruta);
			table_1.setModel(model);
			btnSeparar.setEnabled(true);

		}

	}

	private class separarFicheros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < table_1.getRowCount(); i++) {
				seccionesSeleccionadas.put((String) table_1.getValueAt(i, 1), (Boolean) table_1.getValueAt(i, 0));

			}

			for (Map.Entry<String, Boolean> entrada : seccionesSeleccionadas.entrySet()) {
				
				System.out.println(entrada.getKey() + " - " + entrada.getValue());
			}
		}

	}
}
