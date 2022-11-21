package entidades;

public class Prestamo {
	private int codigo;
	private String fecha;
	private float importePagar;
	private float importePedido;
	private int plazoMeses;
	private float intereses;
	private float importeCuota;
	private boolean otorgado;
	private boolean estado;
	private String motivoRechazo;
	private Cliente cliente;
	private Cuenta cuenta;
	
	public Prestamo() {
		
	}

	public Prestamo(int codigo, String fecha, float importePagar, float importePedido, int plazoMeses, float intereses,
			float importeCuota, boolean otorgado, boolean estado, String motivoRechazo, Cliente cliente) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.importePagar = importePagar;
		this.importePedido = importePedido;
		this.plazoMeses = plazoMeses;
		this.intereses = intereses;
		this.importeCuota = importeCuota;
		this.otorgado = otorgado;
		this.estado = estado;
		this.motivoRechazo = motivoRechazo;
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getImportePagar() {
		return importePagar;
	}

	public void setImportePagar(float importePagar) {
		this.importePagar = importePagar;
	}

	public float getImportePedido() {
		return importePedido;
	}

	public void setImportePedido(float importePedido) {
		this.importePedido = importePedido;
	}

	public int getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public float getIntereses() {
		return intereses;
	}

	public void setIntereses(float intereses) {
		this.intereses = intereses;
	}

	public float getImporteCuota() {
		return importeCuota;
	}

	public void setImporteCuota(float importeCuota) {
		this.importeCuota = importeCuota;
	}

	public boolean getOtorgado() {
		return otorgado;
	}

	public void setOtorgado(boolean otorgado) {
		this.otorgado = otorgado;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Prestamo [codigo=" + codigo + ", fecha=" + fecha + ", importePagar=" + importePagar + ", importePedido="
				+ importePedido + ", plazoMeses=" + plazoMeses + ", intereses=" + intereses + ", importeCuota="
				+ importeCuota + ", otorgado=" + otorgado + ", estado=" + estado + ", motivoRechazo=" + motivoRechazo
				+ ", cliente=" + cliente + "]";
	}
	
}
