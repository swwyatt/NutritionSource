package org.unutrition.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unutrition.services.dao.NutritionDataDao;

/**
 * Methods to load nutrition data base
 * @author steve
 *
 */
public class DataLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
	
	static final String SEPERATOR_REGEX = "\\^";
	
	private NutritionDataDao nutritionDataDao;
	
	public DataLoader() {
	}
	
	public void loadFoodDescriptionFile(File file) {
		try {
			List<Object[]> data = new ArrayList<Object[]>();
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = reader.readLine();
			int elementCount = 0;
			int lineCount = 1;
			while (line != null) {
				Object[] elements = line.split(SEPERATOR_REGEX);
				
				NutritionDataUtils.removePadding((String[])elements);

				elements[8] = new BigInteger((String)elements[8]);
				elements[10] = new BigDecimal((String)elements[10]);
				elements[11] = new BigDecimal((String)elements[11]);
				elements[12] = new BigDecimal((String)elements[12]);
				elements[13] = new BigDecimal((String)elements[13]);

				if (elementCount != 0 && elementCount != elements.length) {
					LOGGER.info("Line {} element count, {}, is inconsistent with previous line... Skipped.", lineCount, elements.length);
					continue;
				}
				elementCount = elements.length;


				data.add(elements);

				LOGGER.info(ArrayUtils.toString(elements));

				line = reader.readLine();
				lineCount++;
			}
			
			this.nutritionDataDao.addFoodDescription(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		File file = new File("documents/FOOD_DES.txt");
		DataLoader dataLoader = new DataLoader();
		dataLoader.loadFoodDescriptionFile(file);
	}

	public void setNutritionDataDao(NutritionDataDao nutritionDataDao) {
		this.nutritionDataDao = nutritionDataDao;
	}

}
