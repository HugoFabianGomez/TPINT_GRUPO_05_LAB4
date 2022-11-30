package CreandoException;


import java.sql.ResultSet;
import daoImpl.Conexion;
import javax.swing.JOptionPane;

public class ValidoDniUsuario {
	private static Conexion cn;

	public ValidoDniUsuario() {
		
	}
	
	public boolean ComprueboDni(int dni) throws DniInvalido
	{
			// TODO Auto-generated method stub
			cn = new Conexion();
			cn.Open();
			
			boolean existe = false;
			try
			 {
				 String querys = "select dni_CLI from clientes where clientes.dni_CLI = "+ dni;
				ResultSet rs = cn.query(querys);
				while(rs.next()) 
				{
					int nrodni = Integer.parseInt(rs.getString("dni_CLI"));
					if(dni == nrodni) {	
						 existe = true;
						 System.out.println("Devolvio existe= " + existe+" dni para dar alta= "+ dni +" dni que traje de la base= " + nrodni);
						 JOptionPane.showMessageDialog(null, "El Dni existe en la Base de Datos");
					}	 
			    }
			 }	catch(Exception e)
			 {
				 System.out.println("Error en Verificar existe.....");
				 e.printStackTrace();
			 }
			 finally
			 {
				 cn.close();
			 } 
			
			if(existe == true) {
				// DNI REPETIDO YA SE ENCUENTRA EN LA BASE
				DniInvalido exc1 = new DniInvalido();
				throw exc1;
			}
		
		return existe;
	}
	
	public boolean ComprueboUsuario(String usuario) throws UsuarioExistente
	{
		cn = new Conexion();
		cn.Open();
		
		boolean existe = false;
		try
		 {
			String querys = "select nombre_usuario_CLI from clientes where nombre_usuario_CLI = "+ usuario;
			ResultSet rs = cn.query(querys);
			while(rs.next()) 
			{
				String  BaseDato = rs.getString("nombre_usuario_CLI");
				if(usuario == BaseDato) {
					 existe = true;
					 System.out.println("Devolvio existe= " + existe+" usuario para dar alta= "+ usuario +" usuario que traje de la base= " + BaseDato);
					 JOptionPane.showMessageDialog(null, "El Dni existe en la Base de Datos");
				}	 
		    }
		 }	catch(Exception e)
		 {
			 System.out.println("Error en Verificar existe.....");
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 } 
		if(existe == true) {
			// DNI REPETIDO YA SE ENCUENTRA EN LA BASE
			UsuarioExistente exc1 = new UsuarioExistente();
			throw exc1;
		}
	return existe;
	}

}
