package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class FrmRegistroVendedor extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroVendedor frame = new FrmRegistroVendedor();
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
	public FrmRegistroVendedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Vendedor");
		setBounds(100, 100, 450, 300);

	}

}
