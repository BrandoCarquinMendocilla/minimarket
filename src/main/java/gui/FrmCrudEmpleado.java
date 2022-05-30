package gui;
//Michael

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;

public class FrmCrudVendedor extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudVendedor frame = new FrmCrudVendedor();
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
	public FrmCrudVendedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("CRUD de Vendedor");
		setBounds(100, 100, 450, 300);

	}

}
