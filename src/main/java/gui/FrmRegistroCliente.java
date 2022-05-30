package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidad.Cliente;
import model.ClienteModel;
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

public class FrmRegistroCliente extends JInternalFrame implements KeyListener {
	private JTextField txtNom;
	private JTextField txtTelf;
	private JTextField txtDirec;
	private JTextField txtDni;
	private JTextField txtApe;
	private JComboBox cboPais;
	private JComboBox cboComprob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroCliente frame = new FrmRegistroCliente();
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
	public FrmRegistroCliente() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Clientes");
		setBounds(100, 100, 631, 647);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(190, 46, 263, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(63, 131, 78, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(63, 177, 78, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(63, 227, 78, 17);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(63, 272, 78, 17);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(63, 318, 78, 17);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pa\u00EDs :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(63, 371, 78, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Comprobante :");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(63, 417, 107, 17);
		getContentPane().add(lblNewLabel_7);
		
		txtNom = new JTextField();
		txtNom.addKeyListener(this);
		txtNom.setBounds(190, 131, 320, 19);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		cboComprob = new JComboBox();
		cboComprob.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar ", "Boleta", "Factura"}));
		cboComprob.addItem("Seleccionar");
		cboComprob.addItem("Boleta");
		cboComprob.addItem("Factura");
		cboComprob.setBounds(190, 416, 320, 21);
		getContentPane().add(cboComprob);
		
		txtTelf = new JTextField();
		txtTelf.addKeyListener(this);
		txtTelf.setColumns(10);
		txtTelf.setBounds(190, 272, 320, 19);
		getContentPane().add(txtTelf);
		
		txtDirec = new JTextField();
		txtDirec.addKeyListener(this);
		txtDirec.setColumns(10);
		txtDirec.setBounds(190, 318, 320, 19);
		getContentPane().add(txtDirec);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setColumns(10);
		txtDni.setBounds(190, 227, 320, 19);
		getContentPane().add(txtDni);
		
		txtApe = new JTextField();
		txtApe.addKeyListener(this);
		txtApe.setColumns(10);
		txtApe.setBounds(190, 177, 320, 19);
		getContentPane().add(txtApe);
		
		cboPais = new JComboBox();
		cboPais.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar ", "Peru", "Colombia", "Argentina", "Bolivia", "Chile", "Uruguay", "Venezuela", "Brasil", "Paraguay", "Espa\u00F1a"}));
		cboPais.addItem("Seleccionar");
		cboPais.addItem("Peru");
		cboPais.addItem("Colombia");
		cboPais.addItem("Argentina");
		cboPais.addItem("Bolivia");
		cboPais.addItem("Chile");
		cboPais.addItem("Uruguay");
		cboPais.addItem("Venezuela");
		cboPais.addItem("Brasil");
		cboPais.addItem("Paraguay");
		cboPais.addItem("España");
		cboPais.setBounds(190, 368, 320, 21);
		getContentPane().add(cboPais);
		
		JButton btnREGISTRAR = new JButton("REGISTRAR");
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnREGISTRAR.setIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/iconos/Add.gif")));
		btnREGISTRAR.setFont(new Font("Arial", Font.BOLD, 21));
		btnREGISTRAR.setBounds(213, 499, 194, 55);
		getContentPane().add(btnREGISTRAR);

	}
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	private void Registrar() {
		String dni =txtDni.getText();
		String nom =txtNom.getText();
		String ape =txtApe.getText();
		String telf =txtTelf.getText();
		String direc =txtDirec.getText();
		String pais =cboPais.getSelectedItem().toString();
		String comp =cboComprob.getSelectedItem().toString();
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		} else if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 8 digitos");
		}else if (!telf.matches(Validaciones.TELEFONO)) {
				mensaje("El numero de teléfono es de 9 digitos");
		} else if (!direc.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección es de 2 a 20 caracteres");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione el país");
		} else if (cboComprob.getSelectedIndex() == 0) {
			mensaje("Seleccione el tipo de Comprobante de Pago");
		} else {
		
		Cliente cli = new Cliente();
		cli.setDni(dni);
		cli.setNombre(nom);
		cli.setApellido(ape);
		cli.setTelefono(telf);
		cli.setDireccion(direc);
		cli.setPais(pais);
		cli.setComprobante(comp);
		
		ClienteModel model = new ClienteModel();
		int salida = model.registrarCliente(cli);
		
		if (salida > 0) {
			
			mensaje("Cliente Registrado con exito");

		} else {
			mensaje("Corriga los datos  ingresados");
		}
		
		//Vilchez
		}
		}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDirec) {
			do_txtDirec_keyTyped(e);
		}
		if (e.getSource() == txtTelf) {
			do_txtTelf_keyTyped(e);
		}
		if (e.getSource() == txtDni) {
			do_txtDni_keyTyped(e);
		}
		if (e.getSource() == txtApe) {
			do_txtApe_keyTyped(e);
		}
		if (e.getSource() == txtNom) {
			do_txtNom_keyTyped(e);
		}
	}
	protected void do_txtNom_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String nom = txtNom.getText() + e.getKeyChar();
		if (nom.length() > 20) {
			e.consume();
		}
	}
	protected void do_txtApe_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String ape = txtApe.getText() + e.getKeyChar();
		if (ape.length() > 20) {
			e.consume();
		}
	}
	protected void do_txtDni_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtDni.getText() + e.getKeyChar();
		if (dni.length() > 8) {
			e.consume();
		}
	}
	protected void do_txtTelf_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtTelf.getText() + e.getKeyChar();
		if (dni.length() > 9) {
			e.consume();
		}
	}
	protected void do_txtDirec_keyTyped(KeyEvent e) {
		String dir = txtDirec.getText() + e.getKeyChar();
		if (dir.length() > 20) {
			e.consume();
		}
	}
 }
	
