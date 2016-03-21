package hu.schonhertz.training.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import hu.schonhertz.training.blog.dao.CommentDao;
import hu.schonhertz.training.blog.dto.Comment;
import hu.schonhertz.training.blog.mapper.CommentMapper;

@Repository
public class CommentDaoImpl extends JdbcDaoSupport implements CommentDao {

	@Autowired
	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Comment> getAllCommentByBlogId(int blogId) {
		String sql = "SELECT id, blog_id, comment FROM public.\"Comment\" WHERE blog_id = ? ;";
		List<Comment> comments = getJdbcTemplate().query(sql, new Object[] { blogId }, new CommentMapper());
		return comments;
	}

	@Override
	public void createComment(int blogId, String comment) {

		String sql = "INSERT INTO public.\"Comment\"(blog_id, comment)  VALUES ( ?, ?);";
		getJdbcTemplate().update(sql, blogId, comment);
	}

}
