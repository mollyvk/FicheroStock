package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calculos.AccionesBotonesMenuInicio;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class VentanaInicioPrograma extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioPrograma frame = new VentanaInicioPrograma();
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
	public VentanaInicioPrograma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Leroy Merlin STC - Herramientas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Versión 0.01");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 1));
		
		JButton btn_cortar_stock = new JButton("Eliminar secciones del fichero de stock diario");
		btn_cortar_stock.setToolTipText("Eliminar secciones del fichero de stock diario");
		btn_cortar_stock.addActionListener(new AccionesBotonesMenuInicio());
		panel.add(btn_cortar_stock);
		
		JButton btn_calcular_prevision_stock = new JButton("Calcular el stock previsto");
		btn_calcular_prevision_stock.setToolTipText("Calcular el stock previsto");
		btn_calcular_prevision_stock.addActionListener(new AccionesBotonesMenuInicio());
		
		JButton btn_segmentacion_dias = new JButton("Generar segmentación por tienda y días");
		btn_segmentacion_dias.addActionListener(new AccionesBotonesMenuInicio());
		panel.add(btn_segmentacion_dias);
		panel.add(btn_calcular_prevision_stock);
		
		JButton btn_calcular_replanificar = new JButton("Calcular secciones por replanificar");
		btn_calcular_replanificar.setToolTipText("Calcular secciones por replanificar");
		btn_calcular_replanificar.addActionListener(new AccionesBotonesMenuInicio());
		panel.add(btn_calcular_replanificar);
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.addActionListener(new AccionesBotonesMenuInicio());
		btn_salir.setToolTipText("Salir");
		panel.add(btn_salir);
	}

}
