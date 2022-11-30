package CreandoException;

public class UsuarioExistente extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioExistente() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "El usuario ingresado ya se encuentra en uso";
	}
	
	

}
