package entidades;

public class Genero {
	private int codigo;
	private String descripcion;
	
	public Genero() {

	}
	
	public Genero(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public Genero(int codigo) {
		// TODO Auto-generated constructor stub
		this.codigo=codigo;
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
		return "Genero [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
