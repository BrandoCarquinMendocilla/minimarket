package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import entidad.Cliente;
import entidad.Empleado;
import model.ClienteModel;
import model.EmpleadoModel;
import util.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmRegistroEmpleado extends JInternalFrame implements KeyListener {
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDNI;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblCategoria;
	private JTextField txtIdEmpleado;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JComboBox cboCategoria;
	private JButton btnRegistrar;
	private JTable table;

	int hoveredRow = -1, hoveredColumn = -1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroEmpleado frame = new FrmRegistroEmpleado();
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
	public FrmRegistroEmpleado() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Empleado");
		setBounds(100, 100, 600, 459);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO EMPLEADO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		lblNewLabel.setBounds(44, 23, 298, 34);
		getContentPane().add(lblNewLabel);
		{
			lblCodigo = new JLabel("C\u00F3digo: ");
			lblCodigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCodigo.setBounds(33, 84, 90, 20);
			getContentPane().add(lblCodigo);
		}
		{
			lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblNombre.setBounds(33, 114, 90, 20);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblApellido.setBounds(262, 84, 90, 20);
			getContentPane().add(lblApellido);
		}
		{
			lblDNI = new JLabel("DNI:");
			lblDNI.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblDNI.setBounds(33, 144, 90, 20);
			getContentPane().add(lblDNI);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblTelefono.setBounds(262, 114, 90, 20);
			getContentPane().add(lblTelefono);
		}
		{
			lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCorreo.setBounds(33, 174, 90, 20);
			getContentPane().add(lblCorreo);
		}
		{
			lblCategoria = new JLabel("Categor\u00EDa:");
			lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCategoria.setBounds(262, 144, 90, 20);
			getContentPane().add(lblCategoria);
		}
		{
			txtIdEmpleado = new JTextField();
			txtIdEmpleado.setBounds(113, 84, 120, 19);
			getContentPane().add(txtIdEmpleado);
			txtIdEmpleado.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(113, 114, 120, 19);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(346, 84, 120, 19);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtDni = new JTextField();
			txtDni.setBounds(113, 144, 120, 19);
			getContentPane().add(txtDni);
			txtDni.setColumns(10);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setBounds(346, 114, 120, 19);
			getContentPane().add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setBounds(113, 174, 120, 19);
			getContentPane().add(txtCorreo);
			txtCorreo.setColumns(10);
		}
		{
			cboCategoria = new JComboBox<String>();
			cboCategoria.addItem("[Seleccionar]");
			cboCategoria.addItem("Cajero");
			cboCategoria.addItem("Vendedor");
			cboCategoria.addItem("Administrador");
			cboCategoria.addItem("Limpieza");
			cboCategoria.addItem("Reponedor");
			cboCategoria.setBounds(347, 143, 119, 21);
			getContentPane().add(cboCategoria);
		}
		{
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrar(e);
				}
			});
			btnRegistrar.setFont(new Font("Arial", Font.BOLD, 21));
			btnRegistrar.setBounds(357, 174, 200, 50);
			getContentPane().add(btnRegistrar);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 568, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Nombre", "Apellido", "DNI", "Teléfono", "Correo","Categoria"}
		));
		
		//Tamaño de las tablas
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(180);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				
		//selecciona una sola fila
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						
		//desabilita mover las columnas
		table.getTableHeader().setReorderingAllowed(false);
						
		//color de la fila seleccionada
		table.setSelectionBackground(Color.GREEN);
		
		//No se pueda editar
		table.setDefaultEditor(Object.class, null);
					    
		//Efecto Rollover
		table.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
					Point p = e.getPoint();
					hoveredRow = table.rowAtPoint(p);
					hoveredColumn = table.columnAtPoint(p);
					table.setRowSelectionInterval(hoveredRow, hoveredRow);
					table.repaint();    
				}
				@Override
				public void mouseDragged(MouseEvent e) {
					hoveredRow = hoveredColumn = -1;
					table.repaint();
				}
		});
		
		lista();
		scrollPane.setViewportView(table);
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboCategoria.requestFocus();
	}
	private void lista() {
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> lista = model.ListarEmpleado();

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		Object[] fila = null;
		for (Empleado x : lista) {
			fila = new Object[] { x.getIdEmpleado(), 
					x.getNombre(), 
					x.getApellido(),
					x.getDni(),
					x.getTelefono(),
					x.getCorreo(),
					x.getCategoria()};
			dtm.addRow(fila);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
	
		String nombre =txtNombre.getText();
		String apellido =txtApellido.getText();
		String dni =txtDni.getText();
		String telefono =txtTelefono.getText();
		String correo =txtCorreo.getText();
		String categoria =cboCategoria.getSelectedItem().toString();
	
		if (!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre debe ser de 2 a 20 caracteres");
		} else if (!apellido.matches(Validaciones.TEXTO)) {
			mensaje("El nombre debe ser de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI debe ser de 8 dígitos");
		} else if (!telefono.matches(Validaciones.TELEFONO)) {
			mensaje("El producto debe ser de 2 a 20 caracteres");
		}else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Correo no valido");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione una Categoría");
		} else {
			Empleado obj = new Empleado();
			obj.setNombre(nombre);
			obj.setApellido(apellido);
			obj.setDni(dni);
			obj.setTelefono(telefono);
			obj.setCorreo(correo);
			obj.setCategoria(categoria);
			
			EmpleadoModel model = new EmpleadoModel();
			int salida = model.RegistrarEmpleado(obj);

			if (salida > 0) {
				lista();
				limpiarCajasTexto();
				mensaje("Se insertó el empleado exitosamente");
			} else {
				mensaje("Error en el Registro");
			}
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			do_txtNombre_keyTyped(e);
		}
		if (e.getSource() == txtApellido) {
			do_txtApellido_keyTyped(e);
		}
		if (e.getSource() == txtDni) {
			do_txtDni_keyTyped(e);
		}
		if (e.getSource() == txtTelefono) {
			do_txtTelefono_keyTyped(e);
		}
	}

	private void do_txtNombre_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String nom = txtNombre.getText() + e.getKeyChar();
		if (nom.length() > 20) {
			e.consume();
		}
	}
	private void do_txtApellido_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String ape = txtApellido.getText() + e.getKeyChar();
		if (ape.length() > 20) {
			e.consume();
		}
	}
	private void do_txtDni_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtDni.getText() + e.getKeyChar();
		if (dni.length() > 8) {
			e.consume();
		}
	}
	private void do_txtTelefono_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtTelefono.getText() + e.getKeyChar();
		if (dni.length() > 9) {
			e.consume();
		}
	}
 }
