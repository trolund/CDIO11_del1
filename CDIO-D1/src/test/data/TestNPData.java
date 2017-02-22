package test.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.IData;
import data.IData.DALException;
import data.NPData;
import data.UserDTO;

/**
 * Unit test of the NPData data layer.
 */
public class TestNPData {

	private IData data;

	@Before
	public void setUp() throws Exception {
		/*
		 * 4 dummy users exist in the NPData implementation.
		 * 
		 * UserDTO("0123", 12, "FM01", "pass0123", "FM", "Foreman")
		 * UserDTO("0122", 15, "Admin", "pass0122", "ADM", "Admin")
		 * UserDTO("0121", 13, "OP01", "pass0121", "OP", "Operator")
		 * UserDTO("0120", 14, "PHMC01", "pass0121", "PHMC", "Pharmacist")
		 */
		data = new NPData();
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	/**
	 * This test checks whether the getUser implementation works as intended. It
	 * utilizes binary search under the hood the find the specified user
	 * efficiently.
	 */
	@Test
	public void testgetUser() {
		/* Exists */
		try {
			data.getUser(12);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(15);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(13);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(14);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Does not exist */
		try {
			data.getUser(300);
			fail("Retrieved non-existing user!");
		} catch (DALException e) {

		}

		/* Does not exist */
		try {
			data.getUser(9999);
			fail("Retrieved non-existing user!");
		} catch (DALException e) {

		}
	}

	/**
	 * Test whether the createUser() method works correctly.
	 */
	@Test
	public void testCreateUser() {
		int expected = 0;
		try {
			expected = data.getUserList().size() + 1;
		} catch (DALException e) {
			e.printStackTrace();
		}

		UserDTO testUser = new UserDTO("232323", 253, "Test", "Test", "ttt");

		try {
			data.createUser(testUser);
		} catch (DALException e) {
			e.printStackTrace();
		}

		int actual = 0;
		try {
			actual = data.getUserList().size();
		} catch (DALException e) {
			e.printStackTrace();
		}

		assertEquals("User not inserted correctly.", expected, actual);
	}

	/**
	 * Test whether the updateUser() method works correctly.
	 */
	@Test
	public void testUpdateUser() {
		String newCpr = "0000";
		UserDTO updatedUser = new UserDTO(newCpr, 12, "FM01", "pass0123", "FM", "Foreman");

		try {
			data.updateUser(updatedUser);
		} catch (DALException e) {
			e.printStackTrace();
		}

		assertEquals("User not updated correctly.", newCpr, updatedUser.getCpr());
	}

	/**
	 * Test whether the deleteUser() method works correctly.
	 */
	@Test
	public void testDeleteUser() {
		int expected = 0;
		try {
			expected = data.getUserList().size() - 1;
		} catch (DALException e) {
			e.printStackTrace();
		}

		try {
			data.deleteUser(12);
		} catch (DALException e) {
			e.printStackTrace();
		}

		int actual = 0;
		try {
			actual = data.getUserList().size();
		} catch (DALException e) {
			e.printStackTrace();
		}

		assertEquals("User not deleted correctly.", expected, actual);
	}

}