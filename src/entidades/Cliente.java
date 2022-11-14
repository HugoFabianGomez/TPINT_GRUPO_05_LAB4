package entidades;

public class Cliente {
	private int dni;
	private int cuil;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String domicilio;
	private String email;
	private String telefono;
	private Usuario usuario;
	private Nacionalidad nacionalidad;
	private String nombreCompleto;
	private Provincia provincia;
	private Localidad localidad;
	private Genero genero;
	private boolean estado;
	
	public Cliente() {
		
	}
	
	public Cliente(int dni) {
		this.dni = dni;
	}

	public Cliente(int dni, int cuil, String nombre, String apellido, String fechaNacimiento, String domicilio,
			String email, String telefono, boolean estado, Usuario usuario, Nacionalidad nacionalidad, Provincia provincia, Localidad localidad,
			Genero genero) {
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
		this.usuario = usuario;
		this.nacionalidad = nacionalidad;
		this.provincia = provincia;
		this.localidad = localidad;
		this.genero = genero;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", cuil=" + cuil + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", email=" + email
				+ ", telefono=" + telefono + ", nacionalidad=" + nacionalidad
				+ ", provincia=" + provincia + ", localidad=" + localidad + ", genero=" + genero + ", estado=" + estado
				+ "]";
	}
}
