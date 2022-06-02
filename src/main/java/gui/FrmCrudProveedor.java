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
import java.awt.event.MouseListener;
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

public class FrmCrudProveedor extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JTextField txtTelefono;
	private JTextField txtRuc;
	private JTextField txtProducto;
	private JTextField txtDireccion;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JComboBox<String> cboPais;

	int idseleccionado = -1;
	int hoveredRow = -1, hoveredColumn = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudProveedor frame = new FrmCrudProveedor();
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
	public FrmCrudProveedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("CRUD de Proveedor");
		setBounds(100, 100, 725, 455);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("NOMBRES : ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(42, 57, 96, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("RUC : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(42, 82, 56, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PRODUCTO : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(42, 107, 96, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DIRECCI\u00D3N :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(42, 132, 96, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("TEL\u00C9FONO : ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(359, 107, 94, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CORREO : ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(359, 57, 84, 14);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("PA\u00CDS : ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(359, 82, 56, 14);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("MANTENIMIENTO PROVEEDOR");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		lblNewLabel_7.setBounds(10, 11, 443, 27);
		getContentPane().add(lblNewLabel_7);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setBounds(450, 105, 201, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setBounds(136, 80, 201, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.addKeyListener(this);
		txtProducto.setBounds(136, 105, 201, 20);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(136, 130, 201, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(136, 55, 201, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(450, 55, 201, 20);
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
		cboPais.setBounds(450, 79, 201, 22);
		getContentPane().add(cboPais);

		btnRegistrar = new JButton("REGISTRAR\r\n");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(FrmCrudProveedor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegistrar.setBounds(10, 172, 165, 33);
		getContentPane().add(btnRegistrar);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 15));
		btnActualizar.setIcon(new ImageIcon(FrmCrudProveedor.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setBounds(185, 172, 165, 33);
		getContentPane().add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR\r\n");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminar.setIcon(new ImageIcon(FrmCrudProveedor.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setBounds(359, 172, 165, 33);
		getContentPane().add(btnEliminar);

		btnLimpiar = new JButton("LIMPIAR\r\n");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 15));
		btnLimpiar.setIcon(new ImageIcon(FrmCrudProveedor.class.getResource("/iconos/Trash.gif")));
		btnLimpiar.setBounds(534, 172, 165, 33);
		getContentPane().add(btnLimpiar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 689, 198);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombres", "RUC", "Producto",
				"Direcci\u00F3n", "Correo", "Pa\u00EDs", "Tel\u00E9fono" }));

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

		// selecciona una sola fila
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// desabilita mover las columnas
		table.getTableHeader().setReorderingAllowed(false);

		// color de la fila seleccionada
		table.setSelectionBackground(Color.GREEN);
		// No se pueda editar
		table.setDefaultEditor(Object.class, null);

		// Efecto Rollover
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
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiarJButton(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}

	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		inserta();
	}

	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualiza();
	}

	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		elimina();
	}

	protected void actionPerformedBtnLimpiarJButton(ActionEvent e) {
		limpiar();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTableJTable(MouseEvent e) {
		busca();
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
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

	private void inserta() {
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
				idseleccionado = -1;
				mensaje("Se insertó correctamente");
				lista();

			} else {
				mensaje("Error en el Registro");
			}

		}
	}

	private void busca() {
		int fila = table.getSelectedRow();
		idseleccionado = (Integer) table.getValueAt(fila, 0);
		String nombres = (String) table.getValueAt(fila, 1);
		String ruc = (String) table.getValueAt(fila, 2);
		String prod = (String) table.getValueAt(fila, 3);
		String direc = (String) table.getValueAt(fila, 4);
		String correo = (String) table.getValueAt(fila, 5);
		String pais = (String) table.getValueAt(fila, 6);
		String telef = (String) table.getValueAt(fila, 7);

		System.out.println(idseleccionado + "-" + nombres + "-" + ruc + "-" + prod + "-" + direc + "-" + correo + "-"
				+ pais + "-" + telef);

		txtNombre.setText(nombres);
		txtRuc.setText(ruc);
		txtProducto.setText(prod);
		txtDireccion.setText(direc);
		txtCorreo.setText(correo);
		cboPais.setSelectedItem(pais);
		txtTelefono.setText(telef);

	}

	private void elimina() {
		if (idseleccionado == -1) {
			mensaje("Seleccione un fila para eliminar");
		} else {
			ProveedorModel model = new ProveedorModel();
			int salida = model.EliminaProveedor(idseleccionado);

			if (salida > 0) {
				lista();
				idseleccionado = -1;
				mensaje("Proveedor Eliminado con éxito");

			} else {
				mensaje("Error en la eliminacion");
			}
		}
	}

	private void actualiza() {
		String nom = txtNombre.getText().trim();
		String ruc = txtRuc.getText().trim();
		String prod = txtProducto.getText();
		String direc = txtDireccion.getText().trim();
		String correo = txtCorreo.getText();
		String pais = cboPais.getSelectedItem().toString();
		String telef = txtTelefono.getText().trim();

		if (idseleccionado == -1) {
			mensaje("Seleccione una fila para actualizar");
		} else if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre debe ser de 2 a 20 caracteres");
		} else if (!ruc.matches(Validaciones.RUC)) {
			mensaje("El RUC debe ser de 11 dígitos");
		} else if (!prod.matches(Validaciones.TEXTO)) {
			mensaje("El producto debe ser de 2 a 20 caracteres");
		} else if (!direc.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección debe ser de 2 a 40 caracteres");
		} else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Seleccione un país");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Correo no valido");
		} else if (!telef.matches(Validaciones.TELEFONO)) {
			mensaje("El teléfono debe tener 9 dígitos");
		} else {
			Proveedor obj = new Proveedor();
			obj.setIdProveedor(idseleccionado);
			obj.setNombre(nom);
			obj.setRuc(ruc);
			obj.setProducto(prod);
			obj.setDireccion(direc);
			obj.setCorreo(correo);
			obj.setPais(pais);
			obj.setTelefono(telef);

			ProveedorModel model = new ProveedorModel();
			int salida = model.ActualizaProveedor(obj);

			if (salida > 0) {
				idseleccionado = -1;
				mensaje("Se actualizó correctamente");

				lista();

			} else {
				mensaje("Error en la actualización");
			}

		}

	}

	void limpiar() {
		txtNombre.setText("");
		txtRuc.setText("");
		txtProducto.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboPais.setSelectedIndex(0);
		txtNombre.requestFocusInWindow();
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
