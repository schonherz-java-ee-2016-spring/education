package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.CommentService;
import hu.schonhertz.training.blog.vo.CommentVo;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = -3759352952465316112L;

	@Autowired
	CommentService commentService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		CommentVo commentVo = new CommentVo();
		commentVo.setBlogId(Integer.valueOf(request.getParameter("blogId")));
		commentVo.setComment(request.getParameter("comment"));

		commentService.createComment(commentVo);

		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("OK");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Integer blogId = Integer.valueOf(request.getParameter("blogId"));
		List<CommentVo> commentVos = commentService.getAllCommentByBlogId(blogId);

		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);

		Gson gson = new Gson();
		gson.toJson(commentVos, resp.getWriter());
	}
}
