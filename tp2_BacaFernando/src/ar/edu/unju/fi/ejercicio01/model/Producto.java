package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	
	private String codigo;
	private String descripcion;
	private Double precioUnitario;
	private origenFabricacion origenFabricacion;
	private categoria categoria;

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion, Double precioUnitario,
			ar.edu.unju.fi.ejercicio01.model.Producto.origenFabricacion origenFabricacion,
			ar.edu.unju.fi.ejercicio01.model.Producto.categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public origenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(origenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	public enum origenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUAGUAY;
	}
	
	public enum categoria {
		TELEFONIA, INMFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}

}
