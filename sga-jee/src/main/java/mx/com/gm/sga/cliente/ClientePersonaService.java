
package mx.com.gm.sga.cliente;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamad al EJB desde el cliente");
        try {
            Context jdni = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jdni.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas(
            );
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("Fin de la llamada al EJB Client");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
