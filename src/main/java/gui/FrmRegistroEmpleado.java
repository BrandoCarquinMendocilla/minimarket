package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidad.Cliente;
import entidad.Empleado;
import model.ClienteModel;
import model.EmpleadoModel;
import util.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

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
		setBounds(100, 100, 510, 390);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO EMPLEADO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(97, 38, 298, 34);
		getContentPane().add(lblNewLabel);
		{
			lblCodigo = new JLabel("C\u00F3digo: ");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCodigo.setBounds(23, 101, 90, 13);
			getContentPane().add(lblCodigo);
		}
		{
			lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBounds(23, 143, 90, 13);
			getContentPane().add(lblNombre);
		}
		{
			lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblApellido.setBounds(262, 143, 90, 13);
			getContentPane().add(lblApellido);
		}
		{
			lblDNI = new JLabel("DNI:");
			lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDNI.setBounds(23, 184, 90, 13);
			getContentPane().add(lblDNI);
		}
		{
			lblTelefono = new JLabel("Tel\u00E9fono:");
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTelefono.setBounds(262, 184, 90, 13);
			getContentPane().add(lblTelefono);
		}
		{
			lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCorreo.setBounds(23, 225, 90, 13);
			getContentPane().add(lblCorreo);
		}
		{
			lblCategoria = new JLabel("Categor\u00EDa:");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCategoria.setBounds(262, 225, 90, 13);
			getContentPane().add(lblCategoria);
		}
		{
			txtIdEmpleado = new JTextField();
			txtIdEmpleado.setBounds(113, 99, 120, 19);
			getContentPane().add(txtIdEmpleado);
			txtIdEmpleado.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(113, 141, 120, 19);
			getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(346, 141, 120, 19);
			getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtDni = new JTextField();
			txtDni.setBounds(113, 182, 120, 19);
			getContentPane().add(txtDni);
			txtDni.setColumns(10);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setBounds(346, 182, 120, 19);
			getContentPane().add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setBounds(113, 223, 120, 19);
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
			cboCategoria.setBounds(347, 222, 119, 21);
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
			btnRegistrar.setBounds(159, 275, 200, 50);
			getContentPane().add(btnRegistrar);
		}
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
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
