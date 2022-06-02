package entidad;

public class Producto {
	private int idProducto ;
	private String nombre;
	private int categoria;
	private String precio;
	private String stock;
	private String peso;
	private String cantidadPeso;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getCantidadPeso() {
		return cantidadPeso;
	}
	public void setCantidadPeso(String cantidadPeso) {
		this.cantidadPeso = cantidadPeso;
	}


	
}
