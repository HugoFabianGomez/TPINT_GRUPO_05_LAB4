package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import daoImpl.Conexion;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;


public class ClienteDaoImpl implements ClienteDao {
	private Conexion cn;

	@Override
	public List<Cliente> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Cliente> list = new ArrayList<Cliente>();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes\r\n" + 
			 		"inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n" + 
			 		"inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n" +
			 		"inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n" +  
			 		"inner join generos on codigo_genero_CLI = codigo_genero_GEN;");
			 while(rs.next())
			 {
				 Cliente cli = new Cliente();
				 cli.setDni(rs.getInt("clientes.dni_CLI"));
				 cli.setCuil(rs.getInt("clientes.cuil_CLI"));
				 cli.setNombre(rs.getString("clientes.nombre_CLI"));
				 cli.setApellido(rs.getString("clientes.apellido_CLI"));
				 cli.setFechaNacimiento(rs.getString("clientes.fecha_nacimiento_CLI"));
				 cli.setDomicilio(rs.getString("clientes.domicilio_CLI"));
				 cli.setEmail(rs.getString("clientes.email_CLI"));
				 cli.setTelefono(rs.getString("clientes.telefono_CLI"));
				 cli.setNombreUsuario(rs.getString("clientes.nombre_usuario_CLI"));
				 cli.setContrasena(rs.getString("clientes.contrasena_CLI"));
				 cli.setTipoUsuario(rs.getBoolean("clientes.tipo_usuario_CLI"));
				 cli.setEstado(rs.getBoolean("clientes.estado_CLI"));
				 
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
				 cli.setGenero(gen);
				 
				 list.add(cli);
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
	public boolean insertar(Cliente cliente) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "insert into clientes (dni_CLI, cuil_CLI, nombre_CLI, apellido_CLI, fecha_nacimiento_CLI, domicilio_CLI, email_CLI, telefono_CLI, nombre_usuario_CLI, contrasena_CLI, tipo_usuario_CLI, estado_CLI, codigo_nacionalidad_CLI, codigo_localidad_CLI, codigo_provincia_CLI, codigo_genero_CLI) values"
		+ "("+cliente.getDni()+","+cliente.getCuil()+",'"+cliente.getNombre()+"', '"+cliente.getApellido()+"', '"+cliente.getFechaNacimiento()+"', '"+cliente.getDomicilio()+"', '"+cliente.getEmail()+"', '"+cliente.getTelefono()+"', '"+cliente.getNombreUsuario()+"', '"+cliente.getContrasena()+"', "+cliente.getTipoUsuario()+", "+cliente.getEstado()+", "+cliente.getNacionalidad().getCodigo()+", "+cliente.getLocalidad().getCodigo()+", "+cliente.getProvincia().getCodigo()+", "+cliente.getGenero().getCodigo()+")";
		
		System.out.println(query);
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
	public boolean editar(Cliente cliente) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "update clientes set\r\n" +  
				"cuil_CLI ="+cliente.getCuil()+",\r\n" + 
				"nombre_CLI ='"+cliente.getNombre()+"', \r\n" + 
				"apellido_CLI ='"+cliente.getApellido()+"',\r\n" + 
				"fecha_nacimiento_CLI ='"+cliente.getFechaNacimiento()+"', \r\n" + 
				"domicilio_CLI ='"+cliente.getDomicilio()+"',\r\n" + 
				"email_CLI ='"+cliente.getEmail()+"', \r\n" + 
				"telefono_CLI ='"+cliente.getTelefono()+"', \r\n" + 
				"nombre_usuario_CLI ='"+cliente.getNombreUsuario()+"', \r\n"+
				"contrasena_CLI ='"+cliente.getContrasena()+"', \r\n"+
				"tipo_usuario_CLI ="+cliente.getTipoUsuario()+", \r\n"+
				"estado_CLI ="+cliente.getEstado()+", \r\n"+
				"codigo_nacionalidad_CLI ='"+cliente.getNacionalidad().getCodigo()+"', \r\n" + 
				"codigo_provincia_CLI ='"+cliente.getProvincia().getCodigo()+"', \r\n" + 
				"codigo_localidad_CLI ='"+cliente.getLocalidad().getCodigo()+"', \r\n" + 
				"codigo_genero_CLI ='"+cliente.getGenero().getCodigo()+"', \r\n" + 
				"where dni_CLI ="+cliente.getDni()+"";
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
	public boolean borrar(int dni) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "update clientes set estado_CLI=0 where dni_CLI="+dni;
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
}
