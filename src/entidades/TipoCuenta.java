package entidades;

public class TipoCuenta {
	private int codigo;
	private String descripcion;
	
	public TipoCuenta() {
	
	}
	
	public TipoCuenta(int codigo) {
		this.codigo = codigo;
	}
	
	public TipoCuenta(int codigo, String descripcion) {
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
		return "TipoCuenta [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
}
