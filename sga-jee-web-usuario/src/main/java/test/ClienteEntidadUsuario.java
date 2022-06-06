package test;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteEntidadUsuario {

    static Logger log = LogManager.getRootLogger();

//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGA");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//       //Iniciando la transaccion
//        tx.begin();
//        //En este caso se hara un registro en BD validando que el ID se encuentre ya en la tabla personas
//        Usuario usuario1 = new Usuario("Carl", "car458");
//        log.debug("Objeto a persistir: "+usuario1);
//        //Persistimos el objeto
//        em.persist(usuario1);
//        //Terminamos la transaccion
//        tx.commit();
//        log.debug("Objeto persistido: " +usuario1);
////        em.close();
//    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Creando Objeto Persona para traer el id
        Persona persona = new Persona();
        persona.setIdPersona(9);

        //Iniciando la transaccion
        tx.begin();
        //En este caso se hara un registro en BD validando que el ID se encuentre ya en la tabla personas
        Usuario usuario2 = new Usuario("Carl", "xxx", persona);
        log.debug("Objeto a persistir: " + usuario2);
        //Persistimos el objeto
        em.persist(usuario2);
        //Terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido: " + usuario2);
        em.close();
    }
}
