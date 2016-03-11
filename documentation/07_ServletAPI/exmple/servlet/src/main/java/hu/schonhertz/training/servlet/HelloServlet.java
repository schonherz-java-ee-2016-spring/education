package hu.schonhertz.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Constants help for avoid typos, and make refactor easier
	private static final String NEWCOMMENT = "newcomment";
	private static final String NAME = "name";
	
	private String[] contributors = {"Kiss Aladár", "Nagy Béla"};
	private List<String> comments;
       
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
	  // Read value of "name" request parameter (?name=value)
	  String name = (request.getParameter(NAME) != null ? request.getParameter(NAME) : "Servlet");
	  // response.getWriter() this will be written into body.
		PrintWriter out = response.getWriter();
		out.append("<h1>Hello " + name + "!</h1>");
		
		if(this.comments != null) {
		  // if there are comments then those will be shown
  		for (String comment : comments) {
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
		if (this.comments == null) {
		  this.comments = new ArrayList<String>();
		}
		//System.out.println(request.getParameter(NEWCOMMENT));
		//System.out.println(StringEscapeUtils.escapeHtml(request.getParameter(NEWCOMMENT)));
		// Replace special characters (like: <, >) to an escaped charters
		this.comments.add(StringEscapeUtils.escapeHtml(request.getParameter(NEWCOMMENT)));
		for (String string : comments) {
      System.out.println(string);
    }
		doGet(request, response);
	}

}
