package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaJPQL {
    
         static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
//        //Paso1: Consultar todos los objetos de tipo Persona
//        log.debug("\n1. Consulta de todas las Personas");
//        jqpl = "SELECT p FROM Persona p";
//        personas = em.createQuery(jqpl).getResultList();
//       mostrarPersonas(personas); //Metodo para iterar los objetos de tipo persona que vamos a recibir

//        //Paso2: Consulta por IdPersona = 1
//        log.debug("\n2. Consulta de idPersona = 1");
//        jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
//        persona = (Persona) em.createQuery(jpql).getSingleResult();
//        log.debug(persona);
//        
//        //Paso3: Consulta por Nombre = Patricio
//        log.debug("\n3. Consulta por Nombre = Patricio");
//        jpql =  "SELECT p FROM Persona p WHERE p.nombre = 'Patricio'";
//        personas = em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);

//          //Paso4: Conslta de datos individuales con arreglo tupla de tipo ObJECT DE 3 COLUMNAS
//          log.debug("\n4. Consulta de datos individuales con arreglo tupla de tipo ObJECT DE 3 COLUMNAS");
//          jpql = "SELECT p.nombre as Nombre, p.email as Email, p.telefono as Telefono FROM Persona p";
//          iter = em.createQuery(jpql).getResultList().iterator();//Crear iterador para los objetos que retorna la consulta
//          while (iter.hasNext()) {
//            tupla = (Object[]) iter.next();
//            String nombre = (String) tupla[0];
//            String email = (String) tupla[1];
//            String telefono = (String) tupla [2];
//            log.debug("Nombre: " + nombre + " Email: " + email + " Telefono: " + telefono);
//        }
            
            //Paso5. Obtiene el objeto persona y el Id, SE CREA UN arreglo de tipo Object con dos columnas
            log.debug("\n5. Obtiene el objeto persona y el Id, SE CREA UN arreglo de tipo Object con 2 columnas");
            jpql = "SELECT p, p.idPersona FROM Persona p";
            iter = em.createQuery(jpql).getResultList().iterator();
            while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Objeto persona: " + persona + " idPersona: " + idPersona);
        }
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
