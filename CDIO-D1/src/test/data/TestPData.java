package test.data;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.IData;
import data.IData.DALException;
import data.NPData;
import data.UserDTO;

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