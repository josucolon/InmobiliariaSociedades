

import DAO.DAO;
import LN.Usuario;
import junit.framework.TestCase;

public class DAOTest extends TestCase {

	public void testGuardarObjeto() {
		fail("Not yet implemented");
	}

	public void testLeerSociedades() {
		fail("Not yet implemented");
	}

	public void testLeerUsuarios() {
		fail("Not yet implemented");
	}

	public void testGetUser() 
	{
		Usuario a = DAO.getUser("1111");
		Usuario b = new Usuario ("1111", "abc", "julen", "martin", 1997, "j@j.com", 666);
		assertEquals(a,b);

	}

	public void testLeerAlquiler() {
		fail("Not yet implemented");
	}

	public void testAddSociedad() {
		fail("Not yet implemented");
	}

	public void testAddUsuario() 
	{
		boolean a = true;
		boolean b = DAO.addUsuario("1111", "abc", "julen", "martin", 1997, "j@j.com", 666);
		assertEquals(a,b);
	}

	public void testAddAlquiler() {
		fail("Not yet implemented");
	}

	public void testModificarSociedad() {
		fail("Not yet implemented");
	}

	public void testModificarUsuario() {
		fail("Not yet implemented");
	}

	public void testModificarAlquiler() {
		fail("Not yet implemented");
	}

	public void testEliminarSociedad() {
		fail("Not yet implemented");
	}

	public void testEliminarUsuario() {
		fail("Not yet implemented");
	}

	public void testEliminarAlquiler() {
		fail("Not yet implemented");
	}

	public void testCerrarBD() {
		fail("Not yet implemented");
	}

}
