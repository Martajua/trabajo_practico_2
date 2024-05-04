package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoEfectivo implements IPago {

	private double montoPagado;
	private LocalDate fechaPago;

	public PagoEfectivo() {
		super();
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
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

	@Override
	public double realizarPago(double monto) {
		return montoPagado-=(montoPagado*10)/100;
	}

	@Override
	public void imprimirRecibo() {
		montoPagado = realizarPago(montoPagado);

		double montoRedondeado = Math.round(montoPagado*100.0)/100.0;
		String montoFormateado = String.format("%.2f", montoRedondeado);
		
		System.out.println("Fecha de pago: "+fechaPago);
		System.out.println("Monto pagado: "+montoFormateado);
	}

}
