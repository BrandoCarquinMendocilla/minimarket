package entidad;

import java.util.Date;

public class Boleta {
	private int idOrden;
	private int idCliente;
	private int idEmpleado;
	private Date fechaActual;
	private double total;
	private Cliente cliente;
	private String clienteNombre;
	private Empleado empleado;
	private String empleadoNombre;

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getClienteNombre() {
		clienteNombre = cliente.getNombre();
		return clienteNombre;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public String getEmpleadoNombre() {
		empleadoNombre = empleado.getNombre();
		return empleadoNombre;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
