package task.from.intelligence.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.from.intelligence.pojo.Prod_pojo;
import task.from.intelligence.service.CatService;
import task.from.intelligence.service.CatServiceImpl;
import task.from.intelligence.servlet.validation.ValidationException;

@WebServlet("/search-service/search")
public class SearchController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // Get submitted fields
	    String cat = request.getParameter("cat");
	    String product = request.getParameter("product");
	    String salary_min = request.getParameter("salary_min");
	    String salary_max = request.getParameter("salary_max");

	    // Instantiate the exception with the default message
	    ValidationException validationEx = new ValidationException("Error validating submission", "search.jsp");

	    // Mandatory text field validation.
	    if ((null == cat || cat.length() == 0)&&
	    	(null == product || product.length() == 0) &&
	    	(null == salary_min || salary_min.length() == 0) &&
	    	(null == salary_max || salary_max.length() == 0)
	       )
	        validationEx.addMessage("At least one field must be filled", "msgMandatoryField");
	    

	    // Throw exeption (if being) and pass to Get
	    ValidationException fd = validationEx.raise();
	    if(fd != null) {request.setAttribute("validationException", fd); doGet(request,response);}
	    
	    else{
	    		CatService catService = new CatServiceImpl();
				Prod_pojo pj = new Prod_pojo();
				
				pj.setCatname(cat);
				pj.setProdname(product);
				pj.setPrice_max(salary_max);
				pj.setPrice_min(salary_min);
				
		
				request.setAttribute("resultList", catService.seacrh(pj));
				RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
				dispatcher.forward(request, response);
	    }
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CatService catService = new CatServiceImpl();
		List<Prod_pojo> listcat = catService.getAll_criteria();
		request.setAttribute("resultList", listcat);
		
		ValidationException ve = (ValidationException)request.getAttribute("validationException");
		//if was to 'redirect' through doGet(request,response) from post i.e. being exception
		if(null != ve) {throw new ServletException(ve);}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
