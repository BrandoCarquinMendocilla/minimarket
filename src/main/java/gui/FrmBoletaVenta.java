package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmBoletaVenta extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoletaVenta frame = new FrmBoletaVenta();
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
	public FrmBoletaVenta() {
		setTitle("Boleta de Venta\r\n");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 702, 462);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Genera una Boleta!");
		lblNewLabel.setBounds(24, 11, 200, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 51, 118, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI :");
		lblNewLabel_2.setBounds(24, 83, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(78, 80, 164, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo Empleado :");
		lblNewLabel_3.setBounds(490, 21, 89, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(589, 18, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Producto: ");
		lblNewLabel_4.setBounds(24, 115, 55, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 112, 164, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad");
		lblNewLabel_5.setBounds(265, 115, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(321, 112, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar Cliente");
		btnNewButton.setBounds(289, 79, 118, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar Producto");
		btnNewButton_1.setBounds(24, 140, 111, 23);
		getContentPane().add(btnNewButton_1);

	}
}
