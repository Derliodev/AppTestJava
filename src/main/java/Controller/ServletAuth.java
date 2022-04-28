package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DAO.LoginDAO;
import Model.UsuarioModel;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
    		UsuarioModel user = new UsuarioModel();
    		LoginDAO log = new LoginDAO();
    		int rspta = 0;
    		String rut = "";
    		if(request.getParameter("btn-login") != null) {
    			String usuario = request.getParameter("txtusuario");
    			String contraseña = request.getParameter("txtclave");
    			try {
    				rut = log.validar(usuario, contraseña);
    			} catch (Exception ex) {
    				System.out.println(ex);
    				//Logger.getLogger(ServletAuth.class.getName()).log(Level.SEVERE, null, ex);
    			}
    			if(rut == ""  || rut == null) {
    				response.sendRedirect("/Login/index.jsp?rspta=" + rspta);
    			}else{
    				user = log.Read(rut);
    				
    				request.setAttribute("nombre", user.getNombre());
    				request.setAttribute("apellido", user.getApellido());
    				request.setAttribute("rut", user.getRut());
    				request.getRequestDispatcher("main.jsp").forward(request, response);
    				//response.sendRedirect("/Login/main.jsp?rspta=" + rspta);
    			}
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


