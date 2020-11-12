package LN;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Usuario implements Serializable {
	
	@PrimaryKey
	private String dni;
	private String password;
	private String nombre;
	private String apellido;
	private int anoNac;	
	private String correo;
	private int tlf;
	
	@Element(column="FK_USUARIO")
	ArrayList <Alquiler> alquileres= new ArrayList<Alquiler>();
	
	public Usuario(String dni, String password, String nombre, String apellido, int anoNac, String correo, int tlf)
	{
		this.dni= dni;
		this.password=password;
		this.nombre= nombre;
		this.apellido= apellido;
		this.anoNac= anoNac;
		this.correo= correo;
		this.tlf= tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getAnoNac() {
		return anoNac;
	}

	public void setAnoNac(int anoNac) {
		this.anoNac = anoNac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	
	
	
	
}