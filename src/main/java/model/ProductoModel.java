package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Producto;
import util.MySqlDBConexion;

public class ProductoModel {
	public int ingresarProducto(Producto producto) {
		int salida = -1;

		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			conexion = MySqlDBConexion.getConexion();

			String sql = "insert into producto values(null,?,?,curtime(),?,?,?,?)";
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getCategoria());
			pstm.setDouble(3, producto.getPrecio());
			pstm.setInt(4, producto.getStock());
			pstm.setString(5, producto.getPeso());
			pstm.setString(6, producto.getCantidadPeso());

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}

	// Llamar a los productos
	public List<Producto> listarProducto() {
		ArrayList<Producto> salida = new ArrayList<Producto>();
		Connection conexion = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			conexion = MySqlDBConexion.getConexion();

			String sql = "select * from producto";
			pstm = conexion.prepareStatement(sql);

			rs = pstm.executeQuery();
			Producto obj = null;
			while (rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setCategoria(rs.getInt(3));
				obj.setPrecio(rs.getDouble(5));
				obj.setStock(rs.getInt(6));
				obj.setPeso(rs.getString(7));
				obj.setCantidadPeso(rs.getString(8));
				salida.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (conexion != null) {
					conexion.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return salida;
	}

	public int eliminarProducto(int idProducto) {
		int salida = -1;

		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			conexion = MySqlDBConexion.getConexion();

			String sql = "update producto set stock=0 where idProducto=?";
			pstm = conexion.prepareStatement(sql);
			pstm.setInt(1, idProducto);

			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}

	public int actualizararProducto(Producto producto) {
		int salida = -1;

		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			conexion = MySqlDBConexion.getConexion();

			String sql = "update producto set nombre=?,categoria=?,precio=?,stock=?,peso=?,cantidadPeso=? where idProducto=?";
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getCategoria());
			pstm.setDouble(3, producto.getPrecio());
			pstm.setInt(4, producto.getStock());
			pstm.setString(5, producto.getPeso());
			pstm.setString(6, producto.getCantidadPeso());
			pstm.setInt(7, producto.getIdProducto());

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}

	// Llamamos al indice de cada categoria de producto seleccionado
	public static int findByNombre(String nombreBuscar, String nombreTabla, String nombreColumna) {
		int codigo = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from " + nombreTabla + " where " + nombreColumna + " = '" + nombreBuscar + "'";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			if (rs.next()) {
				codigo = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de fallo");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {

			}
		}

		return codigo;
	}

	public static double findByPrecio(String nombreBuscar, String nombreTabla, String nombreColumna) {
		double codigo = -1.0;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from " + nombreTabla + " where " + nombreColumna + " = '" + nombreBuscar + "'";

			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			if (rs.next()) {
				codigo = rs.getDouble(5);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de fallo");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return codigo;
	}

	// Buscar
	public static void buscar(String nombre, JTable tblProductos) {
		DefaultTableModel ModeloTabla;

		String[] columnas = { "Id", "Nombre", "Categoria", "Precio", "Stock", "Peso", "Cant. Peso" };
		String[] registro = new String[7];
		ModeloTabla = new DefaultTableModel(null, columnas);
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from producto where nombre like '%" + nombre + "%'";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				registro[0] = rs.getString("idProducto");
				registro[1] = rs.getString("nombre");
				registro[2] = rs.getString("categoria");
				registro[3] = rs.getString("precio");
				registro[4] = rs.getString("stock");
				registro[5] = rs.getString("peso");
				registro[6] = rs.getString("cantidadPeso");

				ModeloTabla.addRow(registro);
			}

			tblProductos.setModel(ModeloTabla);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public List<Producto> listaProducto() {
		ArrayList<Producto> data = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; // Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select *" + "from producto  ";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);
			rs = pstm.executeQuery();

			Producto p = null;

			while (rs.next()) {
				p = new Producto();
				p.setIdProducto(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));

				data.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
