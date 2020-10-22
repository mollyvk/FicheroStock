package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calculos.AccionesBotonesBase;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBase frame = new VentanaBase();
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
	public VentanaBase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 2, 2));
		
		JButton btnBorrarBase = new JButton("Borrar base");
		btnBorrarBase.addActionListener(new AccionesBotonesBase());
		panel.add(btnBorrarBase);
		
		JButton btnCargarBase = new JButton("Cargar base");
		btnCargarBase.addActionListener(new AccionesBotonesBase());
		panel.add(btnCargarBase);
		
		JButton btnConseguirStock = new JButton("Conseguir stock por día y tienda");
		panel.add(btnConseguirStock);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
	}

}


