package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import connection.SingleConnection;

@WebFilter(urlPatterns = { "/*"})
public class Filter implements javax.servlet.Filter {

	private static Connection connection; // Para o filtro receber a conex�o que foi iniciada

	 @Override
	 public void destroy() {

	 }

	 @Override
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	   throws IOException, ServletException {

	  try {

	   chain.doFilter(request, response);
	   connection.commit(); // Se ocorreu tudo bem o commit ser� realizado

	  } catch (Exception e) {

	   try {
		e.printStackTrace();   
	    connection.rollback(); // Sen�o as altera��es ser�o descartadas

	   } catch (SQLException e1) {
	    e1.printStackTrace();

	   }

	  }

	 }

	 @Override
	 public void init(FilterConfig filterConfig) throws ServletException { // Este m�todo init � sempre invocado
	  connection = SingleConnection.getConnection(); // getConnection levanta a conex�o
	 }
}
