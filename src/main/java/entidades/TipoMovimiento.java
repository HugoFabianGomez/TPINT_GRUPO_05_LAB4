package entidades;

public class TipoMovimiento {
	private int codigo;
	private int descripcion;
	
	public TipoMovimiento() {

	}

	public TipoMovimiento(int codigo, int descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoMovimiento [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
