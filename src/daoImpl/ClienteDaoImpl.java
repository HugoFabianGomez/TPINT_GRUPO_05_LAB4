package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CreandoException.ValidoDniUsuario;
import dao.ClienteDao;
import daoImpl.Conexion;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Usuario;
import entidades.TipoUsuario;


public class ClienteDaoImpl implements ClienteDao {
	private Conexion cn;

	@Override
	public ArrayList<Cliente> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cliente> list = new ArrayList<Cliente>();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes\r\n" + 
			 		"inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n" + 
			 		"inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n" +
			 		"inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n" +  
			 		"inner join generos on codigo_genero_CLI = codigo_genero_GEN where estado_CLI = 1 GROUP BY dni_CLI;");
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
		boolean estado=false;
		boolean existedni = true;
		boolean existeUsuario = true;
		cn = new Conexion();
		cn.Open();	
		
		ValidoDniUsuario dni = new ValidoDniUsuario();

		existedni = dni.ComprueboDni(cliente.getDni());
		existeUsuario = dni.ComprueboUsuario(cliente.getUsuario().getNombreUsuario());
		
		if(existedni == false && existeUsuario == false) {

		
		String query = ("insert into clientes (dni_CLI, cuil_CLI, nombre_CLI, apellido_CLI, fecha_nacimiento_CLI, domicilio_CLI, email_CLI, telefono_CLI, estado_CLI, codigo_nacionalidad_CLI, codigo_localidad_CLI, codigo_provincia_CLI, codigo_genero_CLI, nombre_usuario_CLI)"
		               +" values("+cliente.getDni()+","+cliente.getCuil()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+ cliente.getFechaNacimiento()+"','"+cliente.getDomicilio()+"','"+cliente.getEmail()+"','"+cliente.getTelefono()+"',1,          "+cliente.getNacionalidad().getCodigo()+","+cliente.getLocalidad().getCodigo()+","+cliente.getProvincia().getCodigo()+","+ cliente.getGenero().getCodigo()+",'"+cliente.getUsuario().getNombreUsuario()+"');");
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
				"codigo_nacionalidad_CLI ="+cliente.getNacionalidad().getCodigo()+", \r\n" + 
				"codigo_provincia_CLI ="+cliente.getProvincia().getCodigo()+", \r\n" + 
				"codigo_localidad_CLI ="+cliente.getLocalidad().getCodigo()+", \r\n" + 
				"codigo_genero_CLI ="+cliente.getGenero().getCodigo()+" \r\n" + 
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

	@Override
	public ArrayList<Cliente> obtenerTodos(int dni) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		 ArrayList<Cliente> list = new ArrayList<Cliente>();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes\r\n" + 
			 		"inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n" + 
			 		"inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n" +
			 		"inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n" +  
			 		"inner join generos on codigo_genero_CLI = codigo_genero_GEN where clientes.dni_CLI ="+dni +" GROUP BY dni_CLI;");
			 System.out.println("Llegue al ClienteDaoImpl 174");
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
	public Cliente obtenerUno(int dni) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();

		Cliente cli = new Cliente();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes\r\n" + 
			 		"inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n" + 
			 		"inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n" +
			 		"inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n" +  
			 		"inner join generos on codigo_genero_CLI = codigo_genero_GEN where clientes.dni_CLI ="+dni);
			 if(rs.next())
			 {
				 System.out.println(rs);
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
				 cli.setGenero(gen);
				 
				 //list.add(cli);
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
		
		return cli;
	}

	public Cliente obtenerxusuario(String userid) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		System.out.println("Saco DNI" + userid);
		Cliente cli = new Cliente();
		 try
		 {
			 ResultSet rs= cn.query("select * from clientes\r\n" + 
			 		"inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n" + 
			 		"inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n" +
			 		"inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n" +  
			 		"inner join generos on codigo_genero_CLI = codigo_genero_GEN where clientes.nombre_usuario_CLI ='"+userid +"' GROUP BY clientes.dni_CLI ;");
			 if(rs.next())
			 {
				 System.out.println("Entre en obtenerUno");
				 cli.setDni(rs.getInt("clientes.dni_CLI"));
				 System.out.println("Saco DNI" + cli.getDni());
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
				 cli.setGenero(gen);				 //list.add(cli);
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
		return cli;
	}

	@Override
	public Cliente obtenerUno(String usuario) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		//ArrayList<Cliente> list = new ArrayList<Cliente>();
		Cliente cli = new Cliente();
		 try
		 {
			 String querys = "select * from clientes inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n"
				 		+ "inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n"
				 		+ "inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n"
				 		+ "inner join generos on codigo_genero_CLI = codigo_genero_GEN \r\n"
				 		+ "inner join usuarios on nombre_usuario_CLI = nombre_usuario_US\r\n"
				 		+ "where nombre_usuario_CLI = '"+ usuario +"' GROUP BY dni_CLI;";
			 System.out.println("Querys: "+querys);
			 ResultSet rs= cn.query("select * from clientes inner join nacionalidades on codigo_nacionalidad_CLI = codigo_nacionalidad_NAC\r\n"
			 		+ "inner join provincias on codigo_provincia_CLI = codigo_provincia_PRO\r\n"
			 		+ "inner join localidades on codigo_provincia_PRO = codigo_provincia_LOC\r\n"
			 		+ "inner join generos on codigo_genero_CLI = codigo_genero_GEN \r\n"
			 		+ "inner join usuarios on nombre_usuario_CLI = nombre_usuario_US\r\n"
			 		+ "where nombre_usuario_CLI = '"+ usuario +"' GROUP BY dni_CLI;");
			 
			 
			 if(rs.next())
			 {
				 System.out.println("Entre en obtenerUno usuario");
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

				 Usuario usu = new Usuario();
				 usu.setNombreUsuario(rs.getString("usuarios.nombre_usuario_US"));
				 usu.setContrasenia(rs.getString("usuarios.contrasena_US"));
				 usu.setEstado(rs.getBoolean("usuarios.estado_US"));
				 //usu.setTipoUsuario(rs.getInt("tiposusuario.codigo_tipo_usuario_TUS"));
				 
				 /*TipoUsuario tipousu = new TipoUsuario();
				 tipousu.setCodTipoUsuario(rs.getInt("tiposusuario.codigo_tipo_usuario_TUS"));
				 tipousu.setTipoUsuario(rs.getString("tiposusuario.descripcion_TUS"));
				 usu.getTipoUsuario(tipousu);				 */
				 
				 cli.setNacionalidad(nac);
				 cli.setProvincia(pro);
				 cli.setLocalidad(loc);
				 cli.setGenero(gen);
				 cli.setUsuario(usu);				 //list.add(cli);
			}
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error en Obtener uno usuario.....");
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return cli;
	}

	@Override
	public boolean existe(int dni) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();
		
		boolean existe = false;
		int registros = 0; 
		try
		 {
			 PreparedStatement ps = null;
			 String querys = "select clientes.dni_CLI from clientes where clientes.dni_CLI = "+ dni;
			 
			 ResultSet rs = cn.query(querys);
			 while(rs.next()) {
				 registros ++;
			 }
			 if(registros > 0) {
				 existe = true;
				 System.out.println("Devolvio existe= "+existe);
				 JOptionPane.showMessageDialog(null, "El Dni existe en la Base de Datos");
			 }	 
		 } catch(Exception e)
		 {
			 System.out.println("Error en Verificar existe.....");
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 } 
		return existe;
	}
}
