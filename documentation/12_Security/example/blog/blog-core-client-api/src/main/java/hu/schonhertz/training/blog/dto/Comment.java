package hu.schonhertz.training.blog.dto;

import java.io.Serializable;

public class Comment implements Serializable {

	private static final long serialVersionUID = 8899131570615506546L;

	private Integer id;
	private Integer blogId;
	private String comment;

	public Comment() {
		super();
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final Integer getBlogId() {
		return blogId;
	}

	public final void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public final String getComment() {
		return comment;
	}

	public final void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", blogId=" + blogId + ", comment=" + comment + "]";
	}

}
