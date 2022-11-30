package CreandoException;

public class DniInvalido extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DniInvalido() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "El DNI ingresado ya existe en el sistema";
	}
	
	

}
