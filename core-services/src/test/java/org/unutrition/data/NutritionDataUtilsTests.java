package org.unutrition.data;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class NutritionDataUtilsTests {

	@Test
	public void testRemovePadding() {
		String[] data = {"~05049~^~0500~^~Chicken, broilers or fryers, back, meat and skin, cooked, fried, batter~^~CHICKEN,BROILERS OR FRYERS,BACK,MEAT&SKN,CKD,FRIED,BATTER~^~~^~~^~~^~Bone~^23^~~^6.25^4.27^9.02^3.87"};
		String[] rdata = {"05049^0500^Chicken, broilers or fryers, back, meat and skin, cooked, fried, batter^CHICKEN,BROILERS OR FRYERS,BACK,MEAT&SKN,CKD,FRIED,BATTER^^^^Bone^23^^6.25^4.27^9.02^3.87"};
		
		NutritionDataUtils.removePadding(data);
		
		for (int i = 0, l = data.length; i < l; ++i) {
			assertTrue(data[i].equals(rdata[i]));
		}
	}

}
