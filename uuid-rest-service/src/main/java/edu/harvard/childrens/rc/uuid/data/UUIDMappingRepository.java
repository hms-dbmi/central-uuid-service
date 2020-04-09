package edu.harvard.childrens.rc.uuid.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * <p>Provides operations for the UUIDMapping entity to interact with a database.</p>
 * @see User
 */
@Transactional
@ApplicationScoped
public class UUIDMappingRepository {

	private Logger logger = LoggerFactory.getLogger(UUIDMappingRepository.class);

	protected UUIDMappingRepository() {
		logger.info("UUID Mapping Repo Intialized");
	}

	
	@PersistenceContext
	protected EntityManager em;
	
	protected EntityManager em(){
		return em;
	}


}
