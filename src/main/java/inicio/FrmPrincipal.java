package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.FrmBoletaVenta;
import gui.FrmConsultaClientes;
import gui.FrmConsultaProductos;
import gui.FrmConsultaProveedor;
import gui.FrmConsultaEmpleado;
import gui.FrmCrudCliente;
import gui.FrmCrudProducto;
import gui.FrmCrudProveedor;
import gui.FrmCrudEmpleado;
import gui.FrmRegistroCliente;
import gui.FrmRegistroProducto;
import gui.FrmRegistroProveedor;
import gui.FrmRegistroEmpleado;
import gui.FrmReporteBoletas;
import gui.FrmReporteCliente;
import gui.FrmReporteProductos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmRegistroCliente;

	private FrmRegistroCliente frmRC = new FrmRegistroCliente();
	private FrmRegistroProveedor frmRP = new FrmRegistroProveedor();
	private FrmRegistroEmpleado frmRV = new FrmRegistroEmpleado();
	private FrmRegistroProducto frmRPR = new FrmRegistroProducto();
	private FrmCrudCliente frmCC = new FrmCrudCliente();
	private FrmCrudProveedor frmCP = new FrmCrudProveedor();
	private FrmCrudEmpleado frmCV = new FrmCrudEmpleado();
	private FrmCrudProducto frmCPR = new FrmCrudProducto();
	private FrmConsultaClientes frmCCl = new FrmConsultaClientes();
	private FrmConsultaProveedor frmCPRO = new FrmConsultaProveedor();
	private FrmConsultaEmpleado frmCVE = new FrmConsultaEmpleado();
	private FrmConsultaProductos frmCPROD = new FrmConsultaProductos();
	private FrmReporteCliente frmRCL = new FrmReporteCliente();
	private FrmReporteProductos frmRPROD = new FrmReporteProductos();
	private FrmReporteBoletas frmRB = new FrmReporteBoletas();
	private FrmBoletaVenta frmBV  = new FrmBoletaVenta();
	private JMenuItem mntmRegistroProveedor;
	private JMenuItem mntmRegistroVendedor;
	private JMenuItem mntmRegistroProducto;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmCrudCliente;
	private JMenuItem mntmCrudProveedor;
	private JMenuItem mntmCrudVendedor;
	private JMenuItem mntmCrudProducto;
	private JMenuItem mntmConsultaCliente;
	private JMenuItem mntmConsultaProductos;
	private JMenuItem mntmConsultaProveedor;
	private JMenuItem mntmConsultaEmpleado;
	private JMenuItem mntmReporteClientes;
	private JMenuItem mntmReportesProductos;
	private JMenuItem mntmReporteBoletas;
	private JMenu mnNewMenu;
	private JMenuItem mntmSalir;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setResizable(false);
		setTitle("Sistema Minimarket \"Tambito Mass\"");
		setBounds(100, 100, 1382, 688);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Archivo\r\n");
		mnNewMenu.addActionListener(this);
		mnNewMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Desktop.gif")));
		menuBar.add(mnNewMenu);

		mntmSalir = new JMenuItem("Salir\r\n");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Left.gif")));
		mnNewMenu.add(mntmSalir);

		JMenu mnNewMenu_1 = new JMenu("Registro\r\n");
		mnNewMenu_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Edit.gif")));
		menuBar.add(mnNewMenu_1);

		mntmRegistroCliente = new JMenuItem("Cliente");
		mntmRegistroCliente.addActionListener(this);
		mntmRegistroCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User.gif")));
		mnNewMenu_1.add(mntmRegistroCliente);

		mntmRegistroProveedor = new JMenuItem("Proveedor\r\n");
		mntmRegistroProveedor.addActionListener(this);
		mntmRegistroProveedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Users.gif")));
		mnNewMenu_1.add(mntmRegistroProveedor);

		mntmRegistroVendedor = new JMenuItem("Empleado");
		mntmRegistroVendedor.addActionListener(this);
		mntmRegistroVendedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User group.gif")));
		mnNewMenu_1.add(mntmRegistroVendedor);

		mntmRegistroProducto = new JMenuItem("Producto");
		mntmRegistroProducto.addActionListener(this);
		mntmRegistroProducto.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Box.gif")));
		mnNewMenu_1.add(mntmRegistroProducto);

		mnNewMenu_2 = new JMenu("Mantenimiento\r\n");
		mnNewMenu_2.addActionListener(this);
		mnNewMenu_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Gear.gif")));
		menuBar.add(mnNewMenu_2);

		mntmCrudCliente = new JMenuItem("CRUD Cliente\r\n");
		mntmCrudCliente.addActionListener(this);
		mntmCrudCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User.gif")));
		mnNewMenu_2.add(mntmCrudCliente);

		mntmCrudProveedor = new JMenuItem("CRUD Proveedor\r\n");
		mntmCrudProveedor.addActionListener(this);
		mntmCrudProveedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Users.gif")));
		mnNewMenu_2.add(mntmCrudProveedor);

		mntmCrudVendedor = new JMenuItem("CRUD Empleado\r\n");
		mntmCrudVendedor.addActionListener(this);
		mntmCrudVendedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User group.gif")));
		mnNewMenu_2.add(mntmCrudVendedor);

		mntmCrudProducto = new JMenuItem("CRUD Producto\r\n");
		mntmCrudProducto.addActionListener(this);
		mntmCrudProducto.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Box.gif")));
		mnNewMenu_2.add(mntmCrudProducto);
		
		JMenu mnNewMenu_5 = new JMenu("Movimientos\r\n");
		mnNewMenu_5.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Payment.gif")));
		menuBar.add(mnNewMenu_5);
		
		mntmNewMenuItem = new JMenuItem("Venta");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Create.gif")));
		mnNewMenu_5.add(mntmNewMenuItem);

		JMenu mnNewMenu_3 = new JMenu("Consultas\r\n");
		mnNewMenu_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Search.gif")));
		menuBar.add(mnNewMenu_3);

		mntmConsultaCliente = new JMenuItem("Clientes");
		mntmConsultaCliente.addActionListener(this);
		mntmConsultaCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User.gif")));
		mnNewMenu_3.add(mntmConsultaCliente);

		mntmConsultaProductos = new JMenuItem("Productos");
		mntmConsultaProductos.addActionListener(this);
		mntmConsultaProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Box.gif")));
		mnNewMenu_3.add(mntmConsultaProductos);

		mntmConsultaProveedor = new JMenuItem("Proveedor\r\n");
		mntmConsultaProveedor.addActionListener(this);
		mntmConsultaProveedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Users.gif")));
		mnNewMenu_3.add(mntmConsultaProveedor);

		mntmConsultaEmpleado = new JMenuItem("Empleado");
		mntmConsultaEmpleado.addActionListener(this);
		mntmConsultaEmpleado.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User group.gif")));
		mnNewMenu_3.add(mntmConsultaEmpleado);

		JMenu mnNewMenu_4 = new JMenu("Reportes\r\n");
		mnNewMenu_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Database.gif")));
		menuBar.add(mnNewMenu_4);

		mntmReporteClientes = new JMenuItem("Clientes");
		mntmReporteClientes.addActionListener(this);
		mntmReporteClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/User.gif")));
		mnNewMenu_4.add(mntmReporteClientes);

		mntmReportesProductos = new JMenuItem("Productos");
		mntmReportesProductos.addActionListener(this);
		mntmReportesProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Box.gif")));
		mnNewMenu_4.add(mntmReportesProductos);

		mntmReporteBoletas = new JMenuItem("Boletas de Venta");
		mntmReporteBoletas.addActionListener(this);
		mntmReporteBoletas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/iconos/Notes.gif")));
		mnNewMenu_4.add(mntmReporteBoletas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/minimarket_tambito.png")));
		lblNewLabel.setBounds(318, 44, 713, 483);
		desktopPane.add(lblNewLabel);

		desktopPane.add(frmRC);
		desktopPane.add(frmRP);
		desktopPane.add(frmRV);
		desktopPane.add(frmRPR);
		desktopPane.add(frmCC);
		desktopPane.add(frmCP);
		desktopPane.add(frmCV);
		desktopPane.add(frmCPR);
		desktopPane.add(frmCCl);
		desktopPane.add(frmCPRO);
		desktopPane.add(frmCVE);
		desktopPane.add(frmCPROD);
		desktopPane.add(frmRCL);
		desktopPane.add(frmRPROD);
		desktopPane.add(frmRB);
		desktopPane.add(frmBV);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItemJMenuItem(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalirJMenuItem(e);
		}
		
		if (e.getSource() == mntmReporteBoletas) {
			actionPerformedMntmReporteBoletasJMenuItem(e);
		}
		if (e.getSource() == mntmReportesProductos) {
			actionPerformedMntmReportesProductosJMenuItem(e);
		}
		if (e.getSource() == mntmReporteClientes) {
			actionPerformedMntmReporteClientesJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaEmpleado) {
			actionPerformedMntmConsultaVendedorJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaProveedor) {
			actionPerformedMntmConsultaProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaProductos) {
			actionPerformedMntmConsultaProductosJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaCliente) {
			actionPerformedMntmConsultaClienteJMenuItem(e);
		}
		if (e.getSource() == mntmCrudProducto) {
			actionPerformedMntmCrudProductoJMenuItem(e);
		}
		if (e.getSource() == mntmCrudVendedor) {
			actionPerformedMntmCrudVendedorJMenuItem(e);
		}
		if (e.getSource() == mntmCrudProveedor) {
			actionPerformedMntmCrudProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmCrudCliente) {
			actionPerformedMntmCrudClienteJMenuItem(e);
		}
		if (e.getSource() == mntmRegistroProducto) {
			actionPerformedMntmRegistroProductoJMenuItem(e);
		}
		if (e.getSource() == mntmRegistroVendedor) {
			actionPerformedMntmRegistroVendedorJMenuItem(e);
		}
		if (e.getSource() == mntmRegistroProveedor) {
			actionPerformedMntmRegistroProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmRegistroCliente) {
			actionPerformedMntmRegistroClienteJMenuItem(e);
		}
	}

	protected void actionPerformedMntmRegistroClienteJMenuItem(ActionEvent e) {
		frmRC.setVisible(true);

	}

	protected void actionPerformedMntmRegistroProveedorJMenuItem(ActionEvent e) {
		frmRP.setVisible(true);
	}

	protected void actionPerformedMntmRegistroVendedorJMenuItem(ActionEvent e) {
		frmRV.setVisible(true);
	}

	protected void actionPerformedMntmRegistroProductoJMenuItem(ActionEvent e) {
		frmRPR.setVisible(true);
	}

	protected void actionPerformedMntmCrudClienteJMenuItem(ActionEvent e) {
		frmCC.setVisible(true);
	}

	protected void actionPerformedMntmCrudProveedorJMenuItem(ActionEvent e) {
		frmCP.setVisible(true);
	}


	protected void actionPerformedMntmCrudVendedorJMenuItem(ActionEvent e) {
		frmCV.setVisible(true);
	}

	protected void actionPerformedMntmCrudProductoJMenuItem(ActionEvent e) {
		frmCPR.setVisible(true);
	}

	protected void actionPerformedMntmConsultaClienteJMenuItem(ActionEvent e) {
		frmCCl.setVisible(true);
	}

	protected void actionPerformedMntmConsultaProductosJMenuItem(ActionEvent e) {
		frmCPROD.setVisible(true);
	}

	protected void actionPerformedMntmConsultaProveedorJMenuItem(ActionEvent e) {
		frmCPRO.setVisible(true);
	}

	protected void actionPerformedMntmConsultaVendedorJMenuItem(ActionEvent e) {
		frmCVE.setVisible(true);
	}

	protected void actionPerformedMntmReporteClientesJMenuItem(ActionEvent e) {
		frmRCL.setVisible(true);
	}

	protected void actionPerformedMntmReportesProductosJMenuItem(ActionEvent e) {
		frmRPROD.setVisible(true);
	}

	protected void actionPerformedMntmReporteBoletasJMenuItem(ActionEvent e) {
		frmRB.setVisible(true);
	}
	
	protected void actionPerformedMntmSalirJMenuItem(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedMntmNewMenuItemJMenuItem(ActionEvent e) {
		frmBV.setVisible(true);
	}
}
