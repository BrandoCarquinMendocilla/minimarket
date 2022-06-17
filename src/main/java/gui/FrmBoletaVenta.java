package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Boleta;
import entidad.Cliente;
import entidad.DetalleBoleta;
import entidad.Empleado;
import entidad.ReporteBoleta;
import model.BoletaModel;
import model.ClienteModel;
import model.EmpleadoModel;
import model.ProductoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import util.JComboBoxBD;

public class FrmBoletaVenta extends JInternalFrame {
	private JTextField txtDNI;
	private JTextField txtCantidadProducto;
	private JComboBox cboProducto;

	ResourceBundle rb = ResourceBundle.getBundle("SENTENCIAS_MYSQL");
	private JComboBox cboCajeros;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable table;

	Boleta boleta = new Boleta();
	List<DetalleBoleta> listaDetalle = new ArrayList<DetalleBoleta>();
	List<ReporteBoleta> listaReporte = new ArrayList<ReporteBoleta>();
	private JComboBox cboPais;
	private JPanel panelRe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoletaVenta frame = new FrmBoletaVenta();
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
	public FrmBoletaVenta() {
		setTitle("Boleta de Venta\r\n");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1167, 810);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Datos del Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(34, 55, 118, 21);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DNI :");
		lblNewLabel_2.setBounds(34, 87, 86, 14);
		getContentPane().add(lblNewLabel_2);

		txtDNI = new JTextField();
		txtDNI.setBounds(98, 84, 177, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Codigo Empleado :");
		lblNewLabel_3.setBounds(350, 14, 89, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Producto: ");
		lblNewLabel_4.setBounds(24, 244, 55, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Cantidad");
		lblNewLabel_5.setBounds(349, 244, 59, 14);
		getContentPane().add(lblNewLabel_5);

		txtCantidadProducto = new JTextField();
		txtCantidadProducto.setBounds(418, 238, 118, 20);
		getContentPane().add(txtCantidadProducto);
		txtCantidadProducto.setColumns(10);

		JButton btnAgrearProducto = new JButton("Agregar Producto");
		btnAgrearProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarVenta();
			}
		});
		btnAgrearProducto.setBounds(24, 283, 164, 23);
		getContentPane().add(btnAgrearProducto);

		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					String nomProducto = table.getModel().getValueAt(row, 0).toString();

					DetalleBoleta lista2 = (DetalleBoleta) listaDetalle.stream()
							.filter(d -> d.getNombreProducto().equals(nomProducto)).toArray()[0];

