package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert0to1Controller
 */
@WebServlet("/Insert0to1Controller")
public class Insert0to1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert0to1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			ArrayList<CategoryBean> categorylist = CategoryBean.getCategoryTable();
			request.setAttribute("categorytable", categorylist);
			
			ArrayList<GenreBean> genrelist = GenreBean.getGenreTable();
			request.setAttribute("genretable", genrelist);			

			ServletContext application = getServletContext();
			RequestDispatcher rd = application.getRequestDispatcher("/newmenu1.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
			response.setCharacterEncoding("Shift-JIS");
			PrintWriter out = response.getWriter();
			out.print("<h1>ERROR</h1>");
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
