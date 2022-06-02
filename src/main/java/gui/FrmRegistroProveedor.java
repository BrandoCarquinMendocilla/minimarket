package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;

public class FrmRegistroProveedor extends JInternalFrame implements ActionListener, KeyListener {
	private JTextField txtNombre;
	private JTextField txtRuc;
	private JTextField txtProducto;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JComboBox<String> cboPais;
	private JTable table;
	int hoveredRow = -1, hoveredColumn = -1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProveedor frame = new FrmRegistroProveedor();
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
	public FrmRegistroProveedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Proveedor\r\n");
		setBounds(100, 100, 775, 422);
		getContentPane().setLayout(null);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroProveedor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setBounds(543, 137, 185, 38);
		getContentPane().add(btnRegistrar);

		JLabel lblNewLabel = new JLabel("NOMBRE : ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 51, 79, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("RUC : \r\n");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(377, 51, 56, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DIRECCI\u00D3N : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(377, 76, 98, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PRODUCTO : ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 76, 106, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("REGISTRO PROVEEDOR\r\n");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 21, 291, 19);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CORREO : ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 107, 90, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("TEL\u00C9FONO : ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(20, 137, 98, 14);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("PA\u00CDS : \r\n");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(377, 107, 46, 14);
		getContentPane().add(lblNewLabel_7);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(109, 49, 220, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setBounds(470, 49, 258, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.addKeyListener(this);
		txtProducto.setBounds(128, 74, 202, 20);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(470, 74, 258, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(109, 101, 220, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);

		cboPais = new JComboBox<String>();
		cboPais.addItem("[Seleccionar]");
		cboPais.addItem("Perú");
		cboPais.addItem("Argentina");
		cboPais.addItem("Bolivia");
		cboPais.addItem("Chile");
		cboPais.addItem("Uruguay");
		cboPais.addItem("Venezuela");
		cboPais.addItem("Brasil");
		cboPais.addItem("Paraguay");
		cboPais.addItem("España");
		cboPais.addItem("Honduras");
		cboPais.setBounds(470, 104, 258, 22);
		getContentPane().add(cboPais);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setBounds(128, 135, 201, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 739, 195);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "RUC", "Producto",
				"Direcci\u00F3n", "Correo", "Pa\u00EDs", "Tel\u00E9fono" }

		));

		// alineaciÃ³n
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

		// tamano de la fila
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(180);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}

	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String nom = txtNombre.getText().trim();
		String ruc = txtRuc.getText().trim();
		String prod = txtProducto.getText();
		String direc = txtDireccion.getText().trim();
		String correo = txtCorreo.getText().trim();
		String pais = cboPais.getSelectedItem().toString();
		String tele = txtTelefono.getText();

		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre debe ser de 2 a 20 caracteres");
		} else if (!ruc.matches(Validaciones.RUC)) {
			mensaje("El DNI debe ser de 11 dígitos");
		} else if (!prod.matches(Validaciones.TEXTO)) {
			mensaje("El producto debe ser de 2 a 20 caracteres");
		} else if (!direc.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección debe ser de 2 a 40 caracteres");
		} else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Correo no valido");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione un país");
		} else if (!tele.matches(Validaciones.TELEFONO)) {
			mensaje("El teléfono es de 9 dígitos");
		} else {
			Proveedor obj = new Proveedor();
			obj.setNombre(nom);
			obj.setRuc(ruc);
			obj.setProducto(prod);
			obj.setDireccion(direc);
			obj.setCorreo(correo);
			obj.setPais(pais);
			obj.setTelefono(tele);

			ProveedorModel model = new ProveedorModel();
			int salida = model.insertaProveedor(obj);

			if (salida > 0) {
				mensaje("Se insertó correctamente");
				limpiar();
				lista();
			} else {
				mensaje("Error en el Registro");
			}

		}
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}

	public void limpiar() {
		txtNombre.setText("");
		txtRuc.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboPais.setSelectedIndex(0);
		txtNombre.requestFocusInWindow();
	}

	private void lista() {
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lista = model.listaProveedor();

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Object[] fila = null;
		for (Proveedor x : lista) {
			fila = new Object[] { x.getIdProveedor(), x.getNombre(), x.getRuc(), x.getProducto(), x.getDireccion(),
					x.getCorreo(), x.getPais(), x.getTelefono() };
			dtm.addRow(fila);
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtTelefono) {
			keyTypedTxtTelefonoJTextField(e);
		}
		if (e.getSource() == txtProducto) {
			keyTypedTxtProductoJTextField(e);
		}
		if (e.getSource() == txtRuc) {
			keyTypedTxtRucJTextField(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombreJTextField(e);
		}
	}

	protected void keyTypedTxtNombreJTextField(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
		}
	}

	protected void keyTypedTxtRucJTextField(KeyEvent e) {
		if (Character.isLetter(e.getKeyChar())) {
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
		}

		String ruc = txtRuc.getText() + e.getKeyChar();
		if (ruc.length() > 11) {
			e.consume();
		}
	}

	protected void keyTypedTxtProductoJTextField(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
		}
	}

	protected void keyTypedTxtTelefonoJTextField(KeyEvent e) {
		if (Character.isLetter(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
		}

		String tele = txtTelefono.getText() + e.getKeyChar();
		if (tele.length() > 9) {
			getToolkit().beep();
			e.consume();
		}
	}
}