					listaDetalle.remove(lista2);
					listarDetalleOrden();
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
				}
			}
		});
		btnEliminarProducto.setBounds(198, 283, 164, 23);
		getContentPane().add(btnEliminarProducto);

		JButton btnActualizarProducto = new JButton("Actualizar Cantidad");
		btnActualizarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					String nomProducto = table.getModel().getValueAt(row, 0).toString();

					DetalleBoleta lista2 = (DetalleBoleta) listaDetalle.stream()
							.filter(d -> d.getNombreProducto().equals(nomProducto)).toArray()[0];
					try {
						String dato = JOptionPane.showInputDialog("Ingrese nueva cantidad del producto " + nomProducto);
						int cant = Integer.parseInt(dato);

						listaDetalle.forEach(detalle -> {
							if (lista2 == detalle) {
								detalle.setCantidad(cant);
								double precio = ProductoModel.findByPrecio(detalle.getNombreProducto(),
										rb.getString("TABLA_PRODUCTO"), rb.getString("CAMPO_PRODUCTO"));
								detalle.setSubtotal(precio * cant);
								return;
							}
						});
						listarDetalleOrden();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Proceso cancelado");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
				}

			}
		});
		btnActualizarProducto.setBounds(372, 283, 164, 23);
		getContentPane().add(btnActualizarProducto);

		panelRe = new JPanel();
		panelRe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Boleta de Ventas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRe.setBounds(566, 11, 557, 740);
		getContentPane().add(panelRe);
		panelRe.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 349, 518, 374);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Producto - Descripción", "Cantidad", "Sub - Total" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_6 = new JLabel("Productos Registrados");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_6.setBounds(194, 317, 187, 21);
		getContentPane().add(lblNewLabel_6);

		JLabel lblGneraTuBoleta = new JLabel("Genera tu boleta!");
		lblGneraTuBoleta.setFont(new Font("Bahnschrift", Font.BOLD, 31));
		lblGneraTuBoleta.setBounds(24, 11, 287, 35);
		getContentPane().add(lblGneraTuBoleta);

		cboProducto = new JComboBoxBD(rb.getString("MYSQL_PRODUCTO"));
		cboProducto.setBounds(88, 237, 251, 22);
		getContentPane().add(cboProducto);

		cboCajeros = new JComboBoxBD(rb.getString("MYSQL_Cajeros"));
		cboCajeros.setBounds(450, 10, 96, 22);
		getContentPane().add(cboCajeros);

		JLabel lblNewLabel_2_1 = new JLabel("Nombres:");
		lblNewLabel_2_1.setBounds(34, 118, 86, 14);
		getContentPane().add(lblNewLabel_2_1);

		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setColumns(10);
		txtNombres.setBounds(98, 115, 177, 20);
		getContentPane().add(txtNombres);

		JLabel lblNewLabel_2_1_1 = new JLabel("Apellidos:");
		lblNewLabel_2_1_1.setBounds(285, 118, 86, 14);
		getContentPane().add(lblNewLabel_2_1_1);

		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(350, 115, 186, 20);
		getContentPane().add(txtApellidos);

		JLabel lblNewLabel_2_1_2 = new JLabel("Telefono:");
		lblNewLabel_2_1_2.setBounds(34, 174, 86, 14);
		getContentPane().add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_2_1_3.setBounds(34, 146, 86, 14);
		getContentPane().add(lblNewLabel_2_1_3);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 143, 438, 20);
		getContentPane().add(txtDireccion);

		JLabel lblNewLabel_1_1 = new JLabel("Agregue sus productos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 212, 187, 21);
		getContentPane().add(lblNewLabel_1_1);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(99, 171, 176, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		JButton btnNewButton = new JButton("Ejecutar Venta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listaDetalle.size() == 0) {
					JOptionPane.showMessageDialog(null, "Se debe ingresar productos");
					return;
				}

				detalle(cabecera());
			}
		});
		btnNewButton.setBounds(24, 734, 121, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Generar Reporte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarReporte();
			}
		});
		btnNewButton_1.setBounds(418, 734, 118, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Pais:");
		lblNewLabel_2_1_2_1.setBounds(285, 174, 86, 14);
		getContentPane().add(lblNewLabel_2_1_2_1);

		cboPais = new JComboBox();
		cboPais.setEnabled(false);
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
		cboPais.setBounds(350, 170, 186, 22);
		getContentPane().add(cboPais);

		JButton btnNewButton_2 = new JButton("Buscar Cliente");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dni = ClienteModel.findByNombre(txtDNI.getText(), rb.getString("TABLA_CLIENTE"),
						rb.getString("CAMPO_CLIENTE"));

				ClienteModel model = new ClienteModel();
				List<Cliente> lista = model.listaCliente();

				for (Cliente x : lista) {
					if (dni == x.getIdCliente()) {

						txtNombres.setText(x.getNombre());
						txtApellidos.setText(x.getApellido());
						txtTelefono.setText(x.getTelefono());
						txtDireccion.setText(x.getDireccion());
						cboPais.setSelectedItem(x.getPais());

						/*
						 * txtNombres.setEditable(false); txtApellidos.setEditable(false);
						 * txtTelefono.setEditable(false); txtDireccion.setEditable(false);
						 * cboPais.setEditable(false); cboPais.setEnabled(false);
						 */

					} else {
						JOptionPane.showMessageDialog(null, "El Cliente ingresado no existe - ingrese Datos ");
						txtNombres.setEditable(true);
						txtApellidos.setEditable(true);
						txtTelefono.setEditable(true);
						txtDireccion.setEditable(true);
						cboPais.setEditable(true);
						cboPais.setEnabled(true);
					}

				}
			}
		});
		btnNewButton_2.setBounds(292, 83, 147, 23);
		getContentPane().add(btnNewButton_2);
		
		btnPrueba = new JButton("Prueba");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prueba();
			}
		});
		btnPrueba.setBounds(208, 734, 89, 23);
		getContentPane().add(btnPrueba);

	}
	int dato;
	private JButton btnPrueba;
	int cabecera() {
		int salida = 1;
		// Datos del empleado
		int empleado = EmpleadoModel.findByNombre(cboCajeros.getSelectedItem().toString(),
				rb.getString("TABLA_EMPLEADO"), rb.getString("CAMPO_EMPLEADO"));
		// Datos del cliente
		int dni = ClienteModel.findByNombre(txtDNI.getText(), rb.getString("TABLA_CLIENTE"),
				rb.getString("CAMPO_CLIENTE"));
		if (dni == -1) {
			String dn = txtDNI.getText();
			String telefono = txtTelefono.getText();
			String nombres = txtNombres.getText();
			String apellidos = txtApellidos.getText();
			String direccion = txtDireccion.getText();
			String pais = cboPais.getSelectedItem().toString();
			Cliente cli = new Cliente();
			cli.setDni(dn);
			cli.setNombre(nombres);
			cli.setApellido(apellidos);
			cli.setTelefono(telefono);
			cli.setDireccion(direccion);
			cli.setPais(pais);
			dni = cli.getIdCliente();
		}

		double total = listaDetalle.stream().mapToDouble(i -> i.getSubtotal()).sum();

		boleta.setIdEmpleado(empleado);
		boleta.setIdCliente(dni);
		boleta.setTotal(total);
		BoletaModel model = new BoletaModel();
		salida = model.ingresarOrdenCompra(boleta);
		
		dato=salida;
		return salida;
	}

	void detalle(int idOrden) {

		listaDetalle.forEach(detalleBoleta -> {
			detalleBoleta.setIdOrden(idOrden);
			BoletaModel model = new BoletaModel();
			int salida2 = model.ingresarDetalleOrden(detalleBoleta);
		});

	}

	void ejecutarVenta() {
		int producto = ProductoModel.findByNombre(cboProducto.getSelectedItem().toString(),
				rb.getString("TABLA_PRODUCTO"), rb.getString("CAMPO_PRODUCTO"));
		double precio = ProductoModel.findByPrecio(cboProducto.getSelectedItem().toString(),
				rb.getString("TABLA_PRODUCTO"), rb.getString("CAMPO_PRODUCTO"));
		System.out.println(precio);
		int cantidad = Integer.parseInt(txtCantidadProducto.getText());
		double subtotal = precio * cantidad;

		DetalleBoleta lista2 = new DetalleBoleta();
		lista2.setIdProducto(producto);
		lista2.setNombreProducto(cboProducto.getSelectedItem().toString());
		lista2.setCantidad(cantidad);
		lista2.setSubtotal(subtotal);

		listaDetalle.add(lista2);
		listarDetalleOrden();

	}

	void listarDetalleOrden() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Object[] fila = null;
		for (DetalleBoleta x : listaDetalle) {

			fila = new Object[] { x.getNombreProducto(), x.getCantidad(), x.getSubtotal() };
			dtm.addRow(fila);

		}

	}

	void prueba() {
		// Detalle de boleta
				double precio = ProductoModel.findByPrecio(cboProducto.getSelectedItem().toString(),
						rb.getString("TABLA_PRODUCTO"), rb.getString("CAMPO_PRODUCTO"));
				System.out.println(precio);
				int cantidad = Integer.parseInt(txtCantidadProducto.getText());
				double subtotal = precio * cantidad;

				ReporteBoleta report = new ReporteBoleta();
				report.setIdOrden(dato);// idOrden
				report.setNombreProducto(cboProducto.getSelectedItem().toString());// nombreProducto
				report.setCantidadPro(cantidad);// cantidadPro
				report.setPrecioPro(precio);// subtotal
				report.setSubtotal(subtotal);// total

				// Datos del cliente
				int dni = ClienteModel.findByNombre(txtDNI.getText(), rb.getString("TABLA_CLIENTE"),
						rb.getString("CAMPO_CLIENTE"));

				ClienteModel model = new ClienteModel();
				List<Cliente> lista = model.listaCliente();
				for (Cliente x : lista) {
					if (dni == x.getIdCliente()) {
						report.setDni(x.getDni());//dniCli
						report.setNomCli(x.getNombre());//nomCli
						report.setApeCli(x.getApellido());//apeCli
					}
				}
				// Datos del empleado
				int empleado = EmpleadoModel.findByNombre(cboCajeros.getSelectedItem().toString(),
						rb.getString("TABLA_EMPLEADO"), rb.getString("CAMPO_EMPLEADO"));
				EmpleadoModel moEmp = new EmpleadoModel();
				List<Empleado> listEmp = new ArrayList<Empleado>();
				for (Empleado y : listEmp) {
					if (empleado == y.getIdEmpleado()) {
						report.setNomEmp(y.getNombre());//nomEmp
						report.setApeEmp(y.getApellido());//apeEmp
					}
				}
				
				listaReporte.add(report);
				System.out.println(listaReporte);
	}
	
	
	
	
	
	// Reporte de Boleta
	void generarReporte() {
		// Detalle de boleta
		double precio = ProductoModel.findByPrecio(cboProducto.getSelectedItem().toString(),
				rb.getString("TABLA_PRODUCTO"), rb.getString("CAMPO_PRODUCTO"));
		System.out.println(precio);
		int cantidad = Integer.parseInt(txtCantidadProducto.getText());
		double subtotal = precio * cantidad;

		ReporteBoleta report = new ReporteBoleta();
		report.setIdOrden(dato);// idOrden
		report.setNombreProducto(cboProducto.getSelectedItem().toString());// nombreProducto
		report.setCantidadPro(cantidad);// cantidadPro
		report.setPrecioPro(precio);// subtotal
		report.setSubtotal(subtotal);// total

		// Datos del cliente
		int dni = ClienteModel.findByNombre(txtDNI.getText(), rb.getString("TABLA_CLIENTE"),
				rb.getString("CAMPO_CLIENTE"));

		ClienteModel model = new ClienteModel();
		List<Cliente> lista = model.listaCliente();
		for (Cliente x : lista) {
			if (dni == x.getIdCliente()) {
				report.setDni(x.getDni());//dniCli
				report.setNomCli(x.getNombre());//nomCli
				report.setApeCli(x.getApellido());//apeCli
			}
		}
		// Datos del empleado
		int empleado = EmpleadoModel.findByNombre(cboCajeros.getSelectedItem().toString(),
				rb.getString("TABLA_EMPLEADO"), rb.getString("CAMPO_EMPLEADO"));
		EmpleadoModel moEmp = new EmpleadoModel();
		List<Empleado> listEmp = new ArrayList<Empleado>();
		for (Empleado y : listEmp) {
			if (empleado == y.getIdEmpleado()) {
				report.setNomEmp(y.getNombre());//nomEmp
				report.setApeEmp(y.getApellido());//apeEmp
			}
		}

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaReporte);
		String jasper = "Boleta.jasper";

		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);

		JRViewer jrViewer = new JRViewer(print);

		panelRe.removeAll();
		panelRe.add(jrViewer);
		panelRe.repaint();
		panelRe.revalidate();

	}
}
