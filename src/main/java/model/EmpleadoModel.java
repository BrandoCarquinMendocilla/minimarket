package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Cliente;
import entidad.Empleado;
import util.MySqlDBConexion;

public class EmpleadoModel {

	private static Logger Log = Logger.getLogger(EmpleadoModel.class.getName());

	public int RegistrarEmpleado(Empleado obj) {
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			
			//Se crea la conexi�n
			conn = MySqlDBConexion.getConexion();
			
			//Se prepara el sql server
			String sql = "insert into empleado value(null,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,obj.getNombre());
			pstm.setString(2,obj.getApellido());
			pstm.setString(3,obj.getDni());
			pstm.setString(4,obj.getTelefono());
			pstm.setString(5,obj.getCorreo());
			pstm.setString(6,obj.getCategoria());
			
			Log.info(">>>"+pstm);
			
			salida= pstm.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) 
					pstm.close();
				if (conn!=null) 
					conn.close();	
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	
	
	public List<Empleado> ListarEmpleado(){
		ArrayList<Empleado> salida = new ArrayList<Empleado>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
		try {
			
			//Se crea la conexi�n
			conn  = MySqlDBConexion.getConexion();
			
			//Se prepara el sql server
			String sql ="select * from Empleado";
			pstm =conn.prepareStatement(sql);
			
			rs  =pstm.executeQuery();
			Empleado obj = null;
			while(rs.next()) {
				obj = new Empleado();
				obj.setIdEmpleado(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setDni(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setCorreo(rs.getString(6));
				obj.setCategoria(rs.getString(7));
				salida.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if (pstm !=null) {
					pstm.close();
				}
			} catch (Exception e2) {
			}
		}
		return salida;
	}
	
	
	public int ActualizarEmpleado(Empleado obj) {
		Logger Log = Logger.getLogger(EmpleadoModel.class.getName());
		
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			//Se crea la conexi�n
			conn = MySqlDBConexion.getConexion();

			//Se prepara el sql server
			String sql = "update Empleado set nombre=?, apellido=?, dni=?, telefono=?, correo=?, categoria=? where idEmpleado=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getDni());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getCorreo());
			pstm.setString(6, obj.getCategoria());
			pstm.setInt(7, obj.getIdEmpleado());

			Log.info(">>> " + pstm);

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
	
	
	public int EliminarEmpleado(int idEmpleado) {
		Logger Log = Logger.getLogger(EmpleadoModel.class.getName());
		
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			//Se crea la conexi�n
			conn = MySqlDBConexion.getConexion();

			//Se prepara el sql server
			String sql = "delete from Empleado where idEmpleado=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idEmpleado);

			Log.info(">>> " + pstm);

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
	
	public static int findByNombre(String nombreBuscar, String nombreTabla,String nombreColumna) {
		int codigo=-1;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql="select * from "+nombreTabla +" where "+nombreColumna+" = '"+nombreBuscar+"'";
			
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			
			if(rs.next()) {
				codigo=rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de fallo");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return codigo;
	}
	
	public List<Empleado> ConsultaPorNombreDNI(String nombre , String dni){
		ArrayList<Empleado> salida = new ArrayList<Empleado>();
		
		Connection conn= null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		try {
			// PASO 1 : CREAR LA CONEXION
			conn = MySqlDBConexion.getConexion();
			
			// PASO 2 : SE PREPARA EL SQL
			String sql = "SELECT * FROM usuario "
					+ "where  (nombre like ?) and ( ? = '' or dni = ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+nombre+"%");
			pstm.setString(2, dni);
			pstm.setString(3, dni);
			
			// PASO 3 : EJECUTAMOS A LA BASE DE DATOS
			rs = pstm.executeQuery();
			Empleado obj = null;
			while(rs.next()) {
				obj = new Empleado();
				obj.setIdEmpleado(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setDni(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setCorreo(rs.getString(6));
				obj.setCategoria(rs.getString(7));
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
			} catch (Exception e2) {}
		}
		return salida;
	}
	
}
