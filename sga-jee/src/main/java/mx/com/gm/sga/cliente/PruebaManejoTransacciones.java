package mx.com.gm.sga.cliente;

import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaManejoTransacciones {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            Context jdni = new InitialContext();
            PersonaServiceRemote personaServiceRemote = (PersonaServiceRemote) jdni.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");

            log.debug("Iniciando prueba manejo Transaccional Pesona Service");
           
            //Buescar un objeto persona
            Persona persona1 = personaServiceRemote.encontrarPersonaPorId(new Persona(1));

            log.debug("Persona Recuperada: " + persona1);
            
            //Cambiar el apellido de la persona PRUEBA NEGAVITA para  validar el metodo TRANSACCIONAL y lance el ROLLBACK
//            persona1.setApellido("Cambio con error --------------------------------");
//            personaServiceRemote.modificarPersona(persona1);
//            log.debug("Objeto Modificado: " + persona1);
//            log.debug("Fin de prueba Transaccional");

            //Cambiar el apellido de la persona PRUEBA POSITIVA donde hace el cambio a nivel de BD
            persona1.setApellido("Perezoso");
            personaServiceRemote.modificarPersona(persona1);
            log.debug("Objeto Modificado: " + persona1);
            log.debug("Fin de prueba EJB Transaccional");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
