package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoEfectivo implements IPago {
	
	double montoPagado;
	LocalDate fechaPago;
	
	@Override
	public void realizarPago(double monto) {
		this.montoPagado = this.montoPagado - (this.montoPagado*(100/10));		
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: " + this.fechaPago);
		System.out.println("Monto de pago: " + this.montoPagado);
	}
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}
