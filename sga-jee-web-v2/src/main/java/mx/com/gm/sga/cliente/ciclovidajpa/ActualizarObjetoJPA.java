package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {

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

        //Paso 3. termina la Transaccion 1
        tx.commit();

        //Objeto en estado deteached
        log.debug("Objeto Recuperdo en estado de deteached: " + persona1);
        
        //Paso 4. Metodo para modificar el objeto recuperado (Uno o todos los campos)
        persona1.setApellido("Ramirez");
        persona1.setEmail("carram@gmail.com");
        
        //Paso 1. Iniciar transaccion para objeto modificado 
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 6. Hacer el update de objeto recuperado y actualizado
        em.merge(persona1);
        
        //Paso 3. termina la Transaccion 2
        tx2.commit();
        
        //Objeto en estado deteached pero ya modificado
        log.debug("Objeto Actualizado en estado de deteached: " + persona1);
        
        //Cerrando el entity manager
        em.close();
    }
}
