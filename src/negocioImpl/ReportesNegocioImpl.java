package negocioImpl;

import dao.ReportesDao;
import daoImpl.ReportesDaoImpl;
import negocio.ReportesNegocio;

public class ReportesNegocioImpl implements ReportesNegocio{
	ReportesDao repDao = new ReportesDaoImpl();

	@Override
	public int cantidadClientes() {
		return repDao.cantidadClientes();
	}

	@Override
	public float ingresosTotales() {
		return repDao.ingresosTotales();
	}
}
