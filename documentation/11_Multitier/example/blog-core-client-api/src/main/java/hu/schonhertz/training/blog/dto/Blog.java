package hu.schonhertz.training.blog.dto;

import java.io.Serializable;

public class Blog implements Serializable {

	private static final long serialVersionUID = 9059507249101106233L;

	private Integer id;
	private String creator;
	private String title;
	private String text;

	public Blog() {
		super();
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getCreator() {
		return creator;
	}

	public final void setCreator(String creator) {
		this.creator = creator;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", creator=" + creator + ", title=" + title + ", text=" + text + "]";
	}

}
