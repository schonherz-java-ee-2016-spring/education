package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.dao.CommentDao;
import hu.schonhertz.training.blog.dto.Comment;
import hu.schonhertz.training.blog.service.CommentService;
import hu.schonhertz.training.blog.service.mapper.CommentMapper;
import hu.schonhertz.training.blog.vo.CommentVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;

	@Override
	public List<CommentVo> getAllCommentByBlogId(Integer blogId) {
		List<Comment> comments = commentDao.getAllCommentByBlogId(blogId);
		return CommentMapper.toVo(comments);
	}

	@Override
	public void createComment(CommentVo commentVo) {
		commentDao.createComment(commentVo.getBlogId(), commentVo.getComment());

	}

}
