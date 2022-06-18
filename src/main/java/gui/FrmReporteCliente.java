package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FrmReporteCliente extends JInternalFrame implements ActionListener {
	private JButton btnCONSULTAR;
	private JPanel panel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteCliente frame = new FrmReporteCliente();
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
	public FrmReporteCliente() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Reporte de Clientes");
		setBounds(100, 100, 886, 636);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Clientes");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(303, 22, 421, 52);
		getContentPane().add(lblNewLabel);
		
		btnCONSULTAR = new JButton("CONSULTAR");
		btnCONSULTAR.addActionListener(this);
		btnCONSULTAR.setFont(new Font("Arial", Font.ITALIC, 20));
		btnCONSULTAR.setBounds(10, 173, 854, 31);
		getContentPane().add(btnCONSULTAR);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reportes Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 214, 854, 383);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout());

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCONSULTAR) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		
		ClienteModel model =new ClienteModel();
		List<Cliente>lstCliente= model.listaCliente();
		
		JRBeanCollectionDataSource dataSource = new  JRBeanCollectionDataSource(lstCliente);
		String jasper= "ReporteCliente.jasper";
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		JRViewer jRViewer = new JRViewer(print);
		
		panel.removeAll();
		panel.add(jRViewer);
		panel.repaint();
		panel.revalidate();
	}
}
