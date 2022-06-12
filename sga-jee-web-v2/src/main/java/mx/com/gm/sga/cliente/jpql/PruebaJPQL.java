package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
        Object[] dupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
//        //Paso1: Consultar todos los objetos de tipo Persona
//        log.debug("\n1. Consulta de todas las Personas");
//        jqpl = "SELECT p FROM Persona p";
//        personas = em.createQuery(jqpl).getResultList();
//       mostrarPersonas(personas); //Metodo para iterar los objetos de tipo persona que vamos a recibir

        //Paso2: Consulta por IdPersona = 1
        log.debug("\n2. Consulta de idPersona = 1");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(persona);
        
        //Paso3: Consulta por Nombre = Patricio
        log.debug("\n3. Consulta por Nombre = Patricio");
        jpql =  "SELECT p FROM Persona p WHERE p.nombre = 'Patricio'";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
