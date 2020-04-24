package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoLogin;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//dao login
	private DaoLogin daologin = new DaoLogin();
       
    
    public LoginServlet() {
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request,response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			// try para validacao do login
			try {
			
			
		BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
	
		if(daologin.validarLogin(login, senha)) {//acesso ok
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
			dispatcher.forward(request, response);
		}else {//acesso negado
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
			dispatcher.forward(request, response);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}