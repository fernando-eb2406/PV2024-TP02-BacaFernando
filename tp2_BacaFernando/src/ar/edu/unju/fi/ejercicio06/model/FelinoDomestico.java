package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {
	
	private String nombre;
	private Byte Edad;
	private Float Peso;
	
	public FelinoDomestico() {
		// TODO Auto-generated constructor stub
	}

	public FelinoDomestico(String nombre, Byte edad, Float peso) {
		this.nombre = nombre;
		Edad = edad;
		Peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoDomestico [nombre=" + nombre + ", Edad=" + Edad + ", Peso=" + Peso + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Byte getEdad() {
		return Edad;
	}

	public void setEdad(Byte edad) {
		Edad = edad;
	}

	public Float getPeso() {
		return Peso;
	}

	public void setPeso(Float peso) {
		Peso = peso;
	}

}
