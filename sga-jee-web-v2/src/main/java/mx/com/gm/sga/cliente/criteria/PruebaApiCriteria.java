package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaApiCriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Parte 1.
        
        //Primer query usando el api de criteria
        //1. Consulta de todas las personas
        
        //Paso1. El objeto EntityManager crea una instancia CriteriaBulider
        cb =  em.getCriteriaBuilder();
        
        //Paso2. Se crea el objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //Paso3. Crear el objeto raiz del Query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //Paso4. Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //Paso5. Creamos el tipo de Query  typeSafe
        query = em.createQuery(criteriaQuery);
        
        //Paso6. Ejecutamos la consulta
        personas = query.getResultList();
        
//        mostraPersonas(personas);

        //Parte 2. 
        
        //Consulta de la Persona con id = 1
        //jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
        log.debug("\n Consultas de las Persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        //Parte 3.
        //Consulta de la Persona con id = 1
        log.debug("\n Consultas de las Persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //La clase Predicate nos permite agregar vartios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<>();
        
        //Validando si tenemos criterios por agregar
        Integer idPeronsaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        //Agrgando los criterios SI esta vacio O si NO
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin comentarios");
        }
        else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        }
        else{
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPeronsaParam);
        
        //Se ejecuta el query
        persona = query.getSingleResult();
        log.debug(persona);
    }

    private static void mostraPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            log.debug(p);
        }
    }
}
