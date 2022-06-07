package gui;
//brando Javier Carquin Mendocilla
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ProductoModel;

public class FrmConsultaProductos extends JInternalFrame {
	private JTextField textField;
	private JTable tblProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProductos frame = new FrmConsultaProductos();
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
	public FrmConsultaProductos() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta de Productos\r\n");
		setBounds(100, 100, 858, 387);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busca tus Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 188, 20);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ProductoModel.buscar(textField.getText(),tblProductos);
			}
		});
		textField.setBounds(123, 42, 348, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese descripci\u00F3n:");
		lblNewLabel_1.setBounds(10, 45, 124, 14);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 805, 261);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Nombre","Categoria","Precio", "Stock", "Peso", "Cant. Peso"
				}
		));
		scrollPane.setViewportView(tblProductos);
	
	}
	
	

	
	
	
}
