package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmConsultaEmpleado extends JInternalFrame {
	private JTextField txtNombre;
	private JTable miTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaEmpleado frame = new FrmConsultaEmpleado();
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
	public FrmConsultaEmpleado() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta de Vendedor\r\n");
		setBounds(100, 100, 850, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Empleado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 178, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIngreseNom = new JLabel("Ingrese Nombre : ");
		lblIngreseNom.setBounds(10, 45, 99, 13);
		getContentPane().add(lblIngreseNom);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 42, 197, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 818, 179);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Nombre", "Apellido", "DNI", "Teléfono", "Correo","Categoria"}
			));
		scrollPane.setViewportView(miTabla);

	}
}
