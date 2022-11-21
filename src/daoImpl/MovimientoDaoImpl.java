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
		
		System.out.println("Entre en 	public ArrayList<Movimiento> obtenerTodos()");
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
				 
				 
				 
				 
				 
				 
				 
				/* Cliente cli = new Cliente();
				 cli.setDni(rs.getInt("clientes.dni_CLI"));
				 cli.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cli.setNombre(rs.getString("clientes.nombre_CLI"));
				 cli.setApellido(rs.getString("clientes.apellido_CLI"));
				 cli.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cli.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cli.setEmail(rs.getString("clientes.email_CLI"));
				 cli.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cli.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 cli.setNombreCompleto(rs.getString("clientes.nombre_CLI")+" "+rs.getString("clientes.apellido_CLI"));
				 
				 Nacionalidad nac = new Nacionalidad();
				 nac.setCodigo(rs.getInt("nacionalidades.codigo_nacionalidad_NAC"));
				 nac.setAbreviatura(rs.getString("nacionalidades.abreviatura_NAC"));
				 nac.setDescripcion(rs.getString("nacionalidades.descripcion_NAC"));								
				 
				 Provincia pro = new Provincia();
				 pro.setCodigo(rs.getInt("provincias.codigo_provincia_PRO"));
				 pro.setDescripcion(rs.getString("provincias.descripcion_PRO"));
				 
				 Localidad loc = new Localidad();
				 loc.setCodigo(rs.getInt("localidades.codigo_localidad_LOC"));
				 loc.setProvincia(pro);
				 loc.setDescripcion(rs.getString("localidades.descripcion_LOC"));
				 
				 Genero gen = new Genero();
				 gen.setCodigo(rs.getInt("generos.codigo_genero_GEN"));
				 gen.setDescripcion(rs.getString("generos.descripcion_GEN")); 
				 
				 cli.setNacionalidad(nac);
				 cli.setProvincia(pro);
				 cli.setLocalidad(loc);
				 cli.setGenero(gen);*/
				 
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

}
