
package test;

import beans.HolaMundoEjbRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;


public class TestHolaMundoEJB {
    public static void main(String[] args) {
        
        System.out.println("Iniciando llamada al EJB desde el Cliente");
        
        try {
            Context jdni = new InitialContext();
            //Llanmadno el metodo sumar del lado del cliente
            HolaMundoEjbRemote holaMundoEjb = (HolaMundoEjbRemote) jdni.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEjb.suma(5, 3);
            System.out.println("Resultado EJB suma 5 + 3: " + resultado);
        } catch (NamingException ex) {
            Logger.getLogger(TestHolaMundoEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
