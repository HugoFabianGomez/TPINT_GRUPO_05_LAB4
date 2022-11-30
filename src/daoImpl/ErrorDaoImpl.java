package daoImpl;

import entidades.Error;

public class ErrorDaoImpl {

	private Conexion cn;
	public void insertar(Error error) {


		cn = new Conexion();
		cn.Open();	

		String query = "insert into Errores (fecha_creacion_CU,nombre_usuario_US,descripcion_Error) values"+
						"('"+error.getFecha() +"','"+error.getUsuario()+"','"+error.getDescripcion()+"');";
		
		System.out.println(query);
		try
		 {
			cn.execute(query);
			
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
}
