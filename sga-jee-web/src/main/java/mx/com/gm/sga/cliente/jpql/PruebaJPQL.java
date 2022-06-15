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
//            //Paso5. Obtiene el objeto persona y el Id, SE CREA UN arreglo de tipo Object con dos columnas
//            log.debug("\n5. Obtiene el objeto persona y el Id, SE CREA UN arreglo de tipo Object con 2 columnas");
//            jpql = "SELECT p, p.idPersona FROM Persona p";
//            iter = em.createQuery(jpql).getResultList().iterator();
//            while (iter.hasNext()) {
//            tupla = (Object[]) iter.next();
//            persona = (Persona) tupla[0];
//            int idPersona = (int) tupla[1];
//            log.debug("Objeto persona: " + persona + " idPersona: " + idPersona);
//        }
//              //Paso6. Consulta de todas las personas
//              log.debug("\n6. Obtiene el idPersona del objeto y los otros valores por defautl segun el constructor");
//              jpql = "SELECT new mx.com.gm.sga.domain.Persona(p.idPersona) FROM Persona p";
//              personas = em.createQuery(jpql).getResultList();
//              mostrarPersonas(personas);
//              
//              //Paso7. Regresa el valor minimo, maximo y conteo de idPersona 
//              log.debug("\n7. Obtiene el maximo y minimo de idPersona (Escalares) y contar cuantas personas tenemos");
//              jpql = "SELECT MIN(p.idPersona) AS MinId, MAX(p.idPersona) AS MaxId, COUNT(p.idPersona) AS Contador FROM Persona p";
//              iter = em.createQuery(jpql).getResultList().iterator();
//              while (iter.hasNext()) {
//              tupla = (Object[]) iter.next();
//              Integer idMin = (Integer) tupla[0];
//              Integer idMax = (Integer) tupla[1];
//              Long count = (Long) tupla[2];
//              log.debug("idMin: " + idMin + " idMax: " +idMax + " Contador: " + count);
//        }
//            //Paso8. Contar los nombres de las personas que son distintos
//            log.debug("\n8. Contar los nombres de las personas que son distintos");
//            jpql = "SELECT COUNT(DISTINCT (p.nombre)) FROM Persona p";
//            Long contador = (Long) em.createQuery(jpql).getSingleResult();
//            log.debug("# de personas con nombre distinto: " + contador);
//            
//            //Paso9. Nombre y apellidos en Mayuscula
//            log.debug("\n9. Nombre y apellidos concatenados y en Mayuscula");
//            jpql = "SELECT UPPER(CONCAT(p.nombre, ' ', p.apellido)) AS Nombre FROM Persona p";
//            nombres = em.createQuery(jpql).getResultList();
//            for (String nombreCompleto : nombres) {
//                log.debug(nombreCompleto);
//        }
//        //Paso10. Consultar el objeto persona con id Igual al parametro proporcinado
//        log.debug("\n10. Consultar el objeto persona con id Igual al parametro proporcinado");
//        int idPersona = 1;
//        jpql = "SELECT p FROM Persona p WHERE p.idPersona = :id";
//        q = em.createQuery(jpql);
//        q.setParameter("id", idPersona);
//        persona = (Persona) q.getSingleResult();
//        log.debug(persona);
//
//        //Paso11. Obtiene las personas que contengan una letra A en el nombre sin importar si es mayuscula o nimuscula
//        log.debug("\n11. Obtiene las personas que contengan una letra A en el nombre sin importar si es mayuscula o nimuscula");
//        String parametroString = "%a%";
//        jpql = "SELECT p FROM Persona p WHERE UPPER(p.nombre) like UPPER(:parametro)";
//        q = em.createQuery(jpql);
//        q.setParameter("parametro", parametroString);
//        personas = q.getResultList();
//        log.debug(personas);
//        //Paso12.Uso de Beetwen
//        log.debug("\n12. Uso de Beetwen");
//        jpql = "SELECT p FROM Persona p WHERE p.idPersona BETWEEN 1 AND 2";
//        personas = em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);
//        
//        //Paso13.Uso del ordenamietno
//        log.debug("\n13. Uso de ordenamietno ORDER BY");
//        jpql = "SELECT p FROM Persona p WHERE p.idPersona > 2 ORDER BY p.idPersona ASC, p.nombre DESC";
//        personas = em.createQuery(jpql).getResultList();
//        mostrarPersonas(personas);
       
        //Paso14.Uso del subQuerys
        log.debug("\n14. Uso del subQuerys");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona in (SELECT MIN(p1.idPersona) FROM Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //Paso15. Uso de join con Lazy Loading
        log.debug("\n15. Uso de join con Lazy Loading");
        jpql = "SELECT u FROM Usuario u JOIN u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        //Paso15. Uso de left, right o inner join con eager Loading
        log.debug("\n15. Uso de left, right o inner join con eager Loading");
        jpql = "SELECT u FROM Usuario u LEFT JOIN FETCH u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            log.debug(u);
        }
    }
}
