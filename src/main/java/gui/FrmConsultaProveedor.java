package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

public class FrmConsultaProveedor extends JInternalFrame implements ActionListener {
	private JTextField txtFiltro;
	private JTable table;
	private JButton btnConsultar;

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
		setBounds(100, 100, 618, 340);
		getContentPane().setLayout(null);

		btnConsultar = new JButton("CONSULTAR\r\n");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnConsultar.setBounds(403, 34, 143, 23);
		getContentPane().add(btnConsultar);

		txtFiltro = new JTextField();
		txtFiltro.setBounds(168, 37, 204, 20);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre de Proveedor\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 40, 137, 14);
		getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 582, 201);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nombre", "RUC", "Producto",
				"Direcci\u00F3n", "Correo", "Pa\u00EDs", "Tel\u00E9fono" }));
		scrollPane.setViewportView(table);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultarJButton(e);
		}
	}

	protected void actionPerformedBtnConsultarJButton(ActionEvent e) {
		String filtro = txtFiltro.getText().trim();

		// 1 Se limpia los datos del jtable
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		// 2 Se obtiene los campeonatos de la BD
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lista = model.listaProveedorPorNombre(filtro);
		
		//3 Se muestran los campeonatos en el JTABLE
		
		for(Proveedor x: lista) {
			Object[] fila = { x.getIdProveedor(),x.getNombre(),x.getRuc(),x.getProducto(),x.getDireccion(),
					x.getCorreo(),x.getPais(),x.getTelefono()};
			dtm.addRow(fila);
		}

	}
}
