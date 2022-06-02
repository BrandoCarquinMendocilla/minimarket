package gui;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import entidad.Producto;
import model.ProductoModel;
import util.JComboBoxBD;
import util.Validaciones;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;


public class FrmRegistroProducto extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTable table;
	private JComboBox cboCategoria;
	private JTextField txtCantidadPeso;
	private JComboBox cboPeso;
	int hoveredRow = -1, hoveredColumn = -1;

	ResourceBundle rb = ResourceBundle.getBundle("SENTENCIAS_MYSQL");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProducto frame = new FrmRegistroProducto();
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
	public FrmRegistroProducto() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Producto\r\n");
		setBounds(100, 100, 600, 458);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registra tu Producto");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		lblNewLabel.setBounds(44, 23, 287, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\BrandoJavier\\eclipse-workspace\\minimarket\\src\\main\\resources\\iconos\\Add.gif"));
		lblNewLabel_1.setBounds(330, 23, 74, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_2.setBounds(33, 84, 66, 14);
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
		txtNombre.setBounds(102, 80, 109, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblCategoria.setBounds(221, 83, 74, 17);
		getContentPane().add(lblCategoria);
		
		cboCategoria = new JComboBoxBD(rb.getString("MYSQL_CATEGORIA"));
		cboCategoria.setBounds(305, 79, 124, 22);
		getContentPane().add(cboCategoria);
		
		JLabel lblNewLabel_3 = new JLabel("_____________________________________________________");
		lblNewLabel_3.setBounds(41, 44, 318, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_4.setBounds(439, 109, 66, 20);
		getContentPane().add(lblNewLabel_4);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(494, 108, 63, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stock:");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_5.setBounds(439, 82, 46, 18);
		getContentPane().add(lblNewLabel_5);
		
		txtStock = new JTextField();
		txtStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtStock.setBounds(494, 80, 63, 20);
		getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		JButton btnProducto = new JButton("Ingresar Producto");
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnProducto.setIcon(new ImageIcon("C:\\Users\\BrandoJavier\\eclipse-workspace\\minimarket\\src\\main\\resources\\iconos\\Create.gif"));
		btnProducto.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		btnProducto.setBounds(393, 150, 164, 35);
		getContentPane().add(btnProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 242, 524, 161);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent e) {
				 Point p = e.getPoint();
		         hoveredRow = table.rowAtPoint(p);
		         hoveredColumn = table.columnAtPoint(p);
		         table.setRowSelectionInterval(hoveredRow, hoveredRow);
		         table.repaint();
			}
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				 hoveredRow = hoveredColumn = -1;
		         table.repaint();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre","Categoria","Precio", "Stock", "Peso", "Cant. Peso"
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
	    
	    
		
		JLabel lblNewLabel_6 = new JLabel("Lista de Productos:");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNewLabel_6.setBounds(33, 214, 119, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Peso:");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_7.setBounds(33, 111, 46, 17);
		getContentPane().add(lblNewLabel_7);
		
		cboPeso = new JComboBox();
		cboPeso.addItem("Elegir");
		cboPeso.addItem("Gramos");
		cboPeso.addItem("Litros");
		cboPeso.addItem("Militros");
		cboPeso.setBounds(102, 107, 109, 22);
		getContentPane().add(cboPeso);
		
		JLabel lblNewLabel_8 = new JLabel("Cantidad/Peso:");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_8.setBounds(221, 109, 119, 20);
		getContentPane().add(lblNewLabel_8);
		
		txtCantidadPeso = new JTextField();
		
		txtCantidadPeso.setBounds(343, 108, 86, 20);
		getContentPane().add(txtCantidadPeso);
		txtCantidadPeso.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("_______________________________________________________________________________________");
		lblNewLabel_3_1.setBounds(33, 189, 524, 14);
		getContentPane().add(lblNewLabel_3_1);
		//Mostrar datos 
		listarProductos();
		table.repaint();
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
		String pre = txtPrecio.getText().trim();
		String stock  = txtStock.getText().trim();
		String peso = cboPeso.getSelectedItem().toString();
		String cantPe = txtCantidadPeso.getText().trim();
		
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
					x.getCategoria(),
					x.getPrecio(),
					x.getStock(),
					x.getPeso(),
					x.getCantidadPeso(),
			};
			dtm.addRow(fila);
		}
	}
	
	
	
	
}
