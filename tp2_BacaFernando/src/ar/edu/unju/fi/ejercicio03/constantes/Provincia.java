package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	
	JUJUY(718971, 53.219), SALTA(1441351, 155.488), TUCUMAN(1703186, 22.525), CATAMARCA(429562, 102.602), LA_RIOJA(362605, 89.680), SANTIAGO_DEL_ESTERO(1060906, 136.351);
	
	private Integer poblacion;
	private Double superficie;

	private Provincia(Integer poblacion, Double superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional() {
		double densidad;
		densidad = (double)this.poblacion/superficie;
		return densidad;
	}

}
