package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		CustomerService service=(CustomerService)CustomerService.getInstance();
		Customer customer=service.login(id,password); //id와 pwd를 customer에 넘겨줌
        
		request.setAttribute("customer" , customer);//customer에 customer 저장
		
	    String page;
	    
	    //회원가입 정보가 없는 경우.
	    if(customer==null){
	    	page="/view/loginFail.jsp";
	    	request.setAttribute("id", id);
	    } 
	    //회원가입 정보가 있는 경우.
	    else {
	    	page="/view/loginSuccess.jsp";
	    	request.setAttribute("customer", customer);
	    }
	    
	    RequestDispatcher dispatcher=request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
