package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Insert1to2Controller
 */
@WebServlet("/Insert1to2Controller")
public class Insert1to2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert1to2Controller() {
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
		request.setCharacterEncoding("UTF-8");
		try {
			MenuBean mbean = new MenuBean();
			mbean.setName(request.getParameter("name"));
			mbean.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
			mbean.setGenre_id(Integer.parseInt(request.getParameter("genre_id")));
			mbean.setServings(Integer.parseInt(request.getParameter("servings")));
			HttpSession session = request.getSession();
			session.setAttribute("newmenu", mbean);
			ServletContext application = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher("/newmenu2.jsp");
			rd.forward(request, response);
			
		}  catch(Exception ex) {
			ex.printStackTrace();
			response.setCharacterEncoding("Shift-JIS");
			PrintWriter out = response.getWriter();
			out.print("<h1>ERROR</h1>");
			out.print("<a href='/rei13/newrow1.jsp'>入力画面へ戻る</a>");
		}
	}

}
