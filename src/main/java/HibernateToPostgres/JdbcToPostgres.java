package HibernateToPostgres;
/**
 * Для добавления драйвера в IntelliJ IDEA, без системы контроля версий Maven, нужно выполнить следующие шаги:
 * 1. Скачать драйвер Postgres с сайта https://jdbc.postgresql.org/ вы должны увидеть файл с названием postgresql-[версия].jar, где [версия] - это версия драйвера.
 * 2. Поместить скаченный драйвер в пакет lib вашего проекта. Пакет lib разместить в корне проекта или другом удомном месте.
 * 3. Открыть проект в IntelliJ IDEA.
 * 4. Нажать на меню "File" -> "Project Structure".
 * 5. В открывшемся окне выбрать вкладку "Libraries".
 * 6. Нажать на кнопку "New Project Library" или "New Module Library", в зависимости от того, для какого модуля вы хотите добавить библиотеку.
 * 7. Указать путь к скаченному jar файлу драйвера, который вы хотите добавить.
 * 8. Нажать "OK".
 * В таком варианте, драйвер будет подключаться автоматически. Импорт не нужен, регистрация драйвера не нужна.
 */

import java.sql.*;

public class JdbcToPostgres {
    private final String URLDB = "jdbc:postgresql://localhost:5432/postgresTest";
    private final String USER = "postgres";
    private final String PASSWORD = "Pavelsf";

    public JdbcToPostgres() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URLDB, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");
//            String sql = "CREATE TABLE employees ("
//                    + "id SERIAL PRIMARY KEY,"
//                    + "name VARCHAR(50) NOT NULL,"
//                    + "surname VARCHAR(50),"
//                    + "department VARCHAR(50),"
//                    + "salary NUMERIC(10,2)"
//                    + ")";
//            String sql = "DROP TABLE employees";
//            String sql = "ALTER TABLE employees  DROP COLUMN department";
//            String sql = "ALTER TABLE employees  ADD  department VARCHAR(50)";
//            String sql = "ALTER TABLE employees RENAME TO clients";
//            String sql = "ALTER TABLE clients RENAME TO employees";
//            String sql = "TRUNCATE TABLE employees";
//            String sql = "INSERT INTO employees (name, surname, department, salary)" +
//                    "VALUES ('Pavel', 'Sofein', 'IT', 500)," +
//                    " ('Oleg', 'Ivanov', 'Sales', 700)," +
//                    " ('Nina', 'Sidorova', 'HR', 850)";
//            String sql = "UPDATE employees SET salary = '800' WHERE id = 1";
//            String sql = "DELETE FROM employees WHERE id = 3";

//            String sql = "CREATE USER Pavel PASSWORD '12345'";
//            String sql = "DROP USER Pavel";

//            String sql = "CREATE VIEW employeesSalary AS " +
//                    "SELECT * FROM employees WHERE salary > '2000'";

//            String sql = "DROP VIEW employeesSalary";

//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//****************   SELECT * FROM employees *********************************
            String sql = "SELECT * FROM employees ORDER BY id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");
                System.out.println("id = " + id + ", name = " + name + ", surname = " + surname +
                ", department = " + department + ", salary = " + salary);
            }
//****************   SELECT * FROM employees *********************************
            System.out.println("The database operation was successful!");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

