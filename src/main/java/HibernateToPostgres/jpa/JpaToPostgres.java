package HibernateToPostgres.jpa;

import HibernateToPostgres.entity.Employees;

import javax.persistence.*;
import java.util.List;

public class JpaToPostgres {
    public JpaToPostgres(){

        //это имя  <persistence-unit name="postgresql"> указанное в файле persistence.xml
        String persistenceUnitName = "postgresql";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        System.out.println("Connected to PostgreSQL database!");
//****** Выводим всех работников в должности обслуживающего персонала **********************
        String jpql = "SELECT e FROM Employees AS e WHERE e.department = :dept";
        Query query = em.createQuery(jpql);
        query.setParameter("dept", "Sales");
        List<Employees> employees = query.getResultList();
        for (Employees e : employees) {
            System.out.println("id = " + e.getId() + ", name = " + e.getName() + ", surname = " + e.getSurname() +
                    ", department = " + e.getDepartment() + ", salary = " + e.getSalary());
        }
//****** Добавляем работника с именем Ivan *************************************************
//        em.getTransaction().begin();
//        Employees employees = new Employees();
//        employees.setName("Ivan");
//        employees.setSurname("Petrov");
//        employees.setDepartment("Sales");
//        employees.setSalary(5000);
//        em.persist(employees);
//        em.getTransaction().commit();
//****** Удаляем работника с именем Ivan *************************************************
//        // Начать транзакцию:
//        em.getTransaction().begin();
//        // Выполнить запрос для выборки записей `Employees` с именем `Ivan`:
//        String jpql ="SELECT e FROM Employees e WHERE e.name = :name";
//        Query query = em.createQuery(jpql);
//        query.setParameter("name", "Ivan");
//        // Получить список записей с именем `Ivan`:
//        List<Employees> employeesList = query.getResultList();
//        // Удалить каждую запись из списка:
//        for (Employees employee : employeesList) {
//            em.remove(employee);
//        }
//        // Закоммитить данное действие, иначе откат.
//        em.getTransaction().commit();
//****** Вывод  работника с именем Pavel *************************************************
//        String jpql = "SELECT e FROM Employees AS e WHERE e.name = ?1";
//        List<Employees> employees1 = em.createQuery(jpql)
//                .setParameter(1, "Pavel")
//                .getResultList();
//        for (Employees e : employees1) {
//            System.out.println("id = " + e.getId() + ", name = " + e.getName() + ", surname = " + e.getSurname() +
//                    ", department = " + e.getDepartment() + ", salary = " + e.getSalary());
//        }
//*****************************************************************************************
        System.out.println("The database operation was successful!");
        em.close();
        emf.close();
    }
}
