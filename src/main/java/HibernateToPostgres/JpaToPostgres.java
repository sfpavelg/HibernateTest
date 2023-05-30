package HibernateToPostgres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class JpaToPostgres {
    public JpaToPostgres(){
        String persistenceUnitName = "postgresTest";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Employee e WHERE e.department = :dept";

        Query query = em.createQuery(jpql);
        query.setParameter("dept", "Sales");

        List<Employee> employees = query.getResultList();

        for (Employee e : employees) {
            System.out.println(e.getName());
        }

        em.close();
        emf.close();
    }
}
