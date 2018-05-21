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
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	UsuarioModelo um = new UsuarioModelo();
	Usuario usuario = um.selectUser(user);

	
	if (user.equals(usuario.getNombre()) && password.equals(usuario.getPassword())){
		HttpSession session = request.getSession();
		session.setAttribute("user", usuario.getNombre());
		response.sendRedirect("ListarUsuario");
	}else{
		RequestDispatcher rd = request.getRequestDispatcher("adios.html");
		rd.forward(request, response);
	}
}
}


