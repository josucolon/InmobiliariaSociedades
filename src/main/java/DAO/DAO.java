package DAO;

import java.util.ArrayList;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import LN.Usuario;
import LN.Sociedad;
import LN.Alquiler;
/**
 * Esta es la clase DAO. Aqui se encuentran los metodos de principales de la aplicacion para modificar, añadir, leer o eliminar información de la BD.
 * @author GrupoAmuntValencia
 *
 */
public class DAO {
	
	
	private static PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	private static PersistenceManager persistentManager =  persistentManagerFactory.getPersistenceManager();
	private static Transaction transaction = persistentManager.currentTransaction();;
	
	/**
	 * Metodo generico para guardar un objeto.
	 * @param object
	 */
	public static void GuardarObjeto (Object object)
	{
		
		
		transaction = null;
		try {

			//persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			//persistentManager = persistentManagerFactory.getPersistenceManager();		
			transaction = DAO.persistentManager.currentTransaction();				

			transaction.begin();

			persistentManager.makePersistent(object);

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive() && transaction != null) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
	}
	
	/**
	 * Metodo que lee las sociedades guardadas en la BD.
	 * @return devuelve un ArrayList con todas las sociedades.
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Sociedad> LeerSociedades ()
	{
	
		
		ArrayList<Sociedad> sociedades= new ArrayList<Sociedad> ();
		
		try {			

			transaction.begin();

			@SuppressWarnings("rawtypes")
			Extent<Sociedad> extent = (Extent) persistentManager.getExtent(Sociedad.class, true);
			
			for (Sociedad soc : extent)
			{
				sociedades.add (soc);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
	
		return sociedades;
	}

	/**
	 * Metodo que lee los usuarios guardados en la BD.
	 * @return devuelve un ArrayList con todas los usuarios.
	 */
	public static ArrayList<Usuario> LeerUsuarios ()
	{
	
		
		ArrayList<Usuario> usuarios= new ArrayList<Usuario> ();
		
		try {				

			transaction.begin();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			Extent<Usuario> extent = (Extent) persistentManager.getExtent(Usuario.class, true);
			
			for (Usuario usuario : extent)
			{
				usuarios.add (usuario);
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
	
		return usuarios;
	}
	/**
	 * Metodo que recoge el usuario que se se encuentra utilizando la aplicacion.
	 * @param dni
	 * @return devuelve el usuario.
	 */
	public static Usuario getUser (String dni)
	{
	
		
		Usuario user= new Usuario();
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario> ();
		
		try {				

			transaction.begin();

			@SuppressWarnings({ "unchecked", "rawtypes" })
			Extent<Usuario> extent = (Extent) persistentManager.getExtent(Usuario.class, true);
			
			for (Usuario usuario : extent)
			{
				if (usuario.getDni().equals(dni))
				{
					return usuario;
					
				}
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
	
		return user;
	}
/**
 * Metodo que lee las reservas de la BD que tiene el usuario que está utilizando la aplicación 
 * @param dni
 * @return devuelve un ArrayList con todas las reservas del usuario.
 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<Alquiler> LeerAlquiler (String dni)
	{
	
		
		ArrayList<Alquiler> alquileres= new ArrayList<Alquiler> ();
		
		try {				

			transaction.begin();

			@SuppressWarnings("unchecked")
			Extent<Alquiler> extent = (Extent) persistentManager.getExtent(Alquiler.class, true);
			
			for (Alquiler alquiler : extent)
			{
				if(alquiler.getDniUsuario()==dni)
				{
					alquileres.add (alquiler);
				}
				
			}

			transaction.commit();

		} catch(Exception ex) {
			System.err.println("* Exception reading data from db: " + ex.getMessage());
		} finally {		    
			if (transaction.isActive()) 
			{
				transaction.rollback();
			}   
			persistentManager.close();
		}	
		
		return alquileres;
	}
	/**
	 * Metodo que guarda una sociedad en la BD.
	 * @param id
	 * @param nombre
	 * @param capacidadMax
	 * @param direccion
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	public static boolean addSociedad (int id, String nombre, int capacidadMax, String direccion)
	{
		try{
			Sociedad sociedad = new Sociedad(id, nombre, capacidadMax, direccion);
			persistentManager.makePersistent(sociedad);
			return true;
		}catch(Exception e){
			System.err.println("Excepcion al introducir una nueva sociedad en la BD: " + e.getMessage()); 
			return false;
		}
		finally{
			if(transaction.isActive()){
				transaction.rollback();
			}
			
			persistentManager.close();
		}
	}
	
	/**
	 * Metodo que añade a la BD un usuario.
	 * @param dni
	 * @param password
	 * @param nombre
	 * @param apellido
	 * @param anoNac
	 * @param correo
	 * @param tlf
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	public static boolean addUsuario (String dni, String password, String nombre, String apellido, int anoNac, String correo, int tlf)
	{
		try{
			Usuario usuario = new Usuario(dni, password, nombre, apellido, anoNac, correo, tlf);
			persistentManager.makePersistent(usuario);
			return true;
		}catch(Exception e){
			System.err.println("Excepcion al introducir un nuevo usuario en la BD: " + e.getMessage());   
			return false;
		}
		finally{
			if(transaction.isActive()){
				transaction.rollback();
			}
//			System.out.println("pruebaaaa");
			persistentManager.close();
		}
		
	}
	
	/**
	 * Metodo que añade uan resrva a la BD.
	 * @param id
	 * @param hora
	 * @param dia
	 * @param mes
	 * @param anyo
	 * @param dniUsuario
	 * @param idSociedad
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	public static boolean addAlquiler (int id, int hora, int dia, int mes, int anyo, String dniUsuario, int idSociedad)
	{
		try{
			Alquiler alquiler = new Alquiler(id, hora, dia, mes, anyo, dniUsuario, idSociedad);
			persistentManager.makePersistent(alquiler);
			return true;
		}catch(Exception e){
			System.err.println("Excepcion al introducir un nuevo alquiler en la BD: " + e.getMessage());     
		}
		finally{
			if(transaction.isActive()){
				transaction.rollback();
			}
			
			persistentManager.close();
		}
		return false;
	}
	
	/**
	 * Metodo que modifica una sociedad en la BD.
	 * @param id
	 * @param nombre
	 * @param capacidadMax
	 * @param direccion
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean modificarSociedad(int id, String nombre, int capacidadMax, String direccion)
	{
		Extent<Sociedad> extent = (Extent) persistentManager.getExtent(Sociedad.class, false);
		ArrayList<Sociedad> sociedades= new ArrayList<Sociedad>();
		int idNuevo;
		int idMod = id;
		for(Sociedad s: extent)
		{
			sociedades.add(s);
		}
		extent.closeAll();
		
		try{
			for(Sociedad s: sociedades)
			{
				idNuevo= s.getId();
				if(idNuevo == idMod)
				{
					Sociedad soc= persistentManager.getObjectById(Sociedad.class, idMod);
					soc.setNombre(nombre);
					soc.setCapacidadMax(capacidadMax);
					soc.setDireccion(direccion);
					return true;
				}else{
					System.out.println("No existe la sociedad que desea modificar");
				}
			}
		}finally{}
		return false;
	}
	
	/**
	 * Metodo que modifica un usuario en la BD.
	 * @param dni
	 * @param password
	 * @param nombre
	 * @param apellido
	 * @param anoNac
	 * @param correo
	 * @param tlf
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean modificarUsuario( String dni, String password, String nombre, String apellido, int anoNac, String correo, int tlf)
	{
		Extent<Usuario> extent = (Extent) persistentManager.getExtent(Usuario.class, false);
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		String dniNuevo;
		String dniMod = dni;
		for(Usuario u: extent)
		{
			usuarios.add(u);
		}
		extent.closeAll();
		
		try{
			for(Usuario u: usuarios)
			{
				dniNuevo= u.getDni();
				if(dniNuevo.equals(dniMod))
				{
					Usuario user = persistentManager.getObjectById(Usuario.class, dniMod);
					user.setPassword(password);
					user.setNombre(nombre);
					user.setApellido(apellido);
					user.setAnoNac(anoNac);
					user.setCorreo(correo);
					user.setTlf(tlf);
					return true;
				}else{
					System.out.println("No existe el usuario que desea modificar");
				}
			}
		}finally{}
		return false;
	}
	
	/**
	 * Metodo para modificar una resrva de la BD.
	 * @param id
	 * @param hora
	 * @param dia
	 * @param mes
	 * @param anyo
	 * @param dniUsuario
	 * @param idSociedad
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean modificarAlquiler( int id, int hora, int dia, int mes, int anyo, String dniUsuario, int idSociedad)
	{
		Extent<Alquiler> extent = (Extent) persistentManager.getExtent(Alquiler.class, false);
		ArrayList<Alquiler> alquileres= new ArrayList<Alquiler>();
		int idNuevo;
		int idMod = id;
		for(Alquiler a: extent)
		{
			alquileres.add(a);
		}
		extent.closeAll();
		
		try{
			for(Alquiler a: alquileres)
			{
				idNuevo= a.getId();
				if(idNuevo == idMod)
				{
					Alquiler alq= persistentManager.getObjectById(Alquiler.class, idMod);
					alq.setHora(hora);
					alq.setDia(dia);
					alq.setMes(mes);
					alq.setAnyo(anyo);
					alq.setDniUsuario(dniUsuario);
					alq.setIdSociedad(idSociedad);
					return true;
				}else{
					System.out.println("No existe el alquiler que desea modificar");
				}
			}
		}finally{}
		return false;
	}
	
	/**
	 * Metodo para eliminar una sociedad de la BD.
	 * @param id
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean eliminarSociedad(int id)
	{
		Extent<Sociedad> extent = (Extent) persistentManager.getExtent(Sociedad.class, false);
		ArrayList<Sociedad> sociedades= new ArrayList<Sociedad>();
		int idNuevo;
		int idMod = id;
		for(Sociedad s: extent)
		{
			sociedades.add(s);
		}
		extent.closeAll();
		
		try{
			for(Sociedad s: sociedades)
			{
				idNuevo= s.getId();
				if(idNuevo == idMod)
				{
					Sociedad soc= persistentManager.getObjectById(Sociedad.class, idMod);
					persistentManager.deletePersistent(soc);
					return true;
					
				}else{
					System.out.println("No existe la sociedad que desea modificar");
//					return false;
				}
			}
		}finally{}
		return false;
	}
	
	/**
	 * Metodo para eliminar un usuario de la BD.
	 * @param dni
	 * @return devuelve un true si es correcto y un flase en caso contrario.
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean eliminarUsuario( String dni)
	{
		Extent<Usuario> extent = (Extent) persistentManager.getExtent(Usuario.class, false);
		ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
		String dniNuevo;
		String dniMod = dni;
		for(Usuario u: extent)
		{
			usuarios.add(u);
		}
		extent.closeAll();
		
		try{
			for(Usuario u: usuarios)
			{
				dniNuevo= u.getDni();
				if(dniNuevo.equals(dniMod))
				{
					Usuario user= persistentManager.getObjectById(Usuario.class, dniMod);
					persistentManager.deletePersistent(user);
					return true;
				}else{
					System.out.println("No existe el usuario que desea modificar");
//					return false;
				}
			}
		}finally{}
		return false;
	}
	
	/**
	 * Metodo para eliminar una reserva de la BD.
	 * @param id
	 */
	public static void eliminarAlquiler( int id)
	{
		Extent<Alquiler> extent = (Extent) persistentManager.getExtent(Alquiler.class, false);
		ArrayList<Alquiler> alquileres= new ArrayList<Alquiler>();
		int idNuevo;
		int idMod = id;
		for(Alquiler a: extent)
		{
			alquileres.add(a);
		}
		extent.closeAll();
		
		try{
			for(Alquiler a: alquileres)
			{
				idNuevo= a.getId();
				if(idNuevo == idMod)
				{
					Alquiler alq= persistentManager.getObjectById(Alquiler.class, idMod);
					persistentManager.deletePersistent(alq);
				}else{
					System.out.println("No existe el alquiler que desea modificar");
				}
			}
		}finally{}
	}
	
	/**
	 * Metodo para cerrar la BD.
	 */
	public static void cerrarBD()
	{
		if (persistentManager != null && !persistentManager.isClosed()) 
		{
			persistentManager.close();
		}
	}

}

