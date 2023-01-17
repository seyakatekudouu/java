package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndividualDAO;
import dto.Individual;

/**
 * Servlet implementation class roguinservlet
 */
@WebServlet("/roguinservlet")
public class roguinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roguinservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mail=request.getParameter("mail");
		String pw=request.getParameter("PW");
		
		// 入力された情報を元にインスタンスを生成
				Individual individual = new Individual(mail,pw);
				
				// SQL実行
				int result = IndividualDAO.registerIndividual(individual);
				
				if(result == 1) {
					String view = "WEB-INF/view/success.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				} else {
					String view = "WEB-INF/view/fail.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
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
