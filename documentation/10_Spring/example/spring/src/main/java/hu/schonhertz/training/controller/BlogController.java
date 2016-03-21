package hu.schonhertz.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonhertz.training.jdbctemplate.BlogJDBCTemplate;
import hu.schonhertz.training.pojo.Blog;


@Controller
@RequestMapping("/blog")
public class BlogController {
  
  @Autowired
  private BlogJDBCTemplate blogJDBCTemplate;
  
  @RequestMapping(method = RequestMethod.GET)
  public String listBlogs(Model model) {
    List<Blog> blogs = blogJDBCTemplate.getAllBlog();
    model.addAttribute("blogs", blogs);
    return "blog/blogindex";
  }

}
