package COMUN;

public class clsUsuarioRepetido extends Exception
{
	private static final long serialVersionUID = 1L;

	private final String MENSAJE = "Error - Ya existe un cliente con el mismo DNI";
	
	public String getMessage()
	{
		return MENSAJE;
	}
}

