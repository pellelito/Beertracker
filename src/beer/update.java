package beer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		String n=request.getParameter("uname");  
	    String p=request.getParameter("psw"); 
	    String t=request.getParameter("table");
	    
	    String c=request.getParameter("Customer_Name");
	    String cl=request.getParameter("Customer_Location");
	    
	    String b=request.getParameter("Brewery_Name");
	    String bl=request.getParameter("Brewery_Location");
	  
	    String bn=request.getParameter("Beer_Name");  
	    String i=request.getParameter("In_Stock"); 
	    String mi=request.getParameter("Maker_ID");  
	    String pr=request.getParameter("Price"); 
	    
	    String ci=request.getParameter("Customer_ID");  
	    String bi=request.getParameter("Beer_ID");
	    String a=request.getParameter("Amount");
	    
	    
		// System.out.println(n);
	    // System.out.println(p);
    	
	    if (t.equals("brewery")){
	    	
	    	// System.out.println(b);
	    	// System.out.println(bl);
	    	
	    	LoginDB.update(n,p,t,b,bl,c,a);
	    	
	    	RequestDispatcher rd=request.getRequestDispatcher("suppliers.jsp");  
	        rd.forward(request,response);  
	    		
	    }else if(t.equals("customers")) {
	    	
	    	// System.out.println(c);
	    	// System.out.println(cl);
	    	LoginDB.update(n,p,t,c,cl,b,a);
	    	RequestDispatcher rd=request.getRequestDispatcher("customers.jsp");  
	        rd.forward(request,response);  
	    	
	    }else if(t.equals("beers")) {
	    	
	    	// System.out.println(bn);
	    	// System.out.println(i);
	    	// System.out.println(mi);
	    	// System.out.println(pr);
	    	LoginDB.update(n,p,t,bn,i,mi,pr);
	    	RequestDispatcher rd=request.getRequestDispatcher("products.jsp");  
	        rd.forward(request,response);  
	    	
	    }else if (t.equals("orders")){
	    	
	    	// System.out.println(ci);
	    	// System.out.println(bi);
	    	// System.out.println(a);
	    	LoginDB.update(n,p,t,ci,bi,a,pr);
	    	RequestDispatcher rd=request.getRequestDispatcher("orders.jsp");  
	        rd.forward(request,response);  
	    	    	
	    }
	    
	}

}
