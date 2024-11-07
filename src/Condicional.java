public class Condicional {
	
	public void condicion( String monedaBase, String monedaCotizada, double miMonedaLimpia, int salir){

		if(monedaBase instanceof String && monedaCotizada instanceof String && miMonedaLimpia == miMonedaLimpia){
			salir = 1;
			
		}else {
			System.out.println("Los tipos de datos que digitasre estan mal");
		}


	}
}
