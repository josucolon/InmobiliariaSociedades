package LN;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Sociedad implements Serializable {
	
	@PrimaryKey
	private int id;
	private String nombre;
	private int capacidadMax;
	private String direccion;
	
	@Element(column="FK_SOCIEDAD")
	ArrayList <Alquiler> alquileres= new ArrayList<Alquiler>();
	
	public Sociedad(int id, String nombre, int capacidadMax, String direccion)
	{
		this.id= id;
		this.nombre= nombre;
		this.capacidadMax= capacidadMax;
		this.direccion= direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
