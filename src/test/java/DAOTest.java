

//import org.junit.Test;

import org.datanucleus.store.types.wrappers.ArrayList;
import org.junit.runner.RunWith;

import DAO.DAO;
import LN.Sociedad;
import LN.Usuario;
import junit.framework.TestCase;

/**
 * Clase de testeo del dao. 
 * @author GrupoAmuntValencia
 *
 */
//@RunWith(MockitoJUnitRunner.class)
public class DAOTest extends TestCase {

//	@Test
//	public void testGuardarObjeto() {
//		fail("Not yet implemented");
//
//	}
	
//	@Test
	public void testLeerSociedades() 
	{
		java.util.ArrayList<Sociedad> sociedades = DAO.LeerSociedades();
		assertFalse(sociedades.isEmpty());
	}
//
//	@Test
	public void testLeerUsuarios() 
	{
		java.util.ArrayList<Usuario> usuarios =  DAO.LeerUsuarios();
		assertFalse(usuarios.isEmpty());
	}
//
//	@Test
	public void testGetUser() 
	{
		Usuario a = DAO.getUser("00");
		Usuario b = new Usuario ("00", "abc", "julen", "martin", 1997, "j@j.com", 666);
		assertEquals(a.getDni(),b.getDni());
	}
//
//	@Test
//	public void testLeerAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
	public void testAddSociedad() 
	{		
		boolean a = true;
		boolean b = DAO.addSociedad(14, "lizardi", 10, "sanse");
		assertEquals(a,b);
	}
//
//	@Test
	public void testAddUsuario() 
	{
		boolean a = true;
		boolean b = DAO.addUsuario("1234ab", "abcd", "julenn", "martinn", 19972, "j@j.com", 6666);
		assertEquals(a,b);
	}
//
//	@Test
//	public void testAddAlquiler() 
//	{
//		boolean a = true;
//		boolean b = DAO.addAlquiler(2, 1, 1, 1, 1, "00", 13);
//		assertEquals(a,b);
//	}
//
//	@Test
	public void testModificarUsuario() 
	{
		boolean a = true;
		boolean b = DAO.modificarUsuario("aa", "abcde", "jos", "migu", 1, "j@j.com", 66);
		assertEquals(a,b);
	}
//
//	@Test
	public void testModificarSociedad() 
	{
		boolean a = true;
		boolean b = DAO.modificarSociedad(13, "kresala", 20, "tolo");
		assertEquals(a,b);
	}
//
//	@Test
//	public void testModificarAlquiler() {
//		fail("Not yet implemented");
//	}
//
//	@Test
	public void testEliminarSociedad() 
	{
		boolean a = true;
		boolean b = DAO.eliminarSociedad(12);
		assertEquals(a,b);
	}
//
//	@Test
	public void testEliminarUsuario() 
	{
		boolean a = true;
		boolean b = DAO.eliminarUsuario("a");
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
