package com.demo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:persistence-multiple-db.properties"})
@EnableJpaRepositories(
        basePackages = "com.demo.repository.db1",
        entityManagerFactoryRef = "db1EntityManager",
        transactionManagerRef = "db1TransactionManager"
)
public class Db1Configuration {

    private final Environment env;

    @Autowired
    public Db1Configuration(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean db1EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(db1DataSource());
        em.setPackagesToScan("com.demo.entity.db1");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(getJpaPropertiesMap());
        return em;
    }

    @Primary
    @Bean
    public DataSource db1DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("db1.jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager db1TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(db1EntityManager().getObject());
        return transactionManager;
    }

    private Map<String, Object> getJpaPropertiesMap(){
        HashMap<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaPropertiesMap.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return jpaPropertiesMap;
    }
}
