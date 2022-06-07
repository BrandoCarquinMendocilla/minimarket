package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidad.Boleta;
import entidad.DetalleBoleta;
import entidad.Producto;
import util.MySqlDBConexion;

public class BoletaModel {
	//Ingresar Orden de compra 
	public int ingresarOrdenCompra(Boleta boleta) {
		int salida= -1;
		
		Connection conexion= null;
		PreparedStatement pstm =null;
		try {
			conexion = MySqlDBConexion.getConexion();
			
			String  sql = "insert into orden_compra values(null,?,?,curtime(),?)";
			pstm = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1,boleta.getIdCliente());
			pstm.setInt(2,boleta.getIdEmpleado());
			pstm.setDouble(3,boleta.getTotal());
				
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
			    salida = rs.getInt(1);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conexion!=null) {
						conexion.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return salida;
	}
	//Ingresar Detalle de Orden
	public int ingresarDetalleOrden(DetalleBoleta boleta) {
		int salida= -1;
		
		Connection conexion= null;
		PreparedStatement pstm =null;
		try {
			conexion = MySqlDBConexion.getConexion();
			
			String  sql = "insert into orden_detalle values(?,?,?,?)";	
			pstm = conexion.prepareStatement(sql);
			pstm.setInt(1,boleta.getIdOrden());
			pstm.setInt(2,boleta.getIdProducto());
			pstm.setInt(3,boleta.getCantidad());
			pstm.setDouble(4,boleta.getSubtotal());
				
			salida = pstm.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conexion!=null) {
						conexion.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return salida;
	}
	
	public List<DetalleBoleta> listaDetalleOrden(){
		ArrayList<DetalleBoleta> salida = new ArrayList<DetalleBoleta>();
		Connection conexion= null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		try {
			
			conexion  = MySqlDBConexion.getConexion();
			
			String sql ="select * from orden_detalle";
			pstm =conexion.prepareStatement(sql);
			
			rs  =pstm.executeQuery();
			DetalleBoleta obj = null;
			while(rs.next()) {
				obj = new DetalleBoleta();
				obj.setIdProducto(rs.getInt(1));
				obj.setCantidad(rs.getInt(2));
				obj.setSubtotal(rs.getDouble(2));
				salida.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(conexion!=null) {
					conexion.close();
				}
				if (pstm !=null) {
					pstm.close();
				}
					
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		  
		return salida;
	}
	
}
