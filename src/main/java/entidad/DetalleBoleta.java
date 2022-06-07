package entidad;

public class DetalleBoleta {
	private int idOrden;
	private int idProducto;
	private int cantidad;
	private double subtotal;
	private String nombreProducto;
	
	
	
	
	
	
	public int getIdOrden() {
		return idOrden;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
