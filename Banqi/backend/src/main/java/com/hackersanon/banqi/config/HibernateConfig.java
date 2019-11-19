package com.hackersanon.banqi.config;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = {"com.hackersanon.banqi.*"})
@EnableTransactionManagement
@EnableJpaRepositories("com.hackersanon.banqi.database")
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfig {
    private final static String DATABASE_URL = "jdbc:mysql://cs414-f19-hackersanon.mysql.database.azure.com:3306/banqi?serverTimezone=US/Central";
    private final static String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    private final static String DATABASE_USERNAME = "hackersanon@cs414-f19-hackersanon";
    private final static String DATABASE_PASSWORD = "CS414BANQI";

    @Autowired
    private Environment environment;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdaptor());
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.hackersanon.banqi");
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
        return entityManagerFactoryBean;
    }


    @Bean
    public JpaVendorAdapter getJpaVendorAdaptor() {
        JpaVendorAdapter jpaVendorAdapter;
        jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager;
        jpaTransactionManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }


    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(DATABASE_DRIVER);
        dataSource.setJdbcUrl(DATABASE_URL);
        dataSource.setUser(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }


    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
//    @Bean
//    public SessionFactory getSessionFactory(){
//        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
//
//        builder.addProperties(getHibernateProperties());
//        builder.scanPackages("com.hackersanon.banqi.database");
//        builder.addAnnotatedClass(UserEntity.class);
//        return builder.buildSessionFactory();
//    }
//    @Bean
//    public HibernateTransactionManager getTransactionManager(){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory());
//        return transactionManager;
//    }

}
