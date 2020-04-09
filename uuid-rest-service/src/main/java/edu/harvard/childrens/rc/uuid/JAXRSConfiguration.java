package edu.harvard.childrens.rc.uuid;

import edu.harvard.childrens.rc.uuid.rest.UUIDMappingService;
import io.swagger.jaxrs.config.BeanConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *<p>When you deploy the PSAMA application WAR file to a new server, this class is called to supply basic configuration information.</p>
 */
@Startup
@ApplicationPath("uuid")
public class JAXRSConfiguration extends Application {

    private Logger logger = LoggerFactory.getLogger(JAXRSConfiguration.class);

    public static String someConfigurationValue;
    
    @PostConstruct
    public void init() {
    	/*
    	 * This class is used as a container for configuration by most of our applications.
    	 * 
    	 * The configuration of these things is handled in the standalone.xml file for the
    	 * environment of each deployment. You will also find the datasource configuration
    	 * there.
    	 * 
    	 * We keep a working example for dev in /src/main/resources/wildfly-configuration/standalone.xml
    	 * 
    	 */
    	someConfigurationValue = retrieveConfigurationVariable("some_configuration_variable");
    	
    	//Initialize swagger
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[] { "https" });
        beanConfig.setDescription("APIs for accessing Central UUID Service");
        beanConfig.setTitle("Central UUID Service");
        beanConfig.setBasePath("/uuid");
        beanConfig.setResourcePackage(UUIDMappingService.class.getPackage().getName());
        beanConfig.setScan(true);
        logger.info("Swagger initialized.");
    }

    private String retrieveConfigurationVariable(String name) {
    	try {
			Context ctx = new InitialContext();
			return (String)ctx.lookup("java:global/" + name);
		} catch (NamingException e) {
			logger.error("***************************************************************************");
			logger.error("***************************************************************************");
			logger.error("NamingException caught retrieving configuration value for " + name, e);
			logger.error("***************************************************************************");
			logger.error("***************************************************************************");
			return null;
		}
    }
    
}
