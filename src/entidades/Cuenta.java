package entidades;

public class Cuenta {
	private int numeroCuenta;
	private int cbu;
	private String fechaCreacion;
	private float saldo;
	private boolean estado;
	private TipoCuenta tipoCuenta;
	private Cliente cliente;
	
	public Cuenta() {
		tipoCuenta = new TipoCuenta();
		cliente = new Cliente();
	}

	public Cuenta(int numeroCuenta, int cbu, String fechaCreacion, float saldo, boolean estado, TipoCuenta tipoCuenta,
			Cliente cliente) {
		this.numeroCuenta = numeroCuenta;
		this.cbu = cbu;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
		this.estado = estado;
		this.tipoCuenta = tipoCuenta;
		this.cliente = cliente;
	}

	public Cuenta(int cuenta) {
		// TODO Auto-generated constructor stub
		this.numeroCuenta = cuenta;
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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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
