package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CuotaDao;
import entidades.Cuota;

public class CuotaDaoImpl implements CuotaDao{
	private Conexion cn;

	public boolean insertar(Cuota cuota) {
		boolean estado=true;
		try
		 {

		cn = new Conexion();
		cn.Open();	
		
		for(int i=0;i<cuota.getNumeroCuota();i++) {
			int numeroCuota = i+1;
			
		String query = "INSERT INTO Cuotas (nro_prestamo,nro_cuota,importe_cuota,saldo_cuota,codigo_estado_cuota,estado) VALUES"+
						"("+cuota.getNumeroPrestamo()+","+numeroCuota+","+cuota.getImporteCuota()+","+cuota.getImporteCuota()+",1,1)";
		System.out.println(query);
			estado=cn.execute(query);
		}
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}
	
	@Override
	public ArrayList<Cuota> obtenerCuotasPrestamo(int nroPrestamo) {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuota> list = new ArrayList<Cuota>();
		 try
		 {
			 ResultSet rs= cn.query("SELECT * FROM Cuotas C\r\n" + 
					"INNER JOIN EstadosCuotas EC ON C.codigo_estado_cuota = EC.codigo_estado\r\n" + 
			 		"WHERE C.Estado = 1 AND C.nro_prestamo = " + nroPrestamo);
			 while(rs.next())
			 {
				 Cuota cuota = new Cuota();
				 cuota.setCodigoCuota(rs.getInt("C.codigo_cuota"));
				 cuota.setNumeroPrestamo(rs.getInt("C.nro_prestamo"));
				 cuota.setNumeroCuota(rs.getInt("C.nro_cuota"));
				 cuota.setImporteCuota(rs.getFloat("C.importe_cuota"));
				 cuota.setSaldoCuota(rs.getFloat("C.saldo_cuota"));
				 cuota.setEstadoCuota(rs.getString("EC.estado"));
				 list.add(cuota);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}
}
