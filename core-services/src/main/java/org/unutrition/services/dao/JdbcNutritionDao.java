package org.unutrition.services.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class JdbcNutritionDao extends SimpleJdbcDaoSupport implements NutritionDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcNutritionDao.class);
	
}
