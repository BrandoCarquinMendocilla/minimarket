package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class FrmConsultaVendedor extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaVendedor frame = new FrmConsultaVendedor();
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
	public FrmConsultaVendedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta de Vendedor\r\n");
		setBounds(100, 100, 450, 300);

	}

}
