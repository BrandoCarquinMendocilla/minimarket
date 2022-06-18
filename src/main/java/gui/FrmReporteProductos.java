package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Boleta;
import entidad.Producto;
import model.BoletaModel;
import model.ProductoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmReporteProductos extends JInternalFrame implements ActionListener {
	private JButton btnConsular;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteProductos frame = new FrmReporteProductos();
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
	public FrmReporteProductos() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Reporte de Productos\r\n");
		setBounds(100, 100, 774, 403);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Productos\r\n");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(240, 15, 314, 32);
		getContentPane().add(lblNewLabel);
		
		btnConsular = new JButton("CONSULTAR\r\n");
		btnConsular.addActionListener(this);
		btnConsular.setFont(new Font("Arial", Font.BOLD, 18));
		btnConsular.setBounds(10, 58, 738, 23);
		getContentPane().add(btnConsular);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 738, 266);
		getContentPane().add(scrollPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout());

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsular) {
			actionPerformedBtnConsularJButton(e);
		}
	}
	protected void actionPerformedBtnConsularJButton(ActionEvent e) {
		

		ProductoModel model = new ProductoModel();
		List<Producto> data = model.listaProducto();

		// 1 La data
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

		// 2 El diseño del reporte
		String file = "ReporteProducto.jasper";

		// 3 Se genera el reporte
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);

		// 4 Se muestra en el visor
		JRViewer jRViewer = new JRViewer(jasperPrint);

		// 5 Se añade el visor al panel
		panel.removeAll();
		panel.add(jRViewer);
		panel.repaint();
		panel.revalidate();
	}
}
