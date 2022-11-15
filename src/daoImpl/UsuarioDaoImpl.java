package daoImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.UsuarioDao;
import daoImpl.Conexion;
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

		String query = "insert into Usuarios (nombre_usuario_US, contrasena_US, codigo_tipo_usuario_US, 1) values"
		+ "("+u.getNombreUsuario()+","+u.getContrasenia()+",'"+u.getTipoUsuario().getCodTipoUsuario()+",1)";
		
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

	public String Login(String Usuario, String clave) {
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
	
}
