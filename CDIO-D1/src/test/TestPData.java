package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import data.IData;
import data.IData.DALException;
import data.PData;
import data.UserDTO;

/**
 * Unit test of the NPData data layer.
 */
public class TestPData {

	private IData data;

	/**
	 * Constructor to initialize test data.
	 */
	public TestPData() {
		data = new PData("test.bin");

		UserDTO u0 = new UserDTO("0000", 0, "bruger0", "password0", "u0");
		UserDTO u1 = new UserDTO("0001", 1, "bruger1", "password1", "u1");
		UserDTO u2 = new UserDTO("0002", 2, "bruger2", "password2", "u2");
		UserDTO u3 = new UserDTO("0003", 3, "bruger3", "password3", "u3");
		UserDTO u4 = new UserDTO("0004", 4, "bruger4", "password4", "u4");

		try {
			data.createUser(u0);
			data.createUser(u1);
			data.createUser(u2);
			data.createUser(u3);
			data.createUser(u4);
		} catch (DALException e) {
			e.printStackTrace();
		}
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
			data.getUser(0);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(1);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(2);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Exists */
		try {
			data.getUser(3);
		} catch (DALException e) {
			fail("Failed to retrieve existing user!");
		}

		/* Does not exist */
		try {
			data.getUser(5);
			fail("Retrieved non-existing user!");
		} catch (DALException e) {

		}

		/* Does not exist */
		try {
			data.getUser(6);
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

		UserDTO testUser = new UserDTO("232323", 0, "Test", "Test", "ttt");

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

		try {
			data.deleteUser(0);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test whether the updateUser() method works correctly.
	 */
	@Test
	public void testUpdateUser() {
		String newCpr = "0000";
		UserDTO updatedUser = new UserDTO(newCpr, 0, "FM01", "pass0123", "FM", "Foreman");

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

		assertEquals("User not deleted correctly.", expected, actual);
	}

}