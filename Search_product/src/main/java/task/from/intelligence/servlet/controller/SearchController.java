package task.from.intelligence.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import task.from.intelligence.bean.validation.SearchFormValidationBean;
import task.from.intelligence.entity.Cat;
import task.from.intelligence.service.CatService;
import task.from.intelligence.service.CatServiceImpl;
import task.from.intelligence.servlet.validation.ValidationException;

@WebServlet("/search-service/search")
public class SearchController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	    // Clear any old bean and create a new one in session keeping data from
	    // parameters in the request.
		HttpSession session = request.getSession();
	    session.removeAttribute("searchFormValidationBean");
		SearchFormValidationBean searchFormValidationBean = new SearchFormValidationBean();
	    session.setAttribute("searchFormValidationBean", searchFormValidationBean);

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
	    else
	    	searchFormValidationBean.setMandatoryTextField(cat);

	    // if any submitted data has been rejected, bounce back...
	    ValidationException fd = validationEx.raise();
	    if(fd != null) throw new ServletException(fd);

	    //make the bean persistent
	    searchFormValidationBean.store();

	    // the sampleBean is now persistent, we do not need it in session.
	    session.removeAttribute("searchFormValidationBean");

		
		

		CatService catService = new CatServiceImpl();
		Cat cat_model = new Cat();
		List<Cat> listcat = catService.findAllCat();
		
		System.out.println("TEST "+listcat);

		//List<Employee> allEmployees = employeeService.findAllEmployees();
		request.setAttribute("resultList", listcat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CatService catService = new CatServiceImpl();
		List<Cat> listcat = catService.findAllCat();
		
		request.setAttribute("resultList", listcat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
