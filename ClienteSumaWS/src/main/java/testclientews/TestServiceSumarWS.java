package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServiceSumarWS {
    public static void main(String[] args) {
        ServicioSumarWS servicioSumar = new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutar los servicios sumar WS");
        int x = 5;
        int y = 8;
        int resultado = servicioSumar.sumar(x, y);
        System.out.println("Resultado Suma: " + resultado);
        
    }
}
