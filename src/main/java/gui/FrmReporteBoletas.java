package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import entidad.Boleta;
import model.BoletaModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

public class FrmReporteBoletas extends JInternalFrame implements  ActionListener {
	
		private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteBoletas frame = new FrmReporteBoletas();
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
	public FrmReporteBoletas() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Reporte de Boleta de Ventas\r\n");
		setBounds(100, 100, 741, 523);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes de Boletas de Venta \r\n");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel.setBounds(136, 11, 465, 30);
		getContentPane().add(lblNewLabel);
		
		JScrollPane PanelReporte = new JScrollPane();
		PanelReporte.setBounds(10, 110, 705, 372);
		getContentPane().add(PanelReporte);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		PanelReporte.setViewportView(panel);
		panel.setLayout(new BorderLayout());
		
		btnConsultar = new JButton("CONSULTAR\r\n");
		btnConsultar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(10, 62, 705, 23);
		getContentPane().add(btnConsultar);

	}
	
	
		private JButton btnConsultar;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		
		BoletaModel model = new BoletaModel();
		List<Boleta> data = model.listaBoleta();

		// 1 La data
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

		// 2 El diseño del reporte
		String file = "ReporteBoleta.jasper";

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
