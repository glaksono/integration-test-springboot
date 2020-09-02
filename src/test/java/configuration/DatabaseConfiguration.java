package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application-test.properties")
@EnableTransactionManagement
public class DatabaseConfiguration {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("glaksono.springboot.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show-sql",true);
        properties.put("spring.jpa.properties.hibernate.type",env.getProperty("spring.jpa.properties.hibernate.type"));
        properties.put("spring.jpa.properties.hibernate.show_sql",env.getProperty("spring.jpa.properties.hibernate.show_sql"));
        properties.put("spring.jpa.properties.hibernate.use_sql_comments",env.getProperty("spring.jpa.properties.hibernate.use_sql_comments"));
        properties.put("spring.jpa.properties.hibernate.format_sql",env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        properties.put("hspring.jpa.hibernate.ddl-auto",env.getProperty("spring.jpa.hibernate.ddl-auto"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return (DataSource) dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", true);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


}
