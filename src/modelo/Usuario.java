package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private Date fecha_nacimiento;
	private String password;
	private String rol;
	
	public static final String USUARIO = "usuario";
	public static final String ADMIN = "admin";
	
	
	
	
	public Usuario(){
		
	}
	Usuario(int id, String nombre, String apellido, int edad, String dni, Date fecha_nacimiento, String password, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.password = password;
		this.rol=rol;

}
	public Usuario esAdmin( String rol){
		rol =ADMIN;
		return this.esAdmin(rol);
		
		
	}
	public Usuario esUsuario( String rol){
		rol =USUARIO;
		return this.esUsuario(rol);
		
		
	}

	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	

}
