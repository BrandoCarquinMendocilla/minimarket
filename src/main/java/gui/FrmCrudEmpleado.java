package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import entidad.Empleado;
import model.EmpleadoModel;
import util.Validaciones;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmCrudEmpleado extends JInternalFrame {
	
	int idSeleccionado = -1;
	
	private JLabel lblMantenimientoVendedor;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
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
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JScrollPane scrEmpleado;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudEmpleado frame = new FrmCrudEmpleado();
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
	public FrmCrudEmpleado() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("CRUD de Empleado");
		setBounds(100, 100, 599, 480);
		getContentPane().setLayout(null);
		{
			lblMantenimientoVendedor = new JLabel("Mantenimiento Empleado");
			lblMantenimientoVendedor.setFont(new Font("Arial", Font.BOLD, 28));
			lblMantenimientoVendedor.setBounds(38, 11, 450, 50);
			getContentPane().add(lblMantenimientoVendedor);
		}
		{
			lblCodigo = new JLabel("C\u00F3digo: ");
			lblCodigo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCodigo.setBounds(27, 72, 80, 25);
			getContentPane().add(lblCodigo);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblNombre.setBounds(27, 107, 80, 25);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblApellido.setBounds(27, 142, 80, 25);
			getContentPane().add(lblApellido);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblDni.setBounds(27, 177, 80, 25);
			getContentPane().add(lblDni);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblTelefono.setBounds(320, 71, 80, 25);
			getContentPane().add(lblTelefono);
		}
		{
			lblCorreo = new JLabel("Correo: ");
			lblCorreo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCorreo.setBounds(320, 107, 80, 25);
			getContentPane().add(lblCorreo);
		}
		{
			lblCategoria = new JLabel("Categor\u00EDa:");
			lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			lblCategoria.setBounds(320, 142, 80, 25);
			getContentPane().add(lblCategoria);
		}
		{
			txtIdEmpleado = new JTextField();
			txtIdEmpleado.setBounds(102, 71, 160, 25);
			getContentPane().add(txtIdEmpleado);
			txtIdEmpleado.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(102, 107, 159, 25);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(102, 142, 160, 25);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtDni = new JTextField();
			txtDni.setBounds(102, 177, 160, 25);
			getContentPane().add(txtDni);
			txtDni.setColumns(10);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setBounds(410, 71, 160, 25);
			getContentPane().add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setBounds(410, 106, 160, 25);
			getContentPane().add(txtCorreo);
			txtCorreo.setColumns(10);
		}
		{
			cboCategoria = new JComboBox();
			cboCategoria.addItem("[Seleccionar]");
			cboCategoria.addItem("Cajero");
			cboCategoria.addItem("Vendedor");
			cboCategoria.addItem("Administrador");
			cboCategoria.addItem("Limpieza");
			cboCategoria.addItem("Reponedor");
			cboCategoria.setBounds(410, 141, 160, 25);
			getContentPane().add(cboCategoria);
		}
		{
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRegistrar(e);
				}
			});
			btnRegistrar.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			btnRegistrar.setBounds(26, 212, 160, 40);
			getContentPane().add(btnRegistrar);
		}
		{
			btnActualizar = new JButton("ACTUALIZAR");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnActualizar(e);
				}
			});
			btnActualizar.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			btnActualizar.setBounds(223, 212, 160, 40);
			getContentPane().add(btnActualizar);
		}
		{
			btnEliminar = new JButton("ELIMINAR");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnEliminar(e);
				}
			});
			btnEliminar.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			btnEliminar.setBounds(410, 212, 160, 40);
			getContentPane().add(btnEliminar);
		}
		{
			scrEmpleado = new JScrollPane();
			scrEmpleado.setBounds(10, 278, 567, 163);
			getContentPane().add(scrEmpleado);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Codigo", "Nombre", "Apellido", "DNI", "Telefono", "Correo", "Categor\u00EDa"
					}
				));
				scrEmpleado.setViewportView(table);
			}
		}
		
		JLabel lblNewLabel_3 = new JLabel("_______________________________________________________");
		lblNewLabel_3.setBounds(27, 45, 340, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Lista de Empleados:");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 262, 138, 14);
		getContentPane().add(lblNewLabel_6);

	}
	
	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboCategoria.setSelectedIndex(0);
		txtNombre.requestFocus();
	}
	
	private void listar() {
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
	
	private void buscar() {
		int fila = table .getSelectedRow();
		idSeleccionado = (Integer)table.getValueAt(fila,0);
		 String nombre = (String)table.getValueAt(fila, 2);
		 String apellido = (String)table.getValueAt(fila, 3);
		 String dni = (String)table.getValueAt(fila, 1);
		 String telefono = (String)table.getValueAt(fila, 4);
		 String correo = (String)table.getValueAt(fila, 5);
		 String categoria = (String)table.getValueAt(fila, 6);
		 
		 System.out.println(idSeleccionado + "-" + nombre + "-" + apellido + "-" + dni + "-" + telefono +
				 			"-" + correo + "-" + categoria);
		 
		 txtNombre.setText(nombre);
		 txtApellido.setText(apellido);
		 txtDni.setText(dni);
		 txtTelefono.setText(telefono);
		 txtCorreo.setText(correo);
		 cboCategoria.setSelectedItem(categoria);
		 }
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDni.getText();
		String telefono = txtTelefono.getText();
		String correo = txtCorreo.getText();
		String categoria = cboCategoria.getSelectedItem().toString();

		if (!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		} else if (!apellido.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 8 digitos");
		}else if (!telefono.matches(Validaciones.TELEFONO)) {
				mensaje("El numero de teléfono es de 9 digitos");
		} else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Correo no valido");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione el tipo Empleado");
		} else {
			Empleado empleado = new Empleado();
			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			empleado.setDni(dni);
			empleado.setTelefono(telefono);
			empleado.setCorreo(correo);
			empleado.setCategoria(categoria);

			EmpleadoModel model = new EmpleadoModel();
			int salida = model.RegistrarEmpleado(empleado);

			if (salida > 0) {
				listar();
				limpiarCajasTexto();
				mensaje("Empleado registrado correctamentes");

			} else {
				mensaje("Error al intentar ingresar datos");
			}
		}
	}

	
	private void mensaje(String string) {
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
	
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String dni = txtDni.getText();
		String telefono = txtTelefono.getText();
		String correo = txtCorreo.getText();
		String categoria = cboCategoria.getSelectedItem().toString();
		
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else if(!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		} else if (!apellido.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 8 digitos");
		}else if (!telefono.matches(Validaciones.TELEFONO)) {
				mensaje("El numero de teléfono es de 9 digitos");
		} else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Correo no valido");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione el tipo Empleado");
		} else {
			Empleado cli = new Empleado();
			cli.setIdEmpleado(idSeleccionado);
			cli.setNombre(nombre);
			cli.setApellido(apellido);
			cli.setDni(dni);
			cli.setTelefono(telefono);
			cli.setCorreo(correo);
			cli.setCategoria(categoria);

			EmpleadoModel model = new EmpleadoModel();
			int salida = model.ActualizarEmpleado(cli);

			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Empleado cctualizado correctamente");

			} else {
				mensaje("Error al intentar actualizar datos");
			}
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	
		if(idSeleccionado==-1) {
			mensaje("Seleccione un fila para eliminar");
		}else {
			EmpleadoModel model = new EmpleadoModel();
			int salida = model.EliminarEmpleado(idSeleccionado);

			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se eliminó correctamente");
			} else {
				mensaje("Error al intentar eliminar datos");
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}

	private void do_table_mouseClicked(MouseEvent e) {
		buscar();
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

	private void do_txtTelefono_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtTelefono.getText() + e.getKeyChar();
		if (dni.length() > 9) {
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

	private void do_txtApellido_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String nom = txtApellido.getText() + e.getKeyChar();
		if (nom.length() > 20) {
			e.consume();
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
}
