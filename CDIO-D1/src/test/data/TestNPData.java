package test.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.IData;
import data.IData.DALException;
import data.NPData;
import data.UserDTO;

public class TestNPData {

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
	public void testgetUser() {
		/**
		 * 4 default users exist.
		 * 
		 * userStoreList.add(new UserDTO(2, "FM01", "FM", "Foreman"));
		 * userStoreList.add(new UserDTO(0, "Admin", "ADM", "Admin"));
		 * userStoreList.add(new UserDTO(3, "OP01", "OP", "Operator"));
		 * userStoreList.add(new UserDTO(1, "PHMC01", "PHMC", "Pharmacist"));
		 */

		try {
			UserDTO user = data.getUser(0);
		} catch (DALException e) {
			e.printStackTrace();
			fail("Was not able to find existing user.");
		}

		try {
			UserDTO user = data.getUser(2);
		} catch (DALException e) {
			e.printStackTrace();
			fail("Was not able to find existing user.");
		}

		try {
			UserDTO user = data.getUser(3);
		} catch (DALException e) {
			e.printStackTrace();
			fail("Was not able to find existing user.");
		}

		try {
			UserDTO u1 = data.getUser(10);
			fail("Found user that does not exist in the list.");
		} catch (DALException e) {
			//e.printStackTrace();
		}

	}

	@Test
	public void testCreateUser() {
		List<UserDTO> testList = null;

		try {
			testList = data.getUserList();
		} catch (DALException e) {
			e.printStackTrace();
		}

		int expected = testList.size() + 1;

		UserDTO user = new UserDTO("9876543", 10, "JUnit", "pass1234", "UNIT", "Tester");

		try {
			data.createUser(user);
		} catch (DALException e) {
			e.printStackTrace();
		}

		int actual = testList.size();

		assertEquals("User is not added correctly to the list.", expected, actual);
	}

	@Test
	public void testDeleteUser() {
		int expected = 0;

		try {
			expected = data.getUserList().size() - 1;
		} catch (DALException e1) {
			e1.printStackTrace();
		}

		try {
			data.deleteUser(0);
		} catch (DALException e) {
			e.printStackTrace();
		}

		int actual = 0;
		try {
			actual = data.getUserList().size();
		} catch (DALException e) {
			e.printStackTrace();
		}

		assertEquals("User is not deleted correctly from the list.", expected, actual);
	}

}