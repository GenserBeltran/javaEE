package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Iniciando la Transaccion
        
        //Paso 1. Crear nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", "perd@lu.com", "96465");
        
        //Paso 2. Iniciando la Transaccion
        tx.begin();
        
        //Paso 3. Ejecutar el SQL
        em.persist(persona1);
        
        //Paso 4. Commit y Rollback
        tx.commit();
        
        //Objeto en estado deteached
        log.debug("Objeto Persistido en estado de deteached: " + persona1);
        
        //Cerrando el entity manager
        em.close();
        
    }
}
