package task.from.intelligence.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import task.from.intelligence.entity.Cat;
import task.from.intelligence.service.CatService;
import task.from.intelligence.service.CatServiceImpl;

@WebServlet("/search-service/search")
public class SearchController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cat = request.getParameter("cat");
		String product = request.getParameter("product");
		String salary_min = request.getParameter("salary_min");
		String salary_max = request.getParameter("salary_max");
		

		CatService catService = new CatServiceImpl();
		Cat cat_model = new Cat();
		List<Cat> listcat = catService.findAllCat();
		
		System.out.println("TEST "+listcat);

		//List<Employee> allEmployees = employeeService.findAllEmployees();
		request.setAttribute("allList", listcat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CatService catService = new CatServiceImpl();
		List<Cat> listcat = catService.findAllCat();
		
		request.setAttribute("allList", listcat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
