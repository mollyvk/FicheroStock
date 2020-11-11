package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDayChooser;

import controlBase.UtilBase;

import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class VentanaSepararSegmentacion extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ruta;
	private JTextField txt_fecha_inicio;
	JTextField txt_fecha_fin = new JTextField();
	JCalendar calendario_inicio;
	JCalendar calendario_fin;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSepararSegmentacion frame = new VentanaSepararSegmentacion();
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
	public VentanaSepararSegmentacion() {
		
		UtilBase utilBase = new UtilBase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_botones = new JPanel();
		contentPane.add(panel_botones, BorderLayout.SOUTH);
		panel_botones.setLayout(new GridLayout(1, 2));

		JButton btn_cancelar = new JButton("Cancelar");
		panel_botones.add(btn_cancelar);

		JButton btn_aceptar = new JButton("Conseguir ficheros");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ruta = txt_ruta.getText();
				
				Date fecha_inicio = calendario_inicio.getDate();

				Date fecha_fin = calendario_fin.getDate();
				
				int tiendas = comboBox.getSelectedIndex();

				calculos.SepararSegmentación.separarSegmentacion(ruta, fecha_inicio,
				fecha_fin, tiendas, utilBase);
			}
		});
		panel_botones.add(btn_aceptar);

		JPanel panel_opciones = new JPanel();
		contentPane.add(panel_opciones, BorderLayout.CENTER);
		GridBagLayout gbl_panel_opciones = new GridBagLayout();
		gbl_panel_opciones.columnWidths = new int[] { 142, 311, 0 };
		gbl_panel_opciones.rowHeights = new int[] { 53, 53, 53, 51, 0 };
		gbl_panel_opciones.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_opciones.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_opciones.setLayout(gbl_panel_opciones);

		JLabel lblNewLabel_1 = new JLabel("Carpeta de destino");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_opciones.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_opciones.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		txt_ruta = new JTextField();
		panel.add(txt_ruta, BorderLayout.CENTER);
		txt_ruta.setColumns(10);

		JButton btnNewButton = new JButton("seleccionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int opcion = chooser.showOpenDialog(VentanaSepararSegmentacion.this);

				if (opcion == JFileChooser.APPROVE_OPTION) {

					File fichero = chooser.getSelectedFile();

					txt_ruta.setText(fichero.getAbsolutePath());

				}

			}
		});
		panel.add(btnNewButton, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel_opciones.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 142, 0 };
		gbl_panel_1.rowHeights = new int[] { 57, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha de inicio");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txt_fecha_inicio = new JTextField();
		GridBagConstraints gbc_txt_fecha_inicio = new GridBagConstraints();
		gbc_txt_fecha_inicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_fecha_inicio.gridx = 0;
		gbc_txt_fecha_inicio.gridy = 1;
		panel_1.add(txt_fecha_inicio, gbc_txt_fecha_inicio);
		txt_fecha_inicio.setColumns(10);

		calendario_inicio = new JCalendar();
		calendario_inicio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Date fecha_inicio = calendario_inicio.getDate();

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				String strDate = dateFormat.format(fecha_inicio);

				txt_fecha_inicio.setText(strDate);

			}
		});
		GridBagConstraints gbc_calendario_inicio = new GridBagConstraints();
		gbc_calendario_inicio.insets = new Insets(0, 0, 5, 0);
		gbc_calendario_inicio.fill = GridBagConstraints.BOTH;
		gbc_calendario_inicio.gridx = 1;
		gbc_calendario_inicio.gridy = 1;
		panel_opciones.add(calendario_inicio, gbc_calendario_inicio);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel_opciones.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 142, 0 };
		gbl_panel_2.rowHeights = new int[] { 53, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha de fin");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		GridBagConstraints gbc_txt_fecha_fin = new GridBagConstraints();
		gbc_txt_fecha_fin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_fecha_fin.gridx = 0;
		gbc_txt_fecha_fin.gridy = 1;
		panel_2.add(txt_fecha_fin, gbc_txt_fecha_fin);
		txt_fecha_fin.setColumns(10);

		calendario_fin = new JCalendar();
		calendario_fin.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {

				Date fecha_fin = calendario_fin.getDate();

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				String strDate = dateFormat.format(fecha_fin);

				txt_fecha_fin.setText(strDate);
			}
		});
		GridBagConstraints gbc_calendario_fin = new GridBagConstraints();
		gbc_calendario_fin.insets = new Insets(0, 0, 5, 0);
		gbc_calendario_fin.fill = GridBagConstraints.BOTH;
		gbc_calendario_fin.gridx = 1;
		gbc_calendario_fin.gridy = 2;
		panel_opciones.add(calendario_fin, gbc_calendario_fin);

		JLabel lblNewLabel_4 = new JLabel("Tienda");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_opciones.add(lblNewLabel_4, gbc_lblNewLabel_4);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		
		
		comboBox.setModel(new DefaultComboBoxModel(utilBase.getNumerosTiendas()));

		//UtilBase.cerrarPuertos();
		panel_opciones.add(comboBox, gbc_comboBox);

		JPanel panel_titulo = new JPanel();
		contentPane.add(panel_titulo, BorderLayout.NORTH);
		panel_titulo.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Crear archivos de segmentación por tienda y fechas", JLabel.CENTER);
		panel_titulo.add(lblNewLabel, BorderLayout.CENTER);

		JSeparator separator = new JSeparator();
		panel_titulo.add(separator, BorderLayout.SOUTH);
	}

}
