package entidades;

public class Localidad {
	private int codigo;
	private Provincia provincia;
	private String descripcion;
	
	public Localidad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Localidad(int codigo, Provincia provincia, String descripcion) {
		super();
		this.codigo = codigo;
		this.provincia = provincia;
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Localidad [codigo=" + codigo + ", provincia=" + provincia + ", descripcion=" + descripcion + "]";
	}
	
}
