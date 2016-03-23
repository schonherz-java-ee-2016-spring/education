package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.dao.BlogDao;
import hu.schonhertz.training.blog.dto.Blog;
import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.service.mapper.BlogMapper;
import hu.schonhertz.training.blog.vo.BlogVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Override
	public List<BlogVo> getAllBlog() {
		List<Blog> blogs = blogDao.getAllBlog();
		return BlogMapper.toVo(blogs);
	}

	@Override
	public BlogVo getBlogById(Integer id) {
		Blog blog = blogDao.getBlogById(id);
		return BlogMapper.toVo(blog);
	}

	@Override
	public void createBlog(BlogVo blogVo) {
		blogDao.createBlog(blogVo.getCreator(), blogVo.getTitle(), blogVo.getText());
	}

}
