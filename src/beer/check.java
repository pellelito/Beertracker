package beer;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class check
 */
@WebServlet("/check")
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("uname");  
	    String p=request.getParameter("psw");  
	          
	    if(LoginDB.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");  
	        rd.forward(request,response);  
	    }  
	    else{  
	    	// out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	
	}

