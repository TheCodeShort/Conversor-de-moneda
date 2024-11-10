package Principal;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int nun = 0;
        while (nun != 1) {

                Scanner monedas = new Scanner(System.in);
                System.out.print("Digita la moneda base: ");
                String monedaBase = monedas.nextLine().trim().toUpperCase();
                System.out.print("Digita la moneda cotizada: ");
                String monedaCotizada = monedas.nextLine().trim().toUpperCase();
                System.out.print("Digita la cantidad: ");
                String miMoneda = monedas.nextLine().trim();
                double miMonedaLimpia = Integer.parseInt(miMoneda);

                System.out.println("************************************************");


            if( monedaBase.matches("[a-zA-Z]+") && monedaCotizada.matches("[a-zA-Z]+")) {


                URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9ec240d260c224f73f1cdd9/pair/" + monedaBase + "/" + monedaCotizada);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .build();


                try {
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    /*System.out.println(response.body());  // Aquí imprime el contenido de la respuesta*/

                    Monedas moneda = new Gson().fromJson(response.body(), Monedas.class);//se convierte a un objeto para java
                    Calculos calculosAPI = new Calculos(moneda);



                    var calculos = new Calculos(monedaBase, monedaCotizada, calculosAPI.calculoMoneda(miMonedaLimpia));
                    System.out.println(calculos);
                    System.out.println("***************************************");

                    FileWriter archivo = new FileWriter( calculos.getRutaArchivo(), true);
                    archivo.write( calculos.toString());
                    archivo.close();




                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);

                } catch (NumberFormatException e){
                    System.out.println("El numero que digito no es valido vuelve a intentarlo");

                }catch (Exception e) {
                    System.out.println("Ocurrio un error inesperado vuelve a intentarlo, " + e.getMessage());
                }
                System.out.print("Quieres saber de otra moneda \n1) si / 2) no:");

                int opcion  = monedas.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("\nok sigamos");
                        break;
                    default:
                        System.out.println("Gracias por utilizar nuestra App");
                        nun = 1;
                        break;
                }



            }else {
                System.out.println("Los tipos de datos que digito estan mal");
            }



        }
    }
}
