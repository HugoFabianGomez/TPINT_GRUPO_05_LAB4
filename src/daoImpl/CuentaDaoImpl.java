package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.lang.Exception;
import dao.CuentaDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.TipoCuenta;
import entidades.TipoUsuario;

public class CuentaDaoImpl implements CuentaDao {
	private Conexion cn;

	@Override
	public boolean insertar(Cuenta cuenta) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "insert into Cuentas (numero_cuenta_CU, cbu_CU, fecha_creacion_CU, saldo_CU, estado_CU, codigo_tipo_cuenta_CU, dni_cliente_CU) values"+
						"("+cuenta.getNumeroCuenta()+","+cuenta.getCbu()+",'"+cuenta.getFechaCreacion()+"',"+cuenta.getSaldo()+","+cuenta.getEstado()+","+cuenta.getTipoCuenta().getCodigo()+","+cuenta.getCliente().getDni()+");";
		
		System.out.println(query);
		try
		 {
			estado=cn.execute(query);
			System.out.println("llego al try catch");
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
	public ArrayList<Cuenta> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 ResultSet rs= cn.query("select * from cuentas\r\n" + 
			 		"inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n" + 
			 		"inner join clientes on dni_cliente_CU = dni_CLI group by numero_cuenta_CU;");
			 while(rs.next())
			 {
				 Cuenta cuenta = new Cuenta();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(rs.getInt("cuentas.cbu_CU"));
				 cuenta.setFechaCreacion(rs.getString("cuentas.fecha_creacion_CU"));
				 cuenta.setSaldo(rs.getFloat("cuentas.saldo_CU"));
				 cuenta.setEstado(rs.getBoolean("cuentas.estado_CU"));				 				 
				 
				 TipoCuenta tipoCuenta = new TipoCuenta();
				 tipoCuenta.setCodigo(rs.getInt("cuentas.codigo_tipo_cuenta_CU"));
				 tipoCuenta.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 Cliente cliente = new Cliente();
				 cliente.setDni(rs.getInt("cuentas.dni_cliente_CU"));
				 cliente.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cliente.setNombre(rs.getString("clientes.nombre_CLI"));
				 cliente.setApellido(rs.getString("clientes.apellido_CLI"));
				 cliente.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cliente.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cliente.setEmail(rs.getString("clientes.email_CLI"));
				 cliente.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cliente.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 cliente.setNombreCompleto(rs.getString("clientes.nombre_CLI")+" "+rs.getString("clientes.apellido_CLI"));
				 
				 cuenta.setTipoCuenta(tipoCuenta);
				 cuenta.setCliente(cliente);
				 
				 list.add(cuenta);
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
	public boolean modificar(Cuenta cuenta) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "update cuentas set\r\n" +  
				"cbu_CU ="+cuenta.getCbu()+",\r\n" +
				"fecha_creacion_CU ='"+cuenta.getFechaCreacion()+"',\r\n" +
				"saldo_CU ="+cuenta.getSaldo()+",\r\n" +
				"estado_CU ="+cuenta.getEstado()+",\r\n" +
				"codigo_tipo_cuenta_CU ="+cuenta.getTipoCuenta().getCodigo()+",\r\n" +
				"dni_cliente_CU ="+cuenta.getCliente().getDni()+"\r\n"+
				"where numero_cuenta_CU="+cuenta.getNumeroCuenta();
				
		try
		 {
			estado=cn.execute(query);
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
	public Cuenta obtenerUno(int numeroCuenta) {
		cn = new Conexion();
		cn.Open();
		Cuenta cuenta = new Cuenta();
		 try
		 {
			 ResultSet rs= cn.query("select * from cuentas\r\n" + 
			 		"inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n" + 
			 		"inner join clientes on dni_cliente_CU = dni_CLI\r\n" +
			 		"where numero_cuenta_CU = "+numeroCuenta);

			 	 rs.next();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(rs.getInt("cuentas.cbu_CU"));
				 cuenta.setFechaCreacion(rs.getString("cuentas.fecha_creacion_CU"));
				 cuenta.setSaldo(rs.getFloat("cuentas.saldo_CU"));
				 cuenta.setEstado(rs.getBoolean("cuentas.estado_CU"));				 				 
				 
				 TipoCuenta tipoCuenta = new TipoCuenta();
				 tipoCuenta.setCodigo(rs.getInt("cuentas.codigo_tipo_cuenta_CU"));
				 tipoCuenta.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 Cliente cliente = new Cliente();
				 cliente.setDni(rs.getInt("cuentas.dni_cliente_CU"));
				 cliente.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cliente.setNombre(rs.getString("clientes.nombre_CLI"));
				 cliente.setApellido(rs.getString("clientes.apellido_CLI"));
				 cliente.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cliente.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cliente.setEmail(rs.getString("clientes.email_CLI"));
				 cliente.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cliente.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 cliente.setNombreCompleto(rs.getString("clientes.nombre_CLI")+" "+rs.getString("clientes.apellido_CLI"));
				 
				 cuenta.setTipoCuenta(tipoCuenta);
				 cuenta.setCliente(cliente);
	
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return cuenta;
	}

	@Override
	public boolean eliminar(int numeroCuenta) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "update cuentas set\r\n" +  				
				"estado_CU = 0 \r\n" +
				"where numero_cuenta_CU="+numeroCuenta;
				
		try
		 {
			estado=cn.execute(query);
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
	public ArrayList<Cuenta> busquedaxNumero(int numeroCuenta) {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 ResultSet rs= cn.query("select * from cuentas\r\n" + 
			 		"inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n" + 
			 		"inner join clientes on dni_cliente_CU = dni_CLI where numero_cuenta_CU like'%"+numeroCuenta+"%' group by numero_cuenta_CU;");
			 while(rs.next())
			 {
				 Cuenta cuenta = new Cuenta();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(Integer.parseInt(rs.getString("cuentas.cbu_CU")));
				 cuenta.setFechaCreacion(rs.getString("cuentas.fecha_creacion_CU"));
				 cuenta.setSaldo(rs.getFloat("cuentas.saldo_CU"));
				 cuenta.setEstado(rs.getBoolean("cuentas.estado_CU"));				 				 
				 
				 TipoCuenta tipoCuenta = new TipoCuenta();
				 tipoCuenta.setCodigo(rs.getInt("cuentas.codigo_tipo_cuenta_CU"));
				 tipoCuenta.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 Cliente cliente = new Cliente();
				 cliente.setDni(rs.getInt("cuentas.dni_cliente_CU"));
				 cliente.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cliente.setNombre(rs.getString("clientes.nombre_CLI"));
				 cliente.setApellido(rs.getString("clientes.apellido_CLI"));
				 cliente.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cliente.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cliente.setEmail(rs.getString("clientes.email_CLI"));
				 cliente.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cliente.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 cliente.setNombreCompleto(rs.getString("clientes.nombre_CLI")+" "+rs.getString("clientes.apellido_CLI"));
				 
				 cuenta.setTipoCuenta(tipoCuenta);
				 cuenta.setCliente(cliente);
				 
				 list.add(cuenta);
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
	public ArrayList<Cuenta> busquedaxDni(int dni) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 String query = ("select * from cuentas inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n"
				 		+ "where dni_cliente_CU = "+ dni +" and estado_CU = 1;");
			 ResultSet rs= cn.query("select * from cuentas inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n"
			 		+ "where dni_cliente_CU = "+ dni +" and estado_CU = 1;");
			 
			 System.out.println(query);
			 
			 while(rs.next())
			 {
				 Cuenta cuenta = new Cuenta();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(rs.getInt("cuentas.cbu_CU"));
				 cuenta.setFechaCreacion(rs.getString("cuentas.fecha_creacion_CU"));
				 cuenta.setSaldo(rs.getFloat("cuentas.saldo_CU"));
				 cuenta.setEstado(rs.getBoolean("cuentas.estado_CU"));				 				 
				 
				 TipoCuenta tipoCuenta = new TipoCuenta();
				 tipoCuenta.setCodigo(rs.getInt("tiposcuenta.codigo_tipo_cuenta_TCU"));
				 tipoCuenta.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 Cliente cliente = new Cliente();
				 cliente.setDni(rs.getInt("cuentas.dni_cliente_CU"));
				 cuenta.setTipoCuenta(tipoCuenta);
				 cuenta.setCliente(cliente);
				 
				 list.add(cuenta);
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
	public Cuenta obtenerUnoxCbu(int cbu) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		Cuenta cuenta = new Cuenta();
		 try
		 {
			 ResultSet rs= cn.query("select * from cuentas where cbu_CU = "+ cbu +";");

			 	 rs.next();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(rs.getInt("cuentas.cbu_CU"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return cuenta;
	}
	
	@Override
	public ArrayList<Cuenta> obtenerCuentasCliente(int dni) {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cuenta> list = new ArrayList<Cuenta>();
		 try
		 {
			 ResultSet rs= cn.query("select * from cuentas\r\n" + 
			 		"inner join tiposcuenta on codigo_tipo_cuenta_CU = codigo_tipo_cuenta_TCU\r\n" + 
			 		"inner join clientes on dni_cliente_CU = dni_CLI\r\n" +
		            "WHERE dni_CLI = " + dni);
			 while(rs.next())
			 {
				 Cuenta cuenta = new Cuenta();
				 cuenta.setNumeroCuenta(rs.getInt("cuentas.numero_cuenta_CU"));
				 cuenta.setCbu(Integer.parseInt(rs.getString("cuentas.cbu_CU")));
				 cuenta.setFechaCreacion(rs.getString("cuentas.fecha_creacion_CU"));
				 cuenta.setSaldo(rs.getFloat("cuentas.saldo_CU"));
				 cuenta.setEstado(rs.getBoolean("cuentas.estado_CU"));				 				 
				 
				 TipoCuenta tipoCuenta = new TipoCuenta();
				 tipoCuenta.setCodigo(rs.getInt("cuentas.codigo_tipo_cuenta_CU"));
				 tipoCuenta.setDescripcion(rs.getString("tiposcuenta.descripcion_TCU"));
				 
				 Cliente cliente = new Cliente();
				 cliente.setDni(rs.getInt("cuentas.dni_cliente_CU"));
				 cliente.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cliente.setNombre(rs.getString("clientes.nombre_CLI"));
				 cliente.setApellido(rs.getString("clientes.apellido_CLI"));
				 cliente.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cliente.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cliente.setEmail(rs.getString("clientes.email_CLI"));
				 cliente.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cliente.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 cliente.setNombreCompleto(rs.getString("clientes.nombre_CLI")+" "+rs.getString("clientes.apellido_CLI"));
				 
				 cuenta.setTipoCuenta(tipoCuenta);
				 cuenta.setCliente(cliente);
				 
				 list.add(cuenta);
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
