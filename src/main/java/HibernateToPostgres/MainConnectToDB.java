package HibernateToPostgres;

import HibernateToPostgres.jdbcAndProperties.JdbcToPostgresAndProperties;
import HibernateToPostgres.jpa.JpaToPostgres;

/**
 * Для использования JPA и Hibernate в проекте вам потребуются следующие зависимости:
 *
 * <dependencies>
 *     <!-- зависимость для JPA -->
 *     <dependency>
 *         <groupId>javax.persistence</groupId>
 *         <artifactId>javax.persistence-api</artifactId>
 *         <version>2.2</version>
 *     </dependency>
 *
 *     <!-- зависимость для Hibernate -->
 *     <dependency>
 *         <groupId>org.hibernate</groupId>
 *         <artifactId>hibernate-core</artifactId>
 *         <version>5.4.32.Final</version>
 *     </dependency>
 *
 *     <!-- зависимость для JDBC драйвера PostgreSQL -->
 *     <dependency>
 *         <groupId>org.postgresql</groupId>
 *         <artifactId>postgresql</artifactId>
 *         <version>42.3.1</version>
 *     </dependency>
 * </dependencies>
 *
 * Зависимость для JPA содержит только API интерфейсы и не содержит реализации.
 * Зависимость для Hibernate содержит реализацию JPA интерфейсов, а также
 * реализацию других Hibernate-специфичных интерфейсов. Зависимость для
 * PostgreSQL JDBC драйвера позволяет вам подключиться к базе данных PostgreSQL
 * через JPA и Hibernate.
 */
public class MainConnectToDB {
    public static void main(String[] args) {

//        new JdbcToPostgres();
//        new JdbcToPostgresAndProperties();
        new JpaToPostgres();

    }
}
