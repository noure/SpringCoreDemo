package ma.formation.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class DemoApp {

	private static final Logger logger = Logger.getLogger(DemoApp.class);

	public static void main(String[] args) {

		// 1. Chargement du conteneur en 4.0.0 Spring
		ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("beansContext.xml");
			
		//1.2 deuxième façon 
//		@SuppressWarnings("deprecation")
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("c:/beansContext.xml"));
//		1.3
//		@SuppressWarnings("deprecation")
//		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource ("beansContext.xml"));
		
		// 2. Recuperation d'un bean du conteneur
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societeDevLogiciel");

		// 3. Manipulation du bean avec injection de dependances
		logger.info("Chef Developpeur: " + societe.getChefDeveloppeur().getNom());
		logger.info("Developpeur     : " + societe.getDeveloppeur().getNom());
	}

}
