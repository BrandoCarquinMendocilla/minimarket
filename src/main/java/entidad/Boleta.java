package entidad;

import java.util.Date;

public class Boleta {
	private int idOrden;
	private int idCliente;
	private int idEmpleado;
	private Date fechaActual;
	private double total;

	
	
	public Date getFechaActual() {
		return fechaActual;
	}
	public double getTotal() {
		return total;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdOrden() {
		return idOrden;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
	
	
}
