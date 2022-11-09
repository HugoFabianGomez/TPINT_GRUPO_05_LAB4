package entidades;

public class Cuenta {
	private int numeroCuenta;
	private int cbu;
	private String fechaCreacion;
	private float saldo;
	private Boolean estado;
	private TipoCuenta tipoCuenta;
	private Cliente cliente;
	
	public Cuenta() {

	}

	public Cuenta(int numeroCuenta, int cbu, String fechaCreacion, float saldo, Boolean estado, TipoCuenta tipoCuenta,
			Cliente cliente) {
		this.numeroCuenta = numeroCuenta;
		this.cbu = cbu;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.estado = estado;
		this.tipoCuenta = tipoCuenta;
		this.cliente = cliente;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public int getCbu() {
		return cbu;
	}

	public void setCbu(int cbu) {
		this.cbu = cbu;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", cbu=" + cbu + ", fechaCreacion=" + fechaCreacion + ", saldo="
				+ saldo + ", estado=" + estado + ", tipoCuenta=" + tipoCuenta + ", cliente=" + cliente + "]";
	}
	
}
