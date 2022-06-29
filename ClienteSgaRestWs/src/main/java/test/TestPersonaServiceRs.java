package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestPersonaServiceRs {

    //Variables que vamos a utilizar
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web-RS/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static void main(String[] args) {
        //NUEVA AUTENCICACION SUPERANDO LA BARRERA DEL EJB
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        cliente = ClientBuilder.newClient(clientConfig);

        //Leer una persona METODO GET
        webTarget = cliente.target(URL_BASE).path("/personas");

        //Porporcionando un idPersona u obejto valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        //System.out.println("Persona Recuperada: " + persona);

        //Leer todas las personas metodo GET CON REDeNTITY DE TIPO LIST<>
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>() {
        });
        System.out.println("\nPersonas recuperadas \n");
        imprimirPersonas(personas);

        
//Agregar una Persona METODO POST
//        System.out.println("Agregando Persona ... \n200  -> Significa que la pagina ha cargado de forma correcta");
//        Persona newPersona = new Persona();
//        newPersona.setNombre("Yers");
//        newPersona.setApellido("Oti");
//        newPersona.setEmail("yers@gmail.com");
//        newPersona.setTelefono("3243134");
//        
//        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
//        response = invocationBuilder.post(Entity.entity(newPersona, MediaType.APPLICATION_XML));
//        System.out.println("");
//        System.out.println(response.getStatus());
//        //Recuperamos la persona recien agregada
//        Persona personaRecuperada = response.readEntity(Persona.class);
//        System.out.println("Persona Agregada: " + personaRecuperada);


//Modificamos la persona recien agregada METODO PUT en este caso modificar con el idPersona = 18 que es la recien creada
//        persona = webTarget.path("/18").request(MediaType.APPLICATION_XML).get(Persona.class);
//        persona.setApellido("Ramirez");
//        invocationBuilder = webTarget.path("/18").request(MediaType.APPLICATION_XML);
//        response = invocationBuilder.put(Entity.entity(persona, MediaType.APPLICATION_XML));
//
//        System.out.println("");
//        System.out.println("response: " + response.getStatus());
//        System.out.println("Persona Modificada: " + response.readEntity(Persona.class));

      
//Eliminamos la persona recien agregada
//        persona = webTarget.path("/20").request(MediaType.APPLICATION_XML).get(Persona.class);
//        invocationBuilder = webTarget.path("/20").request(MediaType.APPLICATION_XML);
//        response = invocationBuilder.delete();
//        
//        System.out.println("");
//        System.out.println("response: " + response.getStatus());
//        System.out.println("Persona Eliminada: " + persona);

    }

    private static void imprimirPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println("Personas: " + p);
        }
    }

}
