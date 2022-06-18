package gui;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import model.ClienteModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmConsultaClientes extends JInternalFrame implements ActionListener, KeyListener {
	private JTextField txtNOMBRE;
	private JTextField txtDNI;
	private JTable table;
	private JButton btnCONSULTAR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaClientes frame = new FrmConsultaClientes();
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
	public FrmConsultaClientes() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta de Clientes");
		setBounds(100, 100, 776, 449);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busca al Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 209, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del cliente:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 62, 134, 22);
		getContentPane().add(lblNewLabel_1);
		
		txtNOMBRE = new JTextField();
		txtNOMBRE.addKeyListener(this);
		txtNOMBRE.setBounds(154, 65, 134, 19);
		getContentPane().add(txtNOMBRE);
		txtNOMBRE.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI del Cliente:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 105, 134, 22);
		getContentPane().add(lblNewLabel_2);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(154, 108, 134, 19);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		btnCONSULTAR = new JButton("CONSULTRAR");
		btnCONSULTAR.addActionListener(this);
		btnCONSULTAR.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/iconos/Favourites.gif")));
		btnCONSULTAR.setFont(new Font("Arial", Font.BOLD, 16));
		btnCONSULTAR.setBounds(383, 78, 200, 32);
		getContentPane().add(btnCONSULTAR);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 744, 201);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DNI", "Nombre", "Apellido", "Tel\u00E9fono", "Direcci\u00F3n", "Pa\u00EDs"
			}
		));
		scrollPane.setViewportView(table);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCONSULTAR) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String nombre = txtNOMBRE.getText();
		String dni = txtDNI.getText();
		
		ClienteModel model = new ClienteModel();
		List<Cliente> listar = model.ConsultaPorNombreDNI(nombre, dni);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Object[] fila = null;
		for(Cliente x : listar) {
			fila = new Object[] { x.getIdCliente(),x.getDni(),x.getNombre(),x.getApellido(),x.getTelefono(),x.getDireccion(),x.getPais()};
			dtm.addRow(fila);
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			do_txtDNI_keyTyped(e);
		}
		if (e.getSource() == txtNOMBRE) {
			do_txtNOMBRE_keyTyped(e);
		}
	}
	protected void do_txtNOMBRE_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String nom = txtNOMBRE.getText() + e.getKeyChar();
		if (nom.length() > 20) {
			e.consume();
		}
	}
	protected void do_txtDNI_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtDNI.getText() + e.getKeyChar();
		if (dni.length() > 8) {
			e.consume();
		}
	}
}
