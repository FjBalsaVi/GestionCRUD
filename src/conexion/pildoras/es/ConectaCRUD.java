package conexion.pildoras.es;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ConectaCRUD
 */
@WebServlet("/ConectaCRUD")
public class ConectaCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectaCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String jdbcUrl="jdbc:mysql://localhost:3306/gestionpedidosCRUD?useSSL=false";
		
		String usuario = "root";
		
		String pass = "D1PkGP1a8F";
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out=response.getWriter();
			
			out.print("Nombre de la BBDD: " + jdbcUrl);
			
			out.append("<br>");
			Class.forName(driver);
			
			java.sql.Connection miConexion =  DriverManager.getConnection(jdbcUrl, usuario, pass);
			
			out.print("CONECTADO!!");
			
			miConexion.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
