/*******************************************************************************
 * This class is the factory of sessionfactory
 ******************************************************************************/
package com.owl.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**HibernateUtil generated by netbeans 8.2
 * Hibernate Utility class with a convenient method to get Session Factory
 * object. The AnnotationConfiguration object when creating the file but this 
 * method is deprecated in version 4.2 of hibernate
 * @version 1.0
 * @author Maicon Messias
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration configuration  = new Configuration().configure("com/owl/util/hibernate.cfg.xml");
            ServiceRegistryBuilder stdServiceRegistryBuilder = new ServiceRegistryBuilder();
            stdServiceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = stdServiceRegistryBuilder.buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
