package LN;

import java.io.Serializable;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
/**
 * Esta clase es la de Alquiler. La clase que simboliza la reserva que podran realizar los usuarios en la aplicacion.
 * @author GrupoAmuntValencia
 *
 */

@PersistenceCapable
public class Alquiler implements Serializable {
	
	@PrimaryKey
	private int id;
	private int hora;
	private int dia;
	private int mes;
	private int anyo;
	private String dniUsuario;
	private int idSociedad;
	
	/**
	 * Contructor de la clase Alquiler.
	 * @param id
	 * @param hora
	 * @param dia
	 * @param mes
	 * @param anyo
	 * @param dniUsuario
	 * @param idSociedad
	 */
	public Alquiler(int id, int hora, int dia, int mes, int anyo, String dniUsuario, int idSociedad)
	{
		this.id= id;
		this.hora= hora;
		this.dia= dia;
		this.mes= mes;
		this.anyo= anyo;
		this.dniUsuario= dniUsuario;
		this.idSociedad= idSociedad;
	}
	
	/**
	 * Contructor vacio.
	 */
	public Alquiler()
	{
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	public String getDniUsuario() {
		return dniUsuario;
	}


	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}


	public int getIdSociedad() {
		return idSociedad;
	}


	public void setIdSociedad(int idSociedad) {
		this.idSociedad = idSociedad;
	}
	
	
}
