package entidades;

public class Usuario {
	private String nombre;
	private String contrasena;
	private TipoUsuario tipoUsuario;
	private Boolean estado;
	
	public Usuario() {
	
	}

	public Usuario(String nombre, String contrasena, TipoUsuario tipoUsuario, Boolean estado) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasena=" + contrasena + ", tipoUsuario=" + tipoUsuario + ", estado="
				+ estado + "]";
	}
	
}
