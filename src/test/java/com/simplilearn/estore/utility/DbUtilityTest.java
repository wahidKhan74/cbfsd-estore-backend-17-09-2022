package com.simplilearn.estore.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbUtilityTest {

	DBUtility db = null;
	
	@BeforeEach
	public void setUp() {
		db = DBUtility.getDBUtility();
	}
	
	@AfterEach
	public void cleanUp() {
		db.destroy();
		db= null;
	}
	
	@Test
	public void testConnection() {
		db.init();
	}
}
