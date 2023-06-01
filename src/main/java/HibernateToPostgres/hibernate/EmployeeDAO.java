package HibernateToPostgres.hibernate;

import HibernateToPostgres.entity.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAO {
//**** Добавление работника в БД **********************************************
    public void addEmployee(Employees employee) {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Сохранение сущности в БД
            session.save(employee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            // Закрытие сессии
            session.close();
        }
    }

//**** Получение из БД всех работников *********************************************
    public List<Employees> getAllEmployees() {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employees> employees = session.createQuery("from Employees", Employees.class).list();

        // Закрытие сессии
        session.close();

        return employees;
    }

//**** Получение работника из БД по id *********************************************
    public Employees getEmployeeById(long id) {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        Employees employee = session.get(Employees.class, id);

        // Закрытие сессии
        session.close();

        return employee;
    }

//**** Обновление данных работника в БД, взятого от туда, например по id ***********
    public void updateEmployee(Employees employee) {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Обновление сущности в БД
            session.update(employee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            // Закрытие сессии
            session.close();
        }
    }

//**** Удаление работника из БД, взятого от туда, например по id ********************
    public void deleteEmployee(Employees employee) {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Удаление сущности из БД
            session.delete(employee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            // Закрытие сессии
            session.close();
        }
    }
    //**** Удаление работника из БД, взятого от туда, например по id ********************
    public void deleteEmployeeById(long id) {
        // Открытие сессии
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employees employee = session.get(Employees.class, id);

            // Удаление сущности из БД
            session.delete(employee);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            // Закрытие сессии
            session.close();
        }
    }



}
