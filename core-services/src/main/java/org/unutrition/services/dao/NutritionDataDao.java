package org.unutrition.services.dao;

import java.util.List;


/**
 * DAO for loading nutrition data files
 * @author steve
 *
 */
public interface NutritionDataDao {

	public void addFoodDescription(List<Object[]> descriptions);
	
	public List<String> listFoodDescription();
	
}
