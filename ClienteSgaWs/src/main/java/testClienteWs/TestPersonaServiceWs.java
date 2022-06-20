package testClienteWs;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;
import java.util.List;

public class TestPersonaServiceWs {
    public static void main(String[] args) {
        PersonaServiceWs personService = new PersonaServiceImplService().getPersonaServiceImplPort();

        System.out.println("Ejecutando Servicio listar personas");
        List<Persona> personas = personService.listarPersonas();
        for (Persona persona : personas) {
            System.out.println("Persona idPersona: " + persona.getIdPersona() + " nombres: " + persona.getNombre()
            + " Apellido: " + persona.getApellido() + " Email: " + persona.getEmail());
        }
        System.out.println("Fin del servicio listar personas WS");
    }
}
