package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.CommentVo;

public interface CommentService {

	public List<CommentVo> getAllCommentByBlogId(Integer blogId);

	public void createComment(CommentVo commentVo);
}
