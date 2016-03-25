package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.entity.Blog;
import hu.schonhertz.training.blog.repository.BlogRepository;
import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.service.mapper.BlogMapper;
import hu.schonhertz.training.blog.vo.BlogVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BlogServiceImpl implements BlogService {

	static final Logger logger = LogManager.getLogger(BlogServiceImpl.class.getName());

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<BlogVo> getAllBlog() {
		List<Blog> blogs = null;
		try {
			blogs = blogRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BlogMapper.toVo(blogs);
	}

	@Override
	public BlogVo getBlogById(Long id) {
		Blog blog = null;
		try {
			blog = blogRepository.findOne(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BlogMapper.toVo(blog);
	}

	@Override
	public void createBlog(BlogVo blogVo) {
		try {
			blogRepository.save(BlogMapper.toDto(blogVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
