package HibernateToPostgres.jdbcAndProperties;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

static {
    loadProperties();
}
    public PropertiesUtil(){
    }
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static void loadProperties(){
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("META-INF/application.properties")) {
        PROPERTIES.load(inputStream);
    }catch (IOException e){
        throw new RuntimeException(e);
    }
    }
}
