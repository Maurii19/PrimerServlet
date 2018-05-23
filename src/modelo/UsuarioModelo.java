package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.sql.Date;

public class UsuarioModelo extends Conector {

	public ArrayList<Usuario> selectAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);

			while (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setDni(rst.getString("dni"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario select(int id) {

		try {

			PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setDni(rst.getString("dni"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));

				return usuario;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public void delete(int id) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("delete from usuarios where id =?");
			pst.setInt(1, id);

			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Usuario usuario) {
		PreparedStatement pst;

		try {
			pst = super.conexion.prepareStatement(
					"update usuarios set nombre=?, apellido=?, edad=?,  dni=?, fecha_nacimiento=?, where id=?");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.setString(4, usuario.getDni());
			java.sql.Date sqlData = new java.sql.Date(usuario.getFecha_nacimiento().getTime());
			pst.setDate(5, sqlData);
			pst.setString(6, usuario.getPassword());
			pst.setString(7, usuario.getRol());
			pst.setInt(8, usuario.getId());

			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void insert(Usuario usuario) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String fechaformateada = formato.format(usuario.getFecha_nacimiento());
		try {
			PreparedStatement pst = super.conexion.prepareStatement(
					"INSERT INTO usuarios (nombre, apellido, edad, dni, fecha_nacimiento) values(?,?,?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setInt(3, usuario.getEdad());
			pst.setString(4, usuario.getDni());
			java.sql.Date sqlData = new java.sql.Date(usuario.getFecha_nacimiento().getTime());
			pst.setDate(5, sqlData);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> selectMenorDeEdad() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios where edad < 18";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);

			while (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setDni(rst.getString("dni"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));

				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public ArrayList<Usuario> selectContieneEnApellido(String cadena) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios where apellido like '%' + cadena + '%'";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);

			while (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public ArrayList<Usuario> selectPorNombre(String nombre) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios where nombre = '" + nombre + "'";
		try {
			Statement stt = super.conexion.createStatement();
			ResultSet rst = stt.executeQuery(sql);

			while (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));
				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario selectPorDni(String dni) {
		// Crear lista de usuarios
		Usuario usuario = null;
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE dni =('" + dni + "')");
			rs.next();
			usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"),
					rs.getString("dni"), rs.getDate("fecha_nacimiento"), rs.getString("password"), rs.getString("rol"));
		} catch (SQLException e) {
			System.out.println("Error, prueba otra vez");
		}
		return usuario;
}
	// devuelve un usuario que tenga ese dni y contrase�a
	// sino devuelve null
	public Usuario get(String dni, String password) {

		try {

			PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where dni = ? and  password = ?");
			pst.setString(1, dni);
			pst.setString(2, password);
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rst.getInt("id"));
				usuario.setNombre(rst.getString("nombre"));
				usuario.setApellido(rst.getString("apellido"));
				usuario.setEdad(rst.getInt("edad"));
				usuario.setDni(rst.getString("dni"));
				usuario.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
				usuario.setPassword(rst.getString("password"));
				usuario.setRol(rst.getString("rol"));

				return usuario;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	
	
	public Usuario selectUser(String nombre) {
		// Crear lista de usuarios
		Usuario usuario = null;
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE nombre =('" + nombre + "')");
			rs.next();
			usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"),
					rs.getString("dni"), rs.getDate("fecha_nacimiento"), rs.getString("password"), rs.getString("rol"));
		} catch (SQLException e) {
		
		}
		return usuario;
}	

}

// Statement st = super.conexion.createStatement();

// ResultSet rs = st.executeQuery("select * from usuarios where dni =
// ('"+dni+"')");
// rs.next();
// usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"),
// rs.getString("apellido"), rs.getInt("edad"), rs.getString("dni"),
// rs.getDate("fecha_nacimiento"));
