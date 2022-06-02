package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Producto;
import model.ProductoModel;
import util.JComboBoxBD;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class FrmCrudProducto extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtCantidadPeso;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTable table;
	private JComboBox cboCategoria;
	private JComboBox cboPeso;
	int idseleccionado=-1;
	int hoveredRow = -1, hoveredColumn = -1;

	ResourceBundle rb = ResourceBundle.getBundle("SENTENCIAS_MYSQL");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudProducto frame = new FrmCrudProducto();
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
	public FrmCrudProducto() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("CRUD de Producto\r\n");
		setBounds(100, 100, 595, 439);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("_______________________________________________________");
		lblNewLabel_3.setBounds(35, 32, 340, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblProducto = new JLabel("Mantenimiento Producto");
		lblProducto.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		lblProducto.setBounds(38, 11, 352, 35);
		getContentPane().add(lblProducto);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_2.setBounds(27, 72, 66, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
				String nom = txtNombre.getText();
				if(nom.length()>20) {
					e.consume();
				}
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(96, 68, 109, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblNewLabel_7 = new JLabel("Peso:");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_7.setBounds(27, 99, 46, 17);
		getContentPane().add(lblNewLabel_7);
		
		cboPeso = new JComboBox();
		cboPeso.addItem("Elegir");
		cboPeso.addItem("Gramos");
		cboPeso.addItem("Litros");
		cboPeso.addItem("Militros");
		cboPeso.setBounds(96, 95, 109, 22);
		getContentPane().add(cboPeso);
		
		JLabel lblNewLabel_8 = new JLabel("Cantidad/Peso:");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_8.setBounds(215, 97, 119, 20);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoria.setBounds(215, 71, 74, 17);
		getContentPane().add(lblCategoria);
		
		cboCategoria = new JComboBoxBD(rb.getString("MYSQL_CATEGORIA"));
		cboCategoria.setBounds(299, 67, 124, 22);
		getContentPane().add(cboCategoria);
		
		txtCantidadPeso = new JTextField();
		txtCantidadPeso.setColumns(10);
		txtCantidadPeso.setBounds(337, 96, 86, 20);
		getContentPane().add(txtCantidadPeso);
		
		JLabel lblNewLabel_5 = new JLabel("Stock:");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_5.setBounds(433, 70, 46, 18);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_4.setBounds(433, 97, 66, 20);
		getContentPane().add(lblNewLabel_4);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(488, 96, 63, 20);
		getContentPane().add(txtPrecio);
		
		txtStock = new JTextField();
		txtStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtStock.setColumns(10);
		txtStock.setBounds(488, 68, 63, 20);
		getContentPane().add(txtStock);
		
		JButton btnActualizarProducto = new JButton("Actualizar Producto");
		btnActualizarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		btnActualizarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		btnActualizarProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnActualizarProducto.setBounds(215, 139, 164, 35);
		getContentPane().add(btnActualizarProducto);
		
		JLabel lblNewLabel_6 = new JLabel("Lista de Productos:");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNewLabel_6.setBounds(27, 202, 119, 14);
		getContentPane().add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 230, 524, 161);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseMotionListener(new MouseMotionAdapter() {
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Descripci\u00F3n","Peso","Cantidad", "Categoria", "Precio", "Stock"
			}
		));
		scrollPane.setViewportView(table);
		
		//Tamaño de las tablas
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		//desabilita mover las columnas
		table.getTableHeader().setReorderingAllowed(false);
		
		//color de la fila seleccionada
		table.setSelectionBackground(new Color(153, 204, 153));
		

	    //No se pueda editar
	    table.setDefaultEditor(Object.class, null);
	    
	    
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminarProducto.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		btnEliminarProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEliminarProducto.setBounds(389, 139, 164, 35);
		getContentPane().add(btnEliminarProducto);
		
		JButton btnProducto_1_1 = new JButton("Ingresar Producto");
		btnProducto_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnProducto_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		btnProducto_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnProducto_1_1.setBounds(27, 139, 164, 35);
		getContentPane().add(btnProducto_1_1);

		listarProductos();
		
	}
	void mensaje (String x) {
		JOptionPane.showMessageDialog(this, x);
	}
	void limpiar() {
		txtNombre.setText("");
		cboCategoria.setSelectedIndex(0);
		txtPrecio.setText("");
		txtStock.setText("");
		cboPeso.setSelectedIndex(0);
		txtCantidadPeso.setText("");
	}
	
	void ingresar() {
		String nom = txtNombre.getText().trim();
		int cat;
		cat = ProductoModel.findByNombre(cboCategoria.getSelectedItem().toString(),rb.getString("TABLA_CATEGORIA"),rb.getString("CAMPO_CATEGORIA"));
		String pre = txtPrecio.getText();
		String stock  = txtStock.getText().trim();
		String peso = cboPeso.getSelectedItem().toString();
		String cantPe = txtCantidadPeso.getText();
		
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("Ingrese correctamente el nombre del proucto nuevo");
			txtNombre.setText("");
			txtNombre.requestFocusInWindow();
		}else if(cboCategoria.getSelectedIndex()==0) {
			mensaje("Seleccione una categoria");
		}else if(!pre.matches(Validaciones.PRECIO)) {
			mensaje("Ingrese correctamente el precio 0.0");
			txtPrecio.setText("");
			txtPrecio.requestFocusInWindow();
		}else if(!stock.matches(Validaciones.STOCK)) {
			mensaje("Ingrese correctamente el stock");
			txtStock.setText("");
			txtStock.requestFocusInWindow();
		}else if(cboPeso.getSelectedIndex()==0){
			mensaje("Seleccione el peso del producto");
		}else if(!cantPe.matches(Validaciones.PRECIO)) {
			mensaje("Ingrese el peso en 0.0 (Decimales)");
			txtCantidadPeso.setText("");
			txtCantidadPeso.requestFocusInWindow();
		}else {
			Producto producto = new Producto();
			producto.setNombre(nom);
			producto.setCategoria(cat);
			producto.setPrecio(pre);
			producto.setStock(stock);
			producto.setPeso(peso);
			producto.setCantidadPeso(cantPe);
			
			ProductoModel model = new ProductoModel();
			int salida = model.ingresarProducto(producto);
			
			if(salida>0) {
				mensaje("Producto registrado con exito");
				listarProductos();
				limpiar();
			}else {
				mensaje("Corriga los datos ingresados");
			}
		}
	}	
		
	void listarProductos() {
		ProductoModel model = new ProductoModel();
		List<Producto> lista= model.listarProducto();
			
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Object[] fila = null;
		for(Producto x : lista) {
			fila= new Object[] {
					x.getIdProducto(),
					x.getNombre(),
					x.getPeso(),
					x.getCantidadPeso(),
					x.getCategoria(),
					x.getPrecio(),
					x.getStock(),
			};
			dtm.addRow(fila);
		}
	}
	void buscar() {
		int fila = table.getSelectedRow();
		idseleccionado = (Integer)table.getValueAt(fila,0);
		String nom = (String)table.getValueAt(fila, 1);
		int cat;
		cat = ProductoModel.findByNombre(cboCategoria.getSelectedItem().toString(),rb.getString("TABLA_CATEGORIA"),rb.getString("CAMPO_CATEGORIA"));
		String pre = (String)table.getValueAt(fila, 5);
		String stock  = (String)table.getValueAt(fila, 6);
		String peso = (String)table.getValueAt(fila, 2);
		String cantPe = (String)table.getValueAt(fila, 3);
		System.out.println(nom+"-"+cat+"-"+pre+"-"+stock+"-"+peso+"-"+cantPe);
		
		txtNombre.setText(nom);
		cboCategoria.setSelectedItem(cat);
		txtPrecio.setText(pre);
		txtStock.setText(stock);
		cboPeso.setSelectedItem(peso);
		txtCantidadPeso.setText(cantPe);
	}
	
	void actualizar() {
		String nom = txtNombre.getText().trim();
		int cat;
		cat = ProductoModel.findByNombre(cboCategoria.getSelectedItem().toString(),rb.getString("TABLA_CATEGORIA"),rb.getString("CAMPO_CATEGORIA"));
		String pre = txtPrecio.getText().trim();
		String stock  = txtStock.getText();
		String peso = cboPeso.getSelectedItem().toString();
		String cantPe = txtCantidadPeso.getText().trim();
		
		if (idseleccionado ==-1) {
			mensaje("Seleccione una fila");
		}
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("Ingrese correctamente el nombre del proucto nuevo");
			txtNombre.setText("");
			txtNombre.requestFocusInWindow();
		}else if(cboCategoria.getSelectedIndex()==0) {
			mensaje("Seleccione una categoria");
		}else if(!pre.matches(Validaciones.PRECIO)) {
			mensaje("Ingrese correctamente el precio 0.0");
			txtPrecio.setText("");
			txtPrecio.requestFocusInWindow();
		}else if(!stock.matches(Validaciones.STOCK)) {
			mensaje("Ingrese correctamente el stock");
			txtStock.setText("");
			txtStock.requestFocusInWindow();
		}else if(cboPeso.getSelectedIndex()==0){
			mensaje("Seleccione el peso del producto");
		}else if(!cantPe.matches(Validaciones.PRECIO)) {
			mensaje("Ingrese el peso en 0.0 (Decimales)");
			txtCantidadPeso.setText("");
			txtCantidadPeso.requestFocusInWindow();
		}else {
			Producto producto = new Producto();
			producto.setIdProducto(idseleccionado);
			producto.setNombre(nom);
			producto.setCategoria(cat);
			producto.setPrecio(pre);
			producto.setStock(stock);
			producto.setPeso(peso);
			producto.setCantidadPeso(cantPe);
			
			ProductoModel model = new ProductoModel();
			int salida = model.actualizararProducto(producto);
			
			if(salida>0) {
				mensaje("Producto actualizado con exito");
				idseleccionado= -1;
				listarProductos();
				limpiar();
			}else {
				mensaje("Corriga los datos para actualizar correctamente");
			}
		}
	}
	void eliminar() {
		if(idseleccionado==-1) {
			mensaje("Seleccionar una fila para eliminar");
		}else {
			ProductoModel model = new ProductoModel();
			int salida = model.eliminarProducto(idseleccionado);

			if (salida > 0) {
				listarProductos();
				idseleccionado=-1;
				mensaje("Producto Eliminado con exito");
				limpiar();
				
			} else {
				mensaje("Error en la eliminacion");
			}
		}
	}
	
}
