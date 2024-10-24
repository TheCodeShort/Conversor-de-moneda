package Peticion;

public class Peticiones {

	public void peticon (){
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://www.omdbapi.com/?i=tt3896198&apikey=290c0af4"))
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());  // Aquí imprime el contenido de la respuesta
	}
}
