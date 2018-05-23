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
		
		Usuario usuario = (Usuario) session.getAttribute("user");
		
		if(usuario != null){
			//recibir datos
			String nombreUsuario = request.getParameter("nombre");
			
			UsuarioModelo um = new UsuarioModelo();
			ArrayList<Usuario> usuarios = um.selectAll();
			Usuario user = new Usuario();
			user.setNombre(nombreUsuario);
			usuarios.add(user);
			
			request.setAttribute("usuarios", usuarios);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
			rd.forward(request, response);
		
		}else{
			response.sendRedirect("adios.html");
		}
		
		
	}
	}

