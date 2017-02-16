package test.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.IData;
import data.NPData;

public class TestPData {

	private IData data;

	@Before
	public void setUp() throws Exception {
		data = new NPData();
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	public void test() {

	}

}