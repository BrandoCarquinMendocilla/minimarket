package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

public class FrmConsultaProveedor extends JInternalFrame implements ActionListener {
	private JTextField txtFiltro;
	private JTable table;
	private JButton btnConsultar;
	int hoveredRow = -1, hoveredColumn = -1;
	private JTextField txtRuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProveedor frame = new FrmConsultaProveedor();
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
	public FrmConsultaProveedor() {
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta de Proveedor\r\n");
		setBounds(100, 100, 728, 318);
		getContentPane().setLayout(null);

		btnConsultar = new JButton("CONSULTAR\r\n");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnConsultar.setBounds(559, 40, 143, 23);
		getContentPane().add(btnConsultar);

		txtFiltro = new JTextField();
		txtFiltro.setBounds(157, 18, 204, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre de Proveedor\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 21, 137, 14);
		getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 692, 201);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "RUC", "Producto",
				"Direcci\u00F3n", "Correo", "Pa\u00EDs", "Tel\u00E9fono" }));

		// tamano de la fila
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
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
		scrollPane.setViewportView(table);
		
		JLabel lblRucDeProveedor = new JLabel("RUC de Proveedor\r\n");
		lblRucDeProveedor.setFont(new Font("Arial", Font.BOLD, 12));
		lblRucDeProveedor.setBounds(10, 46, 137, 14);
		getContentPane().add(lblRucDeProveedor);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(157, 43, 204, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultarJButton(e);
		}
	}

	protected void actionPerformedBtnConsultarJButton(ActionEvent e) {
		String filtro = txtFiltro.getText().trim();
		String ruc = txtRuc.getText().trim();

		// 1 Se limpia los datos del jtable
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		// 2 Se obtiene los campeonatos de la BD
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lista = model.listaProveedorPorNombreRuc(filtro , ruc);

		// 3 Se muestran los campeonatos en el JTABLE

		for (Proveedor x : lista) {
			Object[] fila = { x.getIdProveedor(), x.getNombre(), x.getRuc(), x.getProducto(), x.getDireccion(),
					x.getCorreo(), x.getPais(), x.getTelefono() };
			dtm.addRow(fila);
		}

	}
}
