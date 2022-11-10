package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			 		"inner join TipoUsuarios TU on TU.CodTipoUsuario = U.CodTipoUsuario");
			 while(rs.next())
			 {
				 Usuario u = new Usuario();
				 u.setNombreUsuario(rs.getString("U.NombreUsuario"));
				 u.setContrasenia(rs.getString("U.Contrasenia"));
				 
				 TipoUsuario tu = new TipoUsuario();
				 tu.setTipoUsuario(rs.getString("TU.TipoUsuario"));	 
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

		String query = "insert into Usuarios (NombreUsuario, Contrasenia, CodTipoUsuario, Estado) values"
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
				"NombreUsuario ="+usuario.getNombreUsuario()+",\r\n" + 
				"Contrasenia ='"+usuario.getContrasenia()+"', \r\n" + 
				"CodTipoUsuario ='"+usuario.getTipoUsuario().getCodTipoUsuario()+"',\r\n" + 
				"where NombreUsuario =" + usuario.getNombreUsuario()+"";
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
		String query = "update usuarios set estado=0 where NombreUsuario = '" + nombreUsuario + "'";
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
