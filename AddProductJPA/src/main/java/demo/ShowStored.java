package demo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/ShowStored")
public class ShowStored extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		
		
	    List<Product> products =new  ArrayList<Product>();
		
	    hib_session.beginTransaction();
	    
	    products = hib_session.createQuery("from Product", Product.class).getResultList();
	    
	    hib_session.getTransaction().commit();
	    
	    
	    request.setAttribute("products", products);
	 
	    request.getRequestDispatcher("stored.jsp").forward(request, response);
		
	}
}
