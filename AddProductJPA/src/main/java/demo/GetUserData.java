package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@WebServlet("/GetUserData")
public class GetUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_barcode=request.getParameter("pbarcode");
		String product_name=request.getParameter("pname");
		String product_color=request.getParameter("pcolor");
		String product_description=request.getParameter("pdescription");
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		
		boolean numeric_string=false;
		boolean everything_submited=true;
		boolean barcode_exists = false;
		
		if (product_barcode.equals(""))
		{
			everything_submited=false;
		}
			
		if (product_barcode.matches("[0-9]+")) {numeric_string=true; }
		
		
		if (product_name.equals(""))
		{
			everything_submited=false;
		}
		
		if (product_color.equals(""))
		{
			everything_submited=false;
		}
		
		if (product_description.equals(""))
		{
			everything_submited=false;
		}

		
		if (everything_submited==true) {
			
			if (numeric_string==true) {
				
				Product product_to_check=null;
				Transaction tx = hib_session.beginTransaction();
				product_to_check = (Product) hib_session.get(Product.class, product_barcode);
				tx.commit();
				
				if(product_to_check!=null) {barcode_exists=true;}
				
				if (barcode_exists==true) 
				{
					request.setAttribute("barcode_exists", "yes");
					 
				    request.getRequestDispatcher("WrongData.jsp").forward(request, response);
				}
				else 
				{
					Product product_to_save=new Product();
					product_to_save.setBarcode(product_barcode);
					product_to_save.setPname(product_name);
					product_to_save.setColor(product_color);
					product_to_save.setpDescription(product_description);
					
					tx = hib_session.beginTransaction();
					hib_session.save(product_to_save);
					tx.commit();
					
					request.setAttribute("product_saved", product_to_save);
				    request.getRequestDispatcher("Success.jsp").forward(request, response);
				}
			}
			else 
			{
				request.setAttribute("barcode_exists", "no");
				request.setAttribute("numeric", "no");
				 
			    request.getRequestDispatcher("WrongData.jsp").forward(request, response);
			}
		}
		else 
		{
			request.setAttribute("barcode_exists", "no");
			request.setAttribute("numeric", "yes");
			request.setAttribute("submited_everything", "no");
			 
		    request.getRequestDispatcher("WrongData.jsp").forward(request, response);
		}
		
	}
	
}
