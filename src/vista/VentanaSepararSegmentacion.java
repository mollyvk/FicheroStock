package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaSepararSegmentacion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		panel_botones.add(btn_aceptar);
		
		JPanel panel_opciones = new JPanel();
		contentPane.add(panel_opciones, BorderLayout.CENTER);
		GridBagLayout gbl_panel_opciones = new GridBagLayout();
		gbl_panel_opciones.columnWidths = new int[]{142, 311, 0};
		gbl_panel_opciones.rowHeights = new int[]{53, 53, 53, 51, 0};
		gbl_panel_opciones.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_opciones.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		textField = new JTextField();
		panel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("seleccionar");
		panel.add(btnNewButton, BorderLayout.EAST);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de inicio");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_opciones.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JCalendar calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.insets = new Insets(0, 0, 5, 0);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 1;
		panel_opciones.add(calendar, gbc_calendar);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de fin");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_opciones.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JCalendar calendar_1 = new JCalendar();
		GridBagConstraints gbc_calendar_1 = new GridBagConstraints();
		gbc_calendar_1.insets = new Insets(0, 0, 5, 0);
		gbc_calendar_1.fill = GridBagConstraints.BOTH;
		gbc_calendar_1.gridx = 1;
		gbc_calendar_1.gridy = 2;
		panel_opciones.add(calendar_1, gbc_calendar_1);
		
		JLabel lblNewLabel_4 = new JLabel("Tienda");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_opciones.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		comboBox.setModel(new DefaultComboBoxModel(UtilBase.getNumerosTiendas()));
		
		
		
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
