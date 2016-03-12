package hu.schonhertz.training.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import hu.sconhertz.training.beans.CommentsBean;

/**
 * Servlet implementation class HelloJSPAction
 */
public class HelloJSPAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String COMMENTSBEAN = "commentsBean";
	private static final String NEWCOMMENT = "newcomment";
	private static final String NAME = "name";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloJSPAction() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // commentsBean is application scoped, so ServerContext will contain it, and not request or session
		CommentsBean commentsBean = (CommentsBean) getServletContext().getAttribute(COMMENTSBEAN);
		String newComment = request.getParameter(NEWCOMMENT);
		
		// add the new comment to the bean comments list
		List<String> comments = commentsBean.getComments();
		// if there is no comment, then we need to initialize it.
		if (comments == null) comments = new ArrayList<String>();
		// escape the HTML codes
		comments.add(StringEscapeUtils.escapeHtml(newComment));
		commentsBean.setComments(comments);
		
		// at the end of post, the server will forward the request to the HelloJsp.jsp
		// in this case the the URL will be http://localhost:8080/servlet/HelloJSPAction
		  // Note: This is a good solution as well, but to be more user-friendly (do not change the URL)
		  //  - in index.jsp use "HelloJSPAction" instead of "jsp/HelloJsp.jsp"
		  //  - override the doGet method to forward to the JSP like below
	  /*RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/HelloJsp.jsp");
		dispatcher.forward(request, response);*/
		
		// at the end of post, the server will redirect the browser to the HelloJsp.jsp
		// in this case the post parameters will be lost such as name
		  // Note: You can store name in session as well, and the it will be accessible later
		String name = request.getParameter(NAME);
		response.sendRedirect("jsp/HelloJsp.jsp?name=" + name);
		
	}

}
