package entidades;

public class Movimiento {
	private int codigo;
	private String fecha;
	private String detalle;
	private float importe;
	private Cuenta cuenta;
	private TipoMovimiento tipoMovimiento;
	
	public Movimiento() {
		
	}

	public Movimiento(int codigo, String fecha, String detalle, float importe, Cuenta cuenta,
			TipoMovimiento tipoMovimiento) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.cuenta = cuenta;
		this.tipoMovimiento = tipoMovimiento;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Movimiento [codigo=" + codigo + ", fecha=" + fecha + ", detalle=" + detalle + ", importe=" + importe
				+ ", cuenta=" + cuenta + ", tipoMovimiento=" + tipoMovimiento + "]";
	}
	
}
