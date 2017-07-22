package io.lofrattini.pghelper;


import io.lofrattini.pghelper.DatabaseSource;

import org.junit.Assert;
import org.junit.Test;


public class DatabaseSourceTest {
	
	@Test
	public void testHappyPath() {
		String url = "postgres://test:12345678@test.ccdvgotkeq3f.eu-west-2.rds.amazonaws.com:5432/my-database";
		DatabaseSource s = new DatabaseSource(url);
		Assert.assertEquals("test", s.getUsername());
		Assert.assertEquals("12345678", s.getPassword());
		Assert.assertEquals("test.ccdvgotkeq3f.eu-west-2.rds.amazonaws.com", s.getHost());
		Assert.assertEquals(5432, (int)s.getPort());
		Assert.assertEquals("my-database", s.getDatabase());
		Assert.assertEquals(url, s.getUri());
	}

}
