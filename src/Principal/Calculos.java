package Principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calculos {

	private double monedaAPI;
	private String monedaBase;
	private String monedaCotizada;
	private double convercionMoneda;
	private String rutaArchivo = "misMonedas.txt";
	LocalDateTime fechaHoraAvtual = LocalDateTime.now();


	DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String fechaHoraFormateada = fechaHoraAvtual.format(formato);


	public Calculos( String monedaBase ,String monedaCotizada, double convercionMoneda) {
		this.monedaBase = monedaBase;
		this.monedaCotizada = monedaCotizada;
		this.convercionMoneda = convercionMoneda;
	}

	public Calculos (Monedas misMonedas){
		this.monedaBase = misMonedas.base_code();
		this.monedaCotizada = misMonedas.target_code();
		this.monedaAPI = misMonedas.conversion_rate();
	}

	public double calculoMoneda(double miMoneda){
		return miMoneda * monedaAPI;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}


	public String getFechaHoraFormateada() {
		return fechaHoraFormateada;
	}

	@Override
	public String toString() {
		return
				"\nMoneda base = " + monedaBase +
				"\nMoneda cotizada = " + monedaCotizada+
				"\nConvercion moneda = " + convercionMoneda+
				"\nFecha y Hora de Convercion = " +fechaHoraFormateada;
	}
}
