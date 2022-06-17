package entidad;

import java.util.Date;

public class ReporteBoleta {
	private int idOrden;
	private String nombreProducto;
	private int cantidadPro;
	private double precioPro;
	private double subtotal;
	private double total;
	private String dni;
	private String nomCli;
	private String apeCli;
	private String  nomEmp;
	private String  apeEmp;
	public int getIdOrden() {
		return idOrden;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public int getCantidadPro() {
		return cantidadPro;
	}
	public double getPrecioPro() {
		return precioPro;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public double getTotal() {
		return total;
	}
	public String getDni() {
		return dni;
	}
	public String getNomCli() {
		return nomCli;
	}
	public String getApeCli() {
		return apeCli;
	}
	public String getNomEmp() {
		return nomEmp;
	}
	public String getApeEmp() {
		return apeEmp;
	}
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public void setCantidadPro(int cantidadPro) {
		this.cantidadPro = cantidadPro;
	}
	public void setPrecioPro(double precioPro) {
		this.precioPro = precioPro;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public void setApeCli(String apeCli) {
		this.apeCli = apeCli;
	}
	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}
	public void setApeEmp(String apeEmp) {
		this.apeEmp = apeEmp;
	}
	
	
	
}

