package hu.schonhertz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

import hu.sconhertz.training.beans.CommentsBean;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Constants help for avoid typos, and make refactor easier
	private static final String NEWCOMMENT = "newcomment";
	private static final String NAME = "name";
	private static final String COMMENTS = "comments";
	
	private String[] contributors = {"Kiss Aladár", "Nagy Béla"};
	private CommentsBean commentsBean; //= new CommentsBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  // Handle GET requests
	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // redirect the browser to URL
	  //response.sendRedirect("http://www.google.com");
	  
	  // parameter: true to create a new session for this request if necessary; false to return null if there's no current session 
	  HttpSession session = request.getSession(true);
	  if (session.getAttribute(COMMENTS) == null) {
	    session.setAttribute(COMMENTS, new CommentsBean());
	  }
	  commentsBean = (CommentsBean) session.getAttribute(COMMENTS);
	  
	  // Read value of "name" request parameter (?name=value)
	  String name = (request.getParameter(NAME) != null ? request.getParameter(NAME) : "Servlet");
	  // response.getWriter() this will be written into body.
		PrintWriter out = response.getWriter();
		out.append("<h1>Hello " + name + "!</h1>");
		
		if(this.commentsBean.getComments() != null) {
		  // if there are comments then those will be shown
  		for (String comment : commentsBean.getComments()) {
        out.append("<div style='border: solid 1px;'>" + comment.replace("\n", "<br/>") + "</div>");
      }
		} else {
		  // There is no comment at the moment
		  out.append("<div>There is no comment yet</div>");
		}
		
		// form what will be sent in POST request
		out.append("<form action='HelloServlet' method='POST'>");
		// Hidden input won't be shown, but the value will be sent
		out.append("<input name='" + NAME + "' type='hidden' value='" + name + "'></input>");
		// textarea is a multi-line text input field
		out.append("<textarea name='" + NEWCOMMENT + "'></textarea>");
		// submit button
		out.append("<input type='submit' value='Submit'></imput>");
		out.append("</form>");
		
		// footer goes bottom of the page
		out.append("<footer>");
		out.append("<h2>Contributors:</h2>");
		out.append("<ul>");
		// put all contributor to a list item (<li>)
		for (String contributor : contributors) {
      out.append("<li>" + contributor + "</li>");
    }
		out.append("</ul>");
		out.append("</footer>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// Handle POST requests
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> comments;
		HttpSession session = request.getSession(true);
		// If comments are not exist in session, then create a new one
		if (session.getAttribute(COMMENTS) == null) {
		  this.commentsBean = new CommentsBean();
		// Use the exits comments form session
		} else {
		  this.commentsBean = (CommentsBean) session.getAttribute(COMMENTS);
		}
		// If comments in commentsBean is null then local comments will be a new list 
	  if (this.commentsBean.getComments() == null) {
		  comments = new ArrayList<String>();
		// Else, the local comment will be the already exist comments from commentsBean
		} else {
		  comments = commentsBean.getComments();
		}
		//System.out.println(request.getParameter(NEWCOMMENT));
		//System.out.println(StringEscapeUtils.escapeHtml(request.getParameter(NEWCOMMENT)));
		// Replace special characters (like: <, >) to an escaped charters
		comments.add(StringEscapeUtils.escapeHtml(request.getParameter(NEWCOMMENT)));
		this.commentsBean.setComments(comments);
		session.setAttribute(COMMENTS, this.commentsBean);
		for (String string : comments) {
      System.out.println(string);
    }
		doGet(request, response);
	}

}
