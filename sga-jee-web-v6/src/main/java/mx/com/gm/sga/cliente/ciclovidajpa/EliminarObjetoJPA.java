package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {
         static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Iniciando la Transaccion
        //Paso 1. Crear nuevo objeto
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecutar SQL de tipo Select para actualizar OJO DEBE Existir en la BD (Clase de tipo entity y el Id a buscar)
        Persona persona1 = em.find(Persona.class, 9);
        
        //Objeto en estado deteached
        log.debug("Objeto Recuperdo en estado de deteached: " + persona1);

        //Paso 3. Metodo para eliminar el objeto recuperado
        em.remove(persona1);
        
        //Paso 4. termina la Transaccion 1
        tx.commit();

        //Objeto en estado deteached pero ya modificado
        log.debug("Objeto Eliminado en estado de deteached: " + persona1);

        //Cerrando el entity manager
        em.close();
    }
}
