package conexi�n;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateOracle {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:XE");
		config.setProperty("hibernate.connection.username", "SYSTEM");
		config.setProperty("hibernate.connection.password", "admin");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		config.setProperty("hibernate.show_sql", "true");
		
		config.addAnnotatedClass(Customer.class);
		
	
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(new Customer("adriano Barbosa", "adrianoadvrio@yahoo.com.br"));
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
