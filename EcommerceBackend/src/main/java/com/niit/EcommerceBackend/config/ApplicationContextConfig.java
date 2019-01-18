package com.niit.EcommerceBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.model.Product;
import com.niit.EcommerceBackend.model.Supplier;
import com.niit.EcommerceBackend.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement

public class ApplicationContextConfig {

	@Bean(name = "datasource")
	public DataSource getH2DataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/ecommerceproject");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}

	private Properties getHibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.show_sql", "true");
		p.put("hibenate.dialect", "org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager gettransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;

	}

}
