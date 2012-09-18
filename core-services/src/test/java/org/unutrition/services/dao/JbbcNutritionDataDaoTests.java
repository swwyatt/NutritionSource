package org.unutrition.services.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations="classpath:nutrition-services-context-tests.xml")
public class JbbcNutritionDataDaoTests extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private JbbcNutritionDataDao jbbcNutritionDataDao;	

	@Test
	@Transactional
	public void testAddFoodDescription() {
		Object[] s = {"90240","1500","Mollusks, scallop, (bay and sea), cooked, steamed","SCALLOP,(BAY&SEA),CKD,STMD","","","Y","", 0,"",null,null,null,null};
		List<Object[]> descriptions = new ArrayList<Object[]>();
		
		descriptions.add(s);
		
		this.jbbcNutritionDataDao.addFoodDescription(descriptions);
		
		List<String> data = this.jbbcNutritionDataDao.listFoodDescription();
		
		org.junit.Assert.assertTrue(data != null && data.size() == 1);
	}

}
