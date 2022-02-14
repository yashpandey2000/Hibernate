package in.co.rays.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import in.co.rays.pojo.User;

public class Util {
	
	private static StandardServiceRegistry registry;
	
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()throws Exception{
		
		
		if (sf != null) {
			return sf;
		}
		
		Map<String, Object> settings = new HashMap();
		settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate5");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "root");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.hbm2ddl.auto", "update");
		
		
		settings.put(Environment.USE_SECOND_LEVEL_CACHE, true);
		
		settings.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.jcache.JCacheRegionFactory");
		
		settings.put("hibernate.javax.cache.provider",  "org.ehcache.jsr107.EhcacheCachingProvider");
		
		
		// 2. Create registry builder
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

		// 3.Set registry properties
		registryBuilder.applySettings(settings);

		// 4. Create registry
		registry = registryBuilder.build();

		// 5. Register entity class
		MetadataSources sources = new MetadataSources(registry);
		sources.addAnnotatedClass(User.class);
		
		/*sources.addAnnotatedClass(Employee.class);
		sources.addAnnotatedClass(Department.class);*/

		
		Metadata metadata = sources.getMetadataBuilder().build();
		

        //6. Create session factory 	
		sf = metadata.getSessionFactoryBuilder().build();
	
	
		return sf;
		
	}
	
	// Destory registry
	
	public static void shutdown(){
		
		if(registry!=null){
			
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	

}
