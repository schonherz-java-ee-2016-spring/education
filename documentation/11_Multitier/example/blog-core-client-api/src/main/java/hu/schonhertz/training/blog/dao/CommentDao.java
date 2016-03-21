package hu.schonhertz.training.blog.dao;

import java.util.List;

import hu.schonhertz.training.blog.dto.Comment;

public interface CommentDao {
  
  public List<Comment> getAllCommentByBlogId(int blogId);
  
  public void createComment(int blogId, String comment);

}
