package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import dao.MovimientoDao;
import entidades.Cuenta;
import entidades.Movimiento;
import entidades.TipoMovimiento;

public class MovimientoDaoImpl implements MovimientoDao {
	
	private Conexion cn;
	/**
	 *
	 */
	@Override
	public ArrayList<Movimiento> obtenerTodos() {
		// TODO Auto-generated method stub
		
		System.out.println("Entre ArrayList<Movimiento> obtenerTodos()");
		cn = new Conexion();
		cn.Open();
		 ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 ResultSet rs= cn.query("select * from movimientos inner join cuentas on movimientos.numero_cuenta_MOV = cuentas.numero_cuenta_CU\r\n"
			 		+ "inner join tiposmovimiento on movimientos.codigo_tipo_movimiento_MOV = tiposmovimiento.codigo_tipo_movimiento_TMOV\r\n"
			 		+ "group by codigo_movimiento_MOV;");
			 while(rs.next())
			 {
				 Movimiento mov = new Movimiento();
				 mov.setCodigo(rs.getInt("movimientos.codigo_movimiento_MOV"));
				 mov.setFecha(rs.getString("movimientos.fecha_MOV"));
				 mov.setDetalle(rs.getString("movimientos.detalle_MOV"));
				 mov.setImporte(rs.getFloat("movimientos.importe_MOV"));
				 
				 Cuenta cta = new Cuenta();
				 cta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cta.setCbu(rs.getInt("cuentas.cbu_CU"));
				 
				 mov.setCuenta(cta);
				 
				 TipoMovimiento tmov = new TipoMovimiento();
				 tmov.setCodigo(rs.getInt("tiposmovimiento.codigo_tipo_movimiento_TMOV"));
				 tmov.setDescripcion(rs.getString("tiposmovimiento.descripcion_TMOV"));
				 
				 mov.setTipoMovimiento(tmov);
				 
				 
				 
				 
				 
				 
				 
				
				 
				 list.add(mov);
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
	@Override
	public boolean agregar(Movimiento movi) {
		// TODO Auto-generated method stub		
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "insert into movimientos( fecha_MOV, detalle_MOV, importe_MOV,    numero_cuenta_MOV,                                codigo_tipo_movimiento_MOV) \r\n"
				+ " values( curdate(), '"+movi.getDetalle() +"', "+ movi.getImporte()+", "+ movi.getCuenta().getNumeroCuenta() +", "+ movi.getTipoMovimiento().getCodigo() +");";
		String sumar = "update Cuentas set saldo_CU = (\r\n"
				+ "    select sum(importe_MOV) from movimientos where numero_cuenta_MOV = "+ movi.getCuenta().getNumeroCuenta() +") \r\n"
				+ "    where numero_cuenta_CU = "+ movi.getCuenta().getNumeroCuenta() +";";
		
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
			if(estado == true) {
				estado=cn.execute(sumar);
			}
			System.out.println("llego al try catch estado= "+estado);
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
	public ArrayList<Movimiento> obtenerTodosUsuario(String Usuario) {
		// TODO Auto-generated method stub
		
		System.out.println("Entre movDaiImpl ArrayList<Movimiento> obtenerTodosUsuario(usuario)");
		cn = new Conexion();
		cn.Open();
		 ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes inner join cuentas on dni_cli = dni_cliente_cu\r\n"
			 		+ "inner join movimientos on numero_cuenta_cu = numero_cuenta_mov \r\n"
			 		+ "inner join tiposmovimiento on codigo_tipo_movimiento_TMOV = codigo_tipo_movimiento_MOV\r\n"
			 		+ "where nombre_usuario_cli = '"+ Usuario +"'");
			 while(rs.next())
			 {
				 Movimiento mov = new Movimiento();
				 mov.setCodigo(rs.getInt("codigo_movimiento_MOV"));
				 mov.setFecha(rs.getString("fecha_MOV"));
				 mov.setDetalle(rs.getString("movimientos.detalle_MOV"));
				 mov.setImporte(rs.getFloat("movimientos.importe_MOV"));
				 
				 Cuenta cta = new Cuenta();
				 cta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cta.setCbu(rs.getInt("cuentas.cbu_CU"));
				 System.out.println("Cuenta.Cbu "+cta.getCbu());
				 
				 mov.setCuenta(cta);
				 
				 TipoMovimiento tmov = new TipoMovimiento();
				 tmov.setCodigo(rs.getInt("codigo_tipo_movimiento_TMOV"));
				 tmov.setDescripcion(rs.getString("descripcion_TMOV"));
				 mov.setTipoMovimiento(tmov);
				 list.add(mov);
				 System.out.println(mov.toString());
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
