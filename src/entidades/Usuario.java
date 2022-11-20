package entidades;

public class Usuario {
	private String nombreUsuario;
	private String contrasenia;
	private TipoUsuario tipoUsuario;
	private boolean estado;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombreusuario, String contrasenia, TipoUsuario tipousuario, boolean estado) {
		// TODO Auto-generated constructor stub
		this.nombreUsuario=nombreusuario;
		this.contrasenia=contrasenia;
		this.tipoUsuario=tipousuario;
		this.estado=estado;
	}
	public Usuario(String nombreusuario) {
		// TODO Auto-generated constructor stub
		this.nombreUsuario=nombreusuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasena) {
		this.contrasenia = contrasena;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrasenia=" + contrasenia + ", tipoUsuario="
				+ tipoUsuario + ", estado=" + estado + "]";
	}

	public void getTipoUsuario(TipoUsuario tipousu) {
		// TODO Auto-generated method stub
		this.tipoUsuario = tipousu;
		
	}
	
	
}
