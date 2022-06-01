package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Proveedor;
import util.MySqlDBConexion;

public class ProveedorModel {

	private static Logger log = Logger.getLogger(ProveedorModel.class.getName());

	// Registra Proveedor

	public int insertaProveedor(Proveedor obj) {

		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			// Se crea la conexion
			conn = MySqlDBConexion.getConexion();

			// Se prepara el sql

			String sql = "insert into proveedor value(null,?,?,?,?,?,?,?,curtime())";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getRuc());
			pstm.setString(3, obj.getProducto());
			pstm.setString(4, obj.getDireccion());
			pstm.setString(5, obj.getCorreo());
			pstm.setString(6, obj.getPais());
			pstm.setString(7, obj.getTelefono());

			log.info(">>> " + pstm);

			// 3 Ejecutamos a la base de datos
			// Retorna la cantidad de registrados en salida
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}
		log.info(">>> Fin >>> insertaProveedor");
		return salida;
	}

	// Elimina Proveedor

	public int EliminaProveedor(int idProveedor) {

		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			// Se crea la conexion
			conn = MySqlDBConexion.getConexion();

			// Se prepara el sql

			String sql = "delete from proveedor where idProveedor=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProveedor);

			log.info(">>> " + pstm);

			// 3 Ejecutamos a la base de datos

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}

		return salida;
	}

	// Actualiza Proveedor

	public int ActualizaProveedor(Proveedor pro) {

		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			// Se crea la conexion
			conn = MySqlDBConexion.getConexion();

			// Se prepara el sql

			String sql = "update proveedor set nombre=?, ruc=?, producto=?, direccion=?, correo=?, pais=?, telefono=? where idProveedor=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getNombre());
			pstm.setString(2, pro.getRuc());
			pstm.setString(3, pro.getProducto());
			pstm.setString(4, pro.getDireccion());
			pstm.setString(5, pro.getCorreo());
			pstm.setString(6, pro.getPais());
			pstm.setString(7, pro.getTelefono());
			pstm.setInt(8, pro.getIdProveedor());

			log.info(">>> " + pstm);

			// 3 Ejecutamos a la base de datos
			// Retorna la cantidad de registrados en salida
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

			}
		}

		return salida;
	}

	// Listar Proveedor

	public List<Proveedor> listaProveedor() {
		ArrayList<Proveedor> salida = new ArrayList<Proveedor>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Se crea la conexcion
			conn = MySqlDBConexion.getConexion();

			// Se prepara el sql
			String sql = "select * from proveedor";
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();
			Proveedor obj = null;
			while (rs.next()) {
				obj = new Proveedor();
				obj.setIdProveedor(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setProducto(rs.getString(4));
				obj.setDireccion(rs.getString(5));
				obj.setCorreo(rs.getString(6));
				obj.setPais(rs.getString(7));
				obj.setTelefono(rs.getString(8));
				salida.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}

	public List<Proveedor> listaProveedorPorNombre(String filtro) {
		ArrayList<Proveedor> salida = new ArrayList<Proveedor>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "select * from proveedor where nombre like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, filtro + "%");
			
			log.info(">>> " + psmt);
			
			rs = psmt.executeQuery();
			Proveedor obj = null;
			while(rs.next()) {
				obj = new Proveedor();
				obj.setIdProveedor(1);
				obj.setNombre(rs.getString(2));
				obj.setRuc(rs.getString(3));
				obj.setProducto(rs.getString(4));
				obj.setDireccion(rs.getString(5));
				obj.setCorreo(rs.getString(6));
				obj.setPais(rs.getString(7));
				obj.setTelefono(rs.getString(8));
				salida.add(obj);
				
			}
		} catch (Exception e) {
			e.printStackTrace();		
			}finally {
				try {
					if (rs != null) rs.close();
					if (psmt != null) psmt.close();
					if (conn != null) conn.close();
				} catch (Exception e2) {}
			}

		return salida;
	}

}
