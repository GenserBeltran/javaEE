package mx.com.gm.sga.cliente.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenciaCascadaJPA {
    
     static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso1: Crear nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Hugo", "Hernadez", "hgu@gmail.com", "54641");
        
        //Paso2: Crear nuevo Usuario en relacion con Persona1
        //Crear objeto usuario con dependencia al objeto a  crear persona
        Usuario usuario1 = new Usuario("herna", "hug54", persona1);
        
        //Paso3. Persistir el objeto usuario unicamente
        em.persist(usuario1);
        
        //Paso 4. termina la Transaccion
        tx.commit();

        //Objeto en estado deteached
        log.debug("Objeto Creados en estado de deteached: " + persona1);
        log.debug("Objeto Creados en estado de deteached: " + usuario1);

        //Cerrando el entity manager
        em.close();

    }
}
