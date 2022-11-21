package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import daoImpl.Conexion;
import entidades.Nacionalidad;
import entidades.TipoUsuario;
import entidades.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	private Conexion cn;

	public List<Usuario> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		 List<Usuario> list = new ArrayList<Usuario>();
		 try
		 {
			 ResultSet rs= cn.query("select * from Usuarios U\r\n" + 
			 		"inner join TipoUsuarios TUS on TUS.codigo_tipo_usuario_TUS = U.codigo_tipo_usuario_US");
			 while(rs.next())
			 {
				 Usuario u = new Usuario();
				 u.setNombreUsuario(rs.getString("U.nombre_usuario_US"));
				 u.setContrasenia(rs.getString("U.contrasena_US"));
				 
				 TipoUsuario tu = new TipoUsuario();
				 tu.setTipoUsuario(rs.getString("TU.descripcion_TUS"));	 
				 u.setTipoUsuario(tu);
				 
				 list.add(u);
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

	public boolean insertar(Usuario u) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "insert into Usuarios (nombre_usuario_US, contrasena_US, codigo_tipo_usuario_US) " 
		+ "values('"+u.getNombreUsuario()+"','"+u.getContrasenia()+"',2)";
		
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
	public String Login(String Usuario, String clave) {
		cn = new Conexion();
		cn.Open();	
		String Resultado = "Fallo";
		try {
						
			ResultSet rs= cn.query("select * from bdbanco.usuarios U inner join bdbanco.tiposusuario TUS on TUS.codigo_tipo_usuario_TUS = U.codigo_tipo_usuario_US where nombre_usuario_US = '" + Usuario + "' and contrasena_US = '" + clave + "'");
			 // System.out.println("VERIFICAMOS USUARIO1" + rs);
			
				 if(rs.next())
				 {					
					 return rs.getString("descripcion_TUS");				
				 }
				 else
				 {
					 return Resultado;
				 }
				 
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		
		 
		return null; 
		 
		
	}

	@Override
	public boolean editar(Usuario usuario) {
		boolean estado=true;

		cn = new Conexion();
		cn.Open();	

		String query = "update Usuarios set\r\n" +  
				"nombre_usuario_US ="+usuario.getNombreUsuario()+",\r\n" + 
				"contrasena_US ='"+usuario.getContrasenia()+"', \r\n" + 
				"cod_tipo_usuario_US ='"+usuario.getTipoUsuario().getCodTipoUsuario()+"',\r\n" + 
				"where nombre_usuario_US =" + usuario.getNombreUsuario()+"";
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
	public boolean borrar(String nombreUsuario) {
		boolean estado=true;
		cn = new Conexion();
		cn.Open();		 
		String query = "update usuarios set estado_US = 0 where nombre_usuario_US = '" + nombreUsuario + "'";
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

	public String Login2(String Usuario, String clave) {
		cn = new Conexion();
		cn.Open();	
		String Resultado = "Fallo";
		try {
			
			ResultSet rs= cn.query("select * from usuarios U inner join tiposusuario TUS on TUS.codigo_tipo_usuario_TUS = U.codigo_tipo_usuario_US where nombre_usuario_US = '" + Usuario + "' and contrasena_US = '" + clave + "'");
			// System.out.println("VERIFICAMOS USUARIO1" + rs);
			
				 if(rs.next())
				 {
					
				 return rs.getString("descripcion_TUS");
				
				 }
				 else
				 {
					 return Resultado;
				 }
				 
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		
		 
		return null; 
		 
		
	}
	@Override
	public Usuario login(String usuario, String pass) {
		// TODO Auto-generated method stub
		cn = new Conexion();
		cn.Open();		 
		Usuario user = new Usuario();
		try
		 {
			 ResultSet rs= cn.query("select * from bdbanco.usuarios U inner join bdbanco.tiposusuario TUS on TUS.codigo_tipo_usuario_TUS = U.codigo_tipo_usuario_US where nombre_usuario_US = '" + usuario + "' and contrasena_US = '" + pass + "'");

			 if(rs.next()) {
				 user.setNombreUsuario(rs.getString("nombre_usuario_US"));
				 user.setContrasenia(rs.getString("contrasena_US"));
				 user.setEstado(rs.getBoolean("estado_US"));
				 
				 TipoUsuario tup = new TipoUsuario();
				 tup.setCodTipoUsuario(rs.getInt("TUS.codigo_tipo_usuario_TUS"));
				 tup.setTipoUsuario(rs.getString("TUS.descripcion_TUS"));
				 
				 user.setTipoUsuario(tup);
				 //System.out.println("Entre en login: "+tup.toString());
				 
			 } else {
				 user = null;
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error en login");
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return user;
		
	}
	
	public int obtenerDniUser(String user) {
		int dni = 0;
		cn = new Conexion();
		cn.Open();
		try {
			ResultSet rs = cn.query("select * from Usuarios U\r\n"
					+ "inner join TipoUsuarios TUS on TUS.codigo_tipo_usuario_TUS = U.codigo_tipo_usuario_US\r\n"
					+ "inner join Clientes C on C.nombre_usuario_CLI = U.nombre_usuario_US\r\n"
					+ "WHERE U.nombre_usuario_US = " + user);
			while (rs.next()) {
				dni = (rs.getInt("C.dni_CLI"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return dni;
	}
}
