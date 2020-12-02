

//import org.junit.Test;

import DAO.DAO;
import LN.Usuario;
import junit.framework.TestCase;

public class DAOTest extends TestCase {

//	@Test
//	public void testGuardarObjeto() {
//		fail("Not yet implemented");
//
//	}
	
//	@Test
//	public void testLeerSociedades() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLeerUsuarios() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetUser() 
//	{
//		Usuario a = DAO.getUser("1111");
//		System.out.println(a.getDni());
//		System.out.println(a.getPassword());
//		System.out.println(a.getAnoNac());
//		System.out.println(a.getApellido());
//		System.out.println(a.getNombre());
//		System.out.println(a.getCorreo());
//		System.out.println(a.getTlf());
//		Usuario b = new Usuario ("1111", "abc", "julen", "martin", 1997, "j@j.com", 666);
//		assertEquals(a,b);
//
//	}
//
//	@Test
//	public void testLeerAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddSociedad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
	public void testAddUsuario() 
	{
		boolean a = true;
		boolean b = DAO.addUsuario("11111", "abcd", "julenn", "martinn", 19972, "j@j.com", 6666);
		assertEquals(a,b);
	}
//
//	@Test
//	public void testAddAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModificarSociedad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModificarUsuario() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModificarAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEliminarSociedad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
	public void testEliminarUsuario() 
	{
		boolean a = true;
		boolean b = DAO.eliminarUsuario("1111");
		System.out.println(b);
		assertEquals(a,b);
	}
//
//	@Test
//	public void testEliminarAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCerrarBD() {
//		fail("Not yet implemented");
//	}

}
