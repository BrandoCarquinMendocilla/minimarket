package gui;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import model.ClienteModel;
import util.Validaciones;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmCrudCliente extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JTextField txtNOMBRE;
	private JTextField txtAPELLIDO;
	private JTextField txtDNI;
	private JTextField txtTELEF;
	private JTextField txtDIREC;
	private JScrollPane scrollPane;
	private JComboBox<String> cboPAIS;
	private JTable table;
	int idSeleccionado =-1;
	int hoveredRow = -1, hoveredColumn = -1;
	private JButton btnREGISTRAR_1;
	private JButton btnACTUALIZAR_1;
	private JButton btnELIMINAR_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudCliente frame = new FrmCrudCliente();
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
	public FrmCrudCliente() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("CRUD de Cliente");
		setBounds(100, 100, 705, 443);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(26, 22, 272, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 73, 81, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtNOMBRE = new JTextField();
		txtNOMBRE.addKeyListener(this);
		txtNOMBRE.setBounds(91, 97, 120, 19);
		getContentPane().add(txtNOMBRE);
		txtNOMBRE.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 96, 81, 19);
		getContentPane().add(lblNewLabel_2);
		
		txtAPELLIDO = new JTextField();
		txtAPELLIDO.addKeyListener(this);
		txtAPELLIDO.setColumns(10);
		txtAPELLIDO.setBounds(91, 125, 120, 20);
		getContentPane().add(txtAPELLIDO);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 125, 81, 19);
		getContentPane().add(lblNewLabel_3);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(91, 71, 120, 19);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(233, 70, 81, 19);
		getContentPane().add(lblNewLabel_4);
		
		txtTELEF = new JTextField();
		txtTELEF.addKeyListener(this);
		txtTELEF.setBounds(304, 71, 120, 19);
		getContentPane().add(txtTELEF);
		txtTELEF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(233, 99, 120, 13);
		getContentPane().add(lblNewLabel_5);
		
		txtDIREC = new JTextField();
		txtDIREC.addKeyListener(this);
		txtDIREC.setBounds(304, 97, 120, 19);
		getContentPane().add(txtDIREC);
		txtDIREC.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pa\u00EDs :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(233, 127, 81, 13);
		getContentPane().add(lblNewLabel_6);
		
		cboPAIS = new JComboBox<String>();
		cboPAIS.addItem("Seleccionar");
		cboPAIS.addItem("Perú");
		cboPAIS.addItem("Colombia");
		cboPAIS.addItem("Argentina");
		cboPAIS.addItem("Bolivia");
		cboPAIS.addItem("Chile");
		cboPAIS.addItem("Uruguay");
		cboPAIS.addItem("Venezuela");
		cboPAIS.addItem("Brasil");
		cboPAIS.addItem("Paraguay");
		cboPAIS.addItem("España");
		cboPAIS.setBounds(304, 124, 120, 21);
		getContentPane().add(cboPAIS);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 673, 184);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DNI", "Nombre", "Apellido", "Tel\u00E9fono", "Direcci\u00F3n", "Pa\u00EDs"
			}
		));
		//tamano de la fila	
				table.getColumnModel().getColumn(0).setPreferredWidth(17);
		scrollPane.setViewportView(table);
		
		btnREGISTRAR_1 = new JButton("REGISTRAR");
		btnREGISTRAR_1.addActionListener(this);
		btnREGISTRAR_1.setIcon(new ImageIcon(FrmCrudCliente.class.getResource("/iconos/Add.gif")));
		btnREGISTRAR_1.setFont(new Font("Arial", Font.BOLD, 22));
		btnREGISTRAR_1.setBounds(26, 173, 193, 35);
		getContentPane().add(btnREGISTRAR_1);
		
		btnACTUALIZAR_1 = new JButton("ACTUALIZAR");
		btnACTUALIZAR_1.addActionListener(this);
		btnACTUALIZAR_1.setIcon(new ImageIcon(FrmCrudCliente.class.getResource("/iconos/Gear.gif")));
		btnACTUALIZAR_1.setFont(new Font("Arial", Font.BOLD, 22));
		btnACTUALIZAR_1.setBounds(242, 173, 205, 35);
		getContentPane().add(btnACTUALIZAR_1);
		
		btnELIMINAR_1 = new JButton("ELIMINAR");
		btnELIMINAR_1.addActionListener(this);
		btnELIMINAR_1.setIcon(new ImageIcon(FrmCrudCliente.class.getResource("/iconos/Delete.gif")));
		btnELIMINAR_1.setFont(new Font("Arial", Font.BOLD, 22));
		btnELIMINAR_1.setBounds(477, 173, 193, 35);
		getContentPane().add(btnELIMINAR_1);
		
		//alineación
				DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
				rightRenderer.setHorizontalAlignment(JLabel.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
				table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);

		//selecciona una sola fila
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
        //desabilita mover las columnas
		table.getTableHeader().setReorderingAllowed(false);
		
		//color de la fila seleccionada
		table.setSelectionBackground(Color.BLUE);
		
		//No se pueda editar
	    table.setDefaultEditor(Object.class, null);
	    
		//Efecto Rollover
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
	    //mostrando la tabla
	    lista();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnELIMINAR_1) {
			do_btnELIMINAR_actionPerformed(e);
		}
		if (e.getSource() == btnACTUALIZAR_1) {
			do_btnACTUALIZAR_actionPerformed(e);
		}
		if (e.getSource() == btnREGISTRAR_1) {
			do_btnREGISTRAR_actionPerformed(e);
		}
	}
	protected void do_btnREGISTRAR_actionPerformed(ActionEvent e) {
		inserta();
	}
	protected void do_btnACTUALIZAR_actionPerformed(ActionEvent e) {
		actualiza();
	}
	protected void do_btnELIMINAR_actionPerformed(ActionEvent e) {
		elimina();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		busca();
	}
	void limpiarCajasTexto() {
		txtNOMBRE.setText("");
		txtAPELLIDO.setText("");
		txtDNI.setText("");
		txtTELEF.setText("");
		txtDIREC.setText("");
		txtNOMBRE.requestFocus();
	}
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	private void lista() {
		ClienteModel model = new ClienteModel();
		List<Cliente> lista = model.listaCliente();

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		Object[] fila = null;
		for (Cliente x : lista) {
			fila = new Object[] { x.getIdCliente(), 
					x.getDni(),
					x.getNombre(), 
					x.getApellido(),
					x.getTelefono(),
					x.getDireccion(),
					x.getPais()};
			dtm.addRow(fila);
		}
	}
	private void inserta() {
		String nom = txtNOMBRE.getText();
		String ape = txtAPELLIDO.getText();
		String dni = txtDNI.getText();
		String tel = txtTELEF.getText();
		String dir = txtDIREC.getText();
		String pai = cboPAIS.getSelectedItem().toString();


		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		} else if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 8 digitos");
		}else if (!tel.matches(Validaciones.TELEFONO)) {
				mensaje("El numero de teléfono es de 9 digitos");
		} else if (!dir.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección es de 2 a 20 caracteres");
		} else if (cboPAIS.getSelectedIndex() == 0) {
			mensaje("Seleccione el país");
		} else {
			Cliente cli = new Cliente();
			cli.setDni(dni);
			cli.setNombre(nom);
			cli.setApellido(ape);
			cli.setTelefono(tel);
			cli.setDireccion(dir);
			cli.setPais(pai);
			

			ClienteModel model = new ClienteModel();
			int salida = model.registrarCliente(cli);

			if (salida > 0) {
				lista();
				limpiarCajasTexto();
				mensaje("Cliente Registrado con exito");

			} else {
				mensaje("Corriga los datos  ingresados");
			}
		}
	}
	private void busca() {
		int fila = table .getSelectedRow();
		idSeleccionado = (Integer)table.getValueAt(fila,0);
		 String nombre = (String)table.getValueAt(fila, 2);
		 String apellido = (String)table.getValueAt(fila, 3);
		 String dni = (String)table.getValueAt(fila, 1);
		 String telefono = (String)table.getValueAt(fila, 4);
		 String direccion = (String)table.getValueAt(fila, 5);
		 String pais = (String)table.getValueAt(fila, 6);

		 
		 System.out.println(idSeleccionado + "-" + nombre + "-" + apellido + "-" + dni + "-" + telefono +
				
				 "-" + direccion + "-" + pais );
		 
		 txtDNI.setText(dni);
		 txtNOMBRE.setText(nombre);
		 txtAPELLIDO.setText(apellido);
		 txtTELEF.setText(telefono);
		 txtDIREC.setText(direccion);
		 cboPAIS.setSelectedItem(pais);

		 }
	private void elimina() {
		if(idSeleccionado==-1) {
			mensaje("Seleccione un fila para eliminar");
		}else {
			ClienteModel model = new ClienteModel();
			int salida = model.eliminacliente(idSeleccionado);

			if (salida > 0) {
				lista();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se eliminó correctamente");
			} else {
				mensaje("Error en la eliminación");
			}
		}
	}
	private void actualiza() {
		String dni = txtDNI.getText();
		String nom = txtNOMBRE.getText();
		String ape = txtAPELLIDO.getText();
		String tel = txtTELEF.getText();
		String dir = txtDIREC.getText();
		String pai = cboPAIS.getSelectedItem().toString();

		
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		} else if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		} else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 8 digitos");
		}else if (!tel.matches(Validaciones.TELEFONO)) {
				mensaje("El numero de teléfono es de 9 digitos");
		} else if (!dir.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección es de 2 a 20 caracteres");
		} else if (cboPAIS.getSelectedIndex() == 0) {
			mensaje("Seleccione el país");
		}  else {
			Cliente cli = new Cliente();
			cli.setIdCliente(idSeleccionado);
			cli.setDni(dni);
			cli.setNombre(nom);
			cli.setApellido(ape);
			cli.setTelefono(tel);
			cli.setDireccion(dir);
			cli.setPais(pai);
			

			ClienteModel model = new ClienteModel();
			int salida = model.actualizacliente(cli);

			if (salida > 0) {
				lista();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Cliente Actualizado con exito");

			} else {
				mensaje("Error en la actualización");
			}
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDIREC) {
			do_txtDIREC_keyTyped(e);
		}
		if (e.getSource() == txtTELEF) {
			do_txtTELEF_keyTyped(e);
		}
		if (e.getSource() == txtDNI) {
			do_txtDNI_keyTyped(e);
		}
		if (e.getSource() == txtAPELLIDO) {
			do_txtAPELLIDO_keyTyped(e);
		}
		if (e.getSource() == txtNOMBRE) {
			do_txtNOMBRE_keyTyped(e);
		}
	}
	protected void do_txtNOMBRE_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String nom = txtNOMBRE.getText() + e.getKeyChar();
		if (nom.length() > 20) {
			e.consume();
		}
	}
	protected void do_txtAPELLIDO_keyTyped(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String ape = txtAPELLIDO.getText() + e.getKeyChar();
		if (ape.length() > 20) {
			e.consume();
		}
	}
	protected void do_txtDNI_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtDNI.getText() + e.getKeyChar();
		if (dni.length() > 8) {
			e.consume();
		}
	}
	protected void do_txtTELEF_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String dni = txtTELEF.getText() + e.getKeyChar();
		if (dni.length() > 9) {
			e.consume();
		}
	}
	protected void do_txtDIREC_keyTyped(KeyEvent e) {
		String dir = txtDIREC.getText() + e.getKeyChar();
		if (dir.length() > 20) {
			e.consume();
		}
	}
}
