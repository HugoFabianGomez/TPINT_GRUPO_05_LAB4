package entidades;

public class Provincia {
	private int codigo;
	private String descripcion;
	
	public Provincia() {

	}

	public Provincia(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Provincia [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
}
