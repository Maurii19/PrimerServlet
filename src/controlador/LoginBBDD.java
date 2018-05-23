package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.UsuarioModelo;

public class LoginBBDD extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nombre = request.getParameter("user");
		String password = request.getParameter("password");

		UsuarioModelo um = new UsuarioModelo();
		Usuario usuario;
		
		if(um.selectUser(nombre) != null ){
			usuario = um.selectUser(nombre);
		}else{
			usuario = new Usuario();
		}
	
	if (nombre.equals(usuario.getNombre()) && password.equals(usuario.getPassword())) {

		HttpSession session = request.getSession();

		session.setAttribute("user", usuario);

		RequestDispatcher rd = request.getRequestDispatcher("ListarUsuario");
		rd.forward(request, response);
	} else {
		RequestDispatcher rd = request.getRequestDispatcher("adios.html");
		rd.forward(request, response);
}
	}
}


