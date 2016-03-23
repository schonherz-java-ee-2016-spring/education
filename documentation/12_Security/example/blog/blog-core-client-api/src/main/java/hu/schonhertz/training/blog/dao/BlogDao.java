package hu.schonhertz.training.blog.dao;

import java.util.List;

import hu.schonhertz.training.blog.dto.Blog;

public interface BlogDao {

	public List<Blog> getAllBlog();

	public Blog getBlogById(int id);

	public default void createBlog(String title, String text) {
		this.createBlog("Anonymous", title, text);
	}

	public void createBlog(String creator, String title, String text);

}
