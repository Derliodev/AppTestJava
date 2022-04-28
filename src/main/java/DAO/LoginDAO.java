package DAO;


//import java.sql.PreparedStatement;
import java.sql.ResultSet;


import DB.conexion;
import Model.UsuarioModel;


public class LoginDAO {
	
	String sql = "";
	String rut = "";
	ResultSet rs = null;
	
	public String validar(String usr, String pass) throws Exception {
		conexion cn = new conexion();
		sql = "SELECT Rut FROM usuario WHERE username='"+usr+"' AND password='"+pass+"'";
		rs = cn.ejecutarConsulta(sql);
		while(rs.next()) {
			rut=rs.getString("Rut");
		}
		cn.desconectar();
		return rut;
	}
	
	public UsuarioModel Read(String rut) throws Exception {
		conexion cn = new conexion();
		UsuarioModel user = new UsuarioModel();
		sql = "SELECT * FROM personas WHERE Rut='"+rut+"'";
		rs = cn.ejecutarConsulta(sql);
		while(rs.next()) {
			user.setNombre(rs.getString("Nombre"));
			user.setApellido(rs.getString("Apellido"));
			user.setRut(rs.getString("Rut"));
			user.setTelefono(rs.getInt("Telefono"));
			user.setFechaIn(rs.getString("FechaIngreso"));
			}
		cn.desconectar();
		return user;
	}

}
