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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	JLabel lblRuta;
	private JTable table;
	BufferedReader buffer;

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
		btnSeleccionarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				int seleccion = fileChooser.showOpenDialog(VentanaInicio.this);
				
				if (seleccion == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(seleccion);
					
				   File fichero = fileChooser.getSelectedFile(); 
				   
				   String ruta = fichero.getAbsolutePath();
				   
				   lblRuta.setText(ruta);
				   
				   try {
					buffer = ControlFicheros.getBufferFichero(ruta);
					Calculos calculos = new Calculos(buffer);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(VentanaInicio.this, "Error al seleccionar el fichero");
					e1.printStackTrace();
				}
				   
					
				}
			}
		});
		panel_1.add(btnSeleccionarFichero);
		
		lblRuta = new JLabel("Ruta");
		contentPane.add(lblRuta, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
	}

}
