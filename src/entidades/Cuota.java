package entidades;

public class Cuota {
	private int codigoCuota;
	private int numeroCuota;
	private int numeroPrestamo;
	private float importeCuota;
	private float saldoCuota;
	private String fechaVencimiento;
	private String estadoCuota;
	
	public Cuota() {
	}
	
	public String getEstadoCuota() {
		return estadoCuota;
	}

	public void setEstadoCuota(String estadoCuota) {
		this.estadoCuota = estadoCuota;
	}

	public float getSaldoCuota() {
		return saldoCuota;
	}

	public void setSaldoCuota(float saldoCuota) {
		this.saldoCuota = saldoCuota;
	}

	public int getCodigoCuota() {
		return codigoCuota;
	}
	public void setCodigoCuota(int codigoCuota) {
		this.codigoCuota = codigoCuota;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public int getNumeroPrestamo() {
		return numeroPrestamo;
	}
	public void setNumeroPrestamo(int numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}
	public float getImporteCuota() {
		return importeCuota;
	}
	public void setImporteCuota(float importeCuota) {
		this.importeCuota = importeCuota;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
}
