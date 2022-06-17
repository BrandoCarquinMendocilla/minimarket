package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidad.Boleta;
import entidad.Cliente;
import entidad.DetalleBoleta;
import entidad.Empleado;
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
	
	
	//Buscar Boleta
	public List<Boleta> buscarAlumno(Integer codigo) {
		ArrayList<Boleta> salida = new ArrayList<Boleta>();
		
		Connection conn= null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		try {
			//Se crea la conexcion
			conn = MySqlDBConexion.getConexion();
			
			//Se prepara el sql
			String sql = "select "
					+ "	o.idOrden,"
					+ "    c.nombre, "
					+ "    e.nombre , "
					+ "    p.nombre , "
					+ "    d.cantidad ,"
					+ "    p.precio , "
					+ "    o.total "
					+ "from orden_compra o  "
					+ "inner join orden_detalle d on o.idOrden=d.idOrden "
					+ "inner join producto p on d.idProducto=p.idProducto "
					+ "inner join cliente c on o.idCliente=c.idCliente "
					+ "inner join empleado e on o.idEmpleado=e.idEmpleado "
					+ "where o.idOrden==?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,codigo);
			
			System.out.println("SQL ---> "+pstm);
			
			rs = pstm.executeQuery();
		
			Boleta obj = null;
			while(rs.next()) {
				obj= new Boleta();
				obj.setIdOrden(rs.getInt("idOrden"));
				obj.setIdCliente(rs.getInt("idCliente"));
				obj.setIdEmpleado(rs.getInt("idEmpleado"));
				obj.setFechaActual(rs.getDate("fechaActual"));
				obj.setTotal(rs.getDouble("total"));
			
				salida.add(obj);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) 
					pstm.close();
				if (conn!=null) 
					conn.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}
	
	public List<Boleta> consultaBoleta(String idCliente){
		ArrayList<Boleta> data = new ArrayList<Boleta>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select co.idOrden,cl.Nombre,e.Nombre,co.ordenFecha,co.total from orden_compra co inner join cliente cl on co.idCliente  inner join"
					+ "empleado e on co.idEmpleado= e.idEmpleado where co.idCliente = ?";  
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idCliente);
			System.out.println("SQL-->" + pstm);
			rs = pstm.executeQuery();
			
			Boleta c = null;
			Cliente g = null;
			Empleado e = null;
			while(rs.next()){
				c = new Boleta();
				c.setIdOrden(rs.getInt(1));
				c.setFechaActual(rs.getDate(4));;
				c.setTotal(rs.getDouble(5));
				
				g = new Cliente();
				g.setNombre(rs.getString(2));
				
				e = new Empleado();
				e.setNombre(rs.getString(3));
				
				
				c.setCliente(g);
				c.setEmpleado(e);
				data.add(c);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public List<Boleta> listaBoleta(){
		ArrayList<Boleta> data = new ArrayList<Boleta>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select co.*,cl.Nombre,e.Nombre from orden_compra co inner join cliente cl on co.idCliente  inner join"
					+ " empleado e on co.idEmpleado= e.idEmpleado ";  
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);
			rs = pstm.executeQuery();
			
			Boleta c = null;
			Cliente g = null;
			Empleado e = null;
			while(rs.next()){
				c = new Boleta();
				c.setIdOrden(rs.getInt(1));
				c.setFechaActual(rs.getDate(4));;
				c.setTotal(rs.getDouble(5));
				
				g = new Cliente();
				g.setIdCliente(rs.getInt(2));
				g.setNombre(rs.getString(6));
				
				e = new Empleado();
				e.setIdEmpleado(rs.getInt(3));
				e.setNombre(rs.getString(7));
				
				
				c.setCliente(g);
				c.setEmpleado(e);
				data.add(c);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
