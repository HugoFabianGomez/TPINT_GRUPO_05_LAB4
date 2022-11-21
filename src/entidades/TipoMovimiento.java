package entidades;

public class TipoMovimiento {
	private int codigo;
	private String descripcion;
	
	public TipoMovimiento() {

	}

	public TipoMovimiento(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public TipoMovimiento(int i) {
		// TODO Auto-generated constructor stub
		this.codigo = i;
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
		return "TipoMovimiento [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
