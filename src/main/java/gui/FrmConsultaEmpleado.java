package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Empleado;
import model.EmpleadoModel;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmConsultaEmpleado extends JInternalFrame {
	private JTextField txtNombre;
	private JTable miTabla;
	private JTextField txtDni;
	private JButton btnConsultar;
	
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
		setTitle("Consulta de Empleado\r\n");
		setBounds(100, 100, 850, 350);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Empleado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 178, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblIngreseNom = new JLabel("Ingrese Nombre : ");
		lblIngreseNom.setBounds(20, 42, 99, 13);
		getContentPane().add(lblIngreseNom);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(129, 39, 197, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 818, 204);
		getContentPane().add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Nombre", "Apellido", "DNI", "Teléfono", "Correo","Categoria"}
			));
		scrollPane.setViewportView(miTabla);
		
		JLabel lblIngreseDni = new JLabel("Ingrese DNI: ");
		lblIngreseDni.setBounds(20, 73, 99, 13);
		getContentPane().add(lblIngreseDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(129, 70, 110, 19);
		getContentPane().add(txtDni);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnConsultar(e);
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConsultar.setBounds(474, 45, 178, 36);
		getContentPane().add(btnConsultar);

	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		String nombre = txtNombre.getText();
		String dni = txtDni.getText();
		
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> lstCliente = model.ConsultaPorNombreDNI(nombre, dni);
		DefaultTableModel dtm = (DefaultTableModel) miTabla.getModel();
		Object[] fila = null;
		for(Empleado x : lstCliente) {
			fila = new Object[] { 
					x.getIdEmpleado(),
					x.getNombre(),
					x.getApellido(),
					x.getDni(),
					x.getTelefono(),
					x.getCorreo(),
					x.getCategoria()};
			dtm.addRow(fila);
		}
	}
}
