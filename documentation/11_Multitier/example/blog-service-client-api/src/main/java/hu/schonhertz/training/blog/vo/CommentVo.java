package hu.schonhertz.training.blog.vo;

import java.io.Serializable;

public class CommentVo implements Serializable {

	private static final long serialVersionUID = -4877641302795620514L;

	private Integer id;
	private Integer blogId;
	private String comment;

	public CommentVo() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the blogId
	 */
	public Integer getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
