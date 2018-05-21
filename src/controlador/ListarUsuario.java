package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import modelo.UsuarioModelo;


public class ListarUsuario extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();

		Object objeto = session.getAttribute("user");
		if (objeto == null) {
			response.sendRedirect("login.html");
		}else{
		
		//recibir datos
		String nombreUsuario = request.getParameter("nombre");
		String contrasenaUsuario = request.getParameter("password");
		UsuarioModelo um = new UsuarioModelo();
		ArrayList<Usuario> usuarioss = um.selectAll();
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreUsuario);
		usuarioss.add(usuario);
		
		request.setAttribute("usuariosB", usuarioss);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
		rd.forward(request, response);
	}
	}
}
