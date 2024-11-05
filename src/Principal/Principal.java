package Principal;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner monedas = new Scanner(System.in);
        System.out.print("Digita la moneda base: ");
        String monedaBase = monedas.nextLine();
        System.out.print("Digita la moneda cotizada: ");
        String monedaCotizada = monedas.nextLine();
        System.out.println("Digita la cantidad: ");
        double miMonda = monedas.nextInt();

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9ec240d260c224f73f1cdd9/pair/" + monedaBase + "/" + monedaCotizada);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();




        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            /*System.out.println(response.body());  // Aquí imprime el contenido de la respuesta*/

            Monedas moneda =  new Gson().fromJson(response.body(), Monedas.class);//se convierte a un objeto para java
            System.out.println(moneda);
            var calculos = new Calculos(monedaCotizada, monedaBase, miMonda);
            System.out.println(calculos);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }


    }
}
