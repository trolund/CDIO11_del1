package test.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.IData;
import data.NPData;
import logic.ILogic;
import logic.Logic;

/**
 * Unit test of the Logic, logic layer.
 */
public class TestLogic {

	private ILogic logic;
	private IData data;

	@Before
	public void setUp() throws Exception {
		data = new NPData();
		logic = new Logic(data);
	}

	@After
	public void tearDown() throws Exception {
		data = null;
		logic = null;
	}

	@Test
	public void testsmt() {

	}

}