package Principal;

import Peticion.Peticiones;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Peticiones peticiones = new Peticiones();
        peticiones.peticon();
    }
}
