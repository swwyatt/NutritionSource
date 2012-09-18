package org.unutrition.data;

import org.apache.commons.lang3.StringUtils;

/**
 * Utilities for nutrition data
 * @author steve
 *
 */
public class NutritionDataUtils {
	
	static final char PAD_CHAR = '~'; 
	
	public NutritionDataUtils() {
	}

	/**
	 * Removes padding from nutrition data
	 * @param data
	 */
	public static void removePadding(String[] data) {
		for (int i = 0, l = data.length; i < l; ++i) {
			data[i] = StringUtils.remove(data[i], PAD_CHAR);
		}
	}
}
