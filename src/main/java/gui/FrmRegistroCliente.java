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
import model.ClienteModel;
import util.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmRegistroCliente extends JInternalFrame implements KeyListener {
	private JTextField txtNom;
	private JTextField txtTelf;
	private JTextField txtDirec;
	private JTextField txtDni;
	private JTextField txtApe;
	private JComboBox cboPais;
	private JComboBox cboComprob;
	private JScrollPane scrollPane;
	private JTable table;
	int hoveredRow = -1, hoveredColumn = -1;
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
		setBounds(100, 100, 633, 435);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 25, 263, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 81, 78, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 108, 78, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 135, 78, 17);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(216, 81, 78, 17);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(216, 108, 78, 17);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pa\u00EDs :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(216, 137, 78, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Comprobante :");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(418, 81, 107, 17);
		getContentPane().add(lblNewLabel_7);
		
		txtNom = new JTextField();
		txtNom.addKeyListener(this);
		txtNom.setBounds(91, 81, 115, 19);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		cboComprob = new JComboBox();
		cboComprob.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar ", "Boleta", "Factura"}));
		cboComprob.setBounds(521, 80, 91, 21);
		getContentPane().add(cboComprob);
		
		txtTelf = new JTextField();
		txtTelf.addKeyListener(this);
		txtTelf.setColumns(10);
		txtTelf.setBounds(293, 81, 115, 19);
		getContentPane().add(txtTelf);
		
		txtDirec = new JTextField();
		txtDirec.addKeyListener(this);
		txtDirec.setColumns(10);
		txtDirec.setBounds(293, 108, 115, 19);
		getContentPane().add(txtDirec);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setColumns(10);
		txtDni.setBounds(91, 135, 115, 19);
		getContentPane().add(txtDni);
		
		txtApe = new JTextField();
		txtApe.addKeyListener(this);
		txtApe.setColumns(10);
		txtApe.setBounds(91, 108, 115, 19);
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
		cboPais.setBounds(293, 134, 115, 21);
		getContentPane().add(cboPais);
		
		JButton btnREGISTRAR = new JButton("REGISTRAR");
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnREGISTRAR.setIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/iconos/Add.gif")));
		btnREGISTRAR.setFont(new Font("Arial", Font.BOLD, 21));
		btnREGISTRAR.setBounds(418, 165, 183, 39);
		getContentPane().add(btnREGISTRAR);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 602, 173);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DNI", "Nombre", "Apellido", "Tel\u00E9fono", "Direcci\u00F3n", "Pa\u00EDs", "Comprobante"
			}
		));
		//tamano de la fila	
		table.getColumnModel().getColumn(0).setPreferredWidth(17);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		//alineación
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
		//selecciona una sola fila
				table.setRowSelectionAllowed(true);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		        //desabilita mover las columnas
				table.getTableHeader().setReorderingAllowed(false);
				
				//color de la fila seleccionada
				table.setSelectionBackground(Color.BLUE);
				
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
	}
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	void limpiarCajasTexto() {
		txtNom.setText("");
		txtApe.setText("");
		txtDni.setText("");
		txtTelf.setText("");
		txtDirec.setText("");
		cboComprob.requestFocus();
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
			lista();
			limpiarCajasTexto();
			mensaje("Cliente Registrado con exito");

		} else {
			mensaje("Corriga los datos  ingresados");
		}
		
		//Vilchez
		}
		}
	private void lista() {
		ClienteModel model = new ClienteModel();
		List<Cliente> lista = model.listaCliente();

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		Object[] fila = null;
		for (Cliente x : lista) {
			fila = new Object[] { x.getIdCliente(), 
					x.getNombre(), 
					x.getApellido(),
					x.getDni(),
					x.getTelefono(),
					x.getDireccion(),
					x.getPais(),
					x.getComprobante()};
			dtm.addRow(fila);
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
	
