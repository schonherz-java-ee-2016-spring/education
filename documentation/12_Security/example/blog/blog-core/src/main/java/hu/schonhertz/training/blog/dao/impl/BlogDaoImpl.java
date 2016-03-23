package hu.schonhertz.training.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonhertz.training.blog.dao.BlogDao;
import hu.schonhertz.training.blog.dto.Blog;
import hu.schonhertz.training.blog.mapper.BlogMapper;

@Repository
public class BlogDaoImpl extends JdbcDaoSupport implements BlogDao {

	@Autowired
	public BlogDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Blog> getAllBlog() {
		String sql = "SELECT id, creator, title, text FROM public.\"Blog\";";
		List<Blog> blogs = getJdbcTemplate().query(sql, new BlogMapper());
		return blogs;

	}

	@Override
	public Blog getBlogById(int id) {
		String sql = "SELECT id, creator, title, text FROM public.\"Blog\" WHERE id = ?;";
		Blog blog = getJdbcTemplate().queryForObject(sql, new BlogMapper(), id);
		return blog;
	}

	@Override
	public void createBlog(String creator, String title, String text) {
		String sql = "INSERT INTO public.\"Blog\"(creator, title, text) VALUES (?, ?, ?);";
		getJdbcTemplate().update(sql, creator, title, text);
	}

}
