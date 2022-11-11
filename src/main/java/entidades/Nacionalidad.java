package entidades;

public class Nacionalidad {
	private int codigo;
	private String abreviatura;
	private String descripcion;
	
	public Nacionalidad() {
	
	}

	public Nacionalidad(int codigo, String abreviatura, String descripcion) {
		this.codigo = codigo;
		this.abreviatura = abreviatura;
		this.descripcion = descripcion;
	}

	public Nacionalidad(int codigo) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [codigo=" + codigo + ", abreviatura=" + abreviatura + ", descripcion=" + descripcion + "]";
	}
	
}
