package entidades;

public class Error {
	private int id;
	private String Usuario;
	private String Fecha;
	private String Descripcion;
	private Error error;
	
	public String getFecha() {
		return Fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		this.Usuario = usuario;
	}
	public void setFecha(String fecha) {
		this.Fecha = fecha;
	}
	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public Error() {

	}
	public Error(String usuario,String fecha,String descripcion) {
		this.Usuario = usuario;
		this.Fecha = fecha;
		this.Descripcion = descripcion;

	}
	
}