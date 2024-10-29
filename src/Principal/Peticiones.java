package Principal;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Peticiones {

	public void peticon (){


		Scanner monedas = new Scanner(System.in);
		System.out.print("Digita la moneda base: ");
		String monedaBase = monedas.nextLine();
		System.out.print("Digita la moneda cotizada: ");
		String monedaCotizada = monedas.nextLine();

		URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9ec240d260c224f73f1cdd9/pair/" + monedaBase + "/" + monedaCotizada);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(direccion)
				.build();


		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());  // Aquí imprime el contenido de la respuesta*/
			new Gson().fromJson(response.body(), Monedas.class);

		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);

		}
	}
}
