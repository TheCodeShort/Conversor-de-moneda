package Principal;

public class Calculos {

	private double convercionMoneda;
	private String monedaBase;
	private String monedaCotizada;


	public Calculos(String monedaCotizada, String monedaBase, double convercionMoneda) {
		this.monedaCotizada = monedaCotizada;
		this.monedaBase = monedaBase;
		this.convercionMoneda = convercionMoneda;
	}

	public Calculos (Monedas misMonedas){
		this.monedaBase = misMonedas.base_code();
		this.monedaCotizada = misMonedas.target_code();
		this.convercionMoneda = misMonedas.conversion_rate();
	}



	@Override
	public String toString() {
		return "Calculos = " +
				"convercionMoneda = " + convercionMoneda +
				", monedaBase = " + monedaBase +
				", monedaCotizada = " + monedaCotizada;
	}
}
