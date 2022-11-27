package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.PrestamoDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Nacionalidad;
import entidades.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao {
	Conexion cn = new Conexion();

	@Override
	public int insertar(Prestamo prestamo) {
		int id = 0;
		try {
			String query = "insert into Prestamos (fecha_PRS,importa_pagar_PRS,importe_pedido_PRS,plazo_meses_PRS,intereses_PRS,"
					+ "importe_cuota_PRS,otorgado_PRS,motivo_rechazo_PRS,estado_PRS,dni_cliente_PRS,cuenta_cliente_PRS) VALUES (CURDATE(), "
					+ prestamo.getImportePagar() + " , " + prestamo.getImportePedido() + " , "
					+ prestamo.getPlazoMeses() + " , " + prestamo.getIntereses() + " , " + prestamo.getImporteCuota()
					+ " , 0, '', 1, " + prestamo.getCliente().getDni() + " , " + prestamo.getCuenta().getNumeroCuenta()
					+ ")";
			PreparedStatement statement = (PreparedStatement) cn.Open().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("No se pudo guardar");
			}
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
			System.out.println(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return id;
	}

	@Override
	public ArrayList<Prestamo> obtenerTodos() {
		cn = new Conexion();
		cn.Open();
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		try {
			ResultSet rs = cn
					.query("select * from prestamos\r\n" + "inner join clientes on dni_cliente_PRS = dni_CLI \r\n"
							+ "WHERE estado_PRS = 1 ORDER BY codigo_prestamo_PRS DESC");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setCodigo(rs.getInt("codigo_prestamo_PRS"));
				prestamo.setFecha(rs.getString("fecha_PRS"));
				prestamo.setImportePagar(rs.getFloat("importa_pagar_PRS"));
				prestamo.setImportePedido(rs.getFloat("importe_pedido_PRS"));
				prestamo.setPlazoMeses(rs.getInt("plazo_meses_PRS"));
				prestamo.setIntereses(rs.getFloat("intereses_PRS"));
				prestamo.setImporteCuota(rs.getFloat("importe_cuota_PRS"));
				prestamo.setMotivoRechazo(rs.getString("motivo_rechazo_PRS"));
				if (rs.getInt("otorgado_PRS") == 0) {
					prestamo.setEstado("Pendiente");
				} else if (rs.getInt("otorgado_PRS") == 1) {
					prestamo.setEstado("Autorizado");
				} else if (rs.getInt("otorgado_PRS") == 2) {
					prestamo.setEstado("Rechazado");
				}

				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(rs.getInt("cuenta_cliente_PRS"));
				prestamo.setCuenta(cuenta);

				Cliente cliente = new Cliente();
				cliente.setDni(rs.getInt("dni_cliente_PRS"));
				cliente.setNombreCompleto(
						rs.getString("clientes.nombre_CLI") + " " + rs.getString("clientes.apellido_CLI"));
				prestamo.setCliente(cliente);

				list.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return list;
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosCliente(int dni) {
		cn = new Conexion();
		cn.Open();
		ArrayList<Prestamo> list = new ArrayList<Prestamo>();
		try {
			ResultSet rs = cn
					.query("select * from prestamos\r\n" + "inner join clientes on dni_cliente_PRS = dni_CLI \r\n"
							+ "WHERE estado_PRS = 1 AND dni_CLI = " + dni + " ORDER BY codigo_prestamo_PRS DESC");
			while (rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setCodigo(rs.getInt("codigo_prestamo_PRS"));
				prestamo.setFecha(rs.getString("fecha_PRS"));
				prestamo.setImportePagar(rs.getFloat("importa_pagar_PRS"));
				prestamo.setImportePedido(rs.getFloat("importe_pedido_PRS"));
				prestamo.setPlazoMeses(rs.getInt("plazo_meses_PRS"));
				prestamo.setIntereses(rs.getFloat("intereses_PRS"));
				prestamo.setImporteCuota(rs.getFloat("importe_cuota_PRS"));
				prestamo.setMotivoRechazo(rs.getString("motivo_rechazo_PRS"));
				if (rs.getInt("otorgado_PRS") == 0) {
					prestamo.setEstado("Pendiente");
				} else if (rs.getInt("otorgado_PRS") == 1) {
					prestamo.setEstado("Autorizado");
				} else if (rs.getInt("otorgado_PRS") == 2) {
					prestamo.setEstado("Rechazado");
				}

				Cuenta cuenta = new Cuenta();
				cuenta.setNumeroCuenta(rs.getInt("cuenta_cliente_PRS"));
				prestamo.setCuenta(cuenta);

				Cliente cliente = new Cliente();
				cliente.setNombreCompleto(
						rs.getString("clientes.nombre_CLI") + " " + rs.getString("clientes.apellido_CLI"));
				cliente.setDni(rs.getInt("dni_CLI"));
				prestamo.setCliente(cliente);

				list.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return list;
	}

	@Override
	public boolean actualizar(int estadoPrestamo, int nroPrestamo) {
		boolean estado = true;

		cn = new Conexion();
		cn.Open();

		String query = "UPDATE Prestamos SET otorgado_PRS = " + estadoPrestamo + " WHERE codigo_prestamo_PRS = "
				+ nroPrestamo;
		System.out.println(query);
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}
	
	@Override
	public boolean rechazar(int estadoPrestamo, int nroPrestamo, String motivoRechazo) {
		boolean estado = true;

		cn = new Conexion();
		cn.Open();

		String query = "UPDATE Prestamos SET otorgado_PRS = " + estadoPrestamo + ", motivo_rechazo_PRS = '" + motivoRechazo + "' WHERE codigo_prestamo_PRS = "
				+ nroPrestamo;
		System.out.println(query);
		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}
}
