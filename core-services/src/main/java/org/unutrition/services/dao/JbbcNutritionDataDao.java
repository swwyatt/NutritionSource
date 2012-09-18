package org.unutrition.services.dao;

import java.sql.BatchUpdateException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JbbcNutritionDataDao extends JdbcDaoSupport implements NutritionDataDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JbbcNutritionDataDao.class);

	public void addFoodDescription(List<Object[]> descriptions) {
		String sql = "insert into FOOD_DES (NDB_No,FdGrp_Cd,Long_Desc,Shrt_Desc,ComName,ManufacName,Survey,Ref_desc,Refuse,SciName,N_Factor,Pro_Factor,Fat_Factor,CHO_Factor) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
		try {
			this.getJdbcTemplate().batchUpdate(sql, descriptions);
		} catch (Exception e) {
			if (e instanceof BatchUpdateException) {
				BatchUpdateException ee = (BatchUpdateException)e;
				SQLException se = null;
				while ((se = ee.getNextException()) != null) {
					se.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<String> listFoodDescription() {
		String sql = "select * from FOOD_DES";
		
		List<String> result = this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> result = new ArrayList<String>();
				while (rs.next()) {
					String s = rs.getString(2);
					result.add(s);
				}
				return result;
			}
			
		});
		
		return result;
	}

}
