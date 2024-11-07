package Principal;

public class Calculos {

	private double monedaAPI;
	private String monedaBase;
	private String monedaCotizada;
	private double convercionMoneda;



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

	@Override
	public String toString() {
		return
				"Moneda base = " + monedaBase +
				"\nMoneda cotizada = " + monedaCotizada+
				" \nConvercion moneda = " + convercionMoneda;
	}
}
