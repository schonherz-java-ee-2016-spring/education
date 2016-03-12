package hu.sconhertz.training.beans;

import java.io.Serializable;
import java.util.List;


public class CommentsBean implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private List<String> comments;

  public CommentsBean() {
    super();
  }

  public List<String> getComments() {
    return comments;
  }

  public void setComments(List<String> comments) {
    this.comments = comments;
  }

}
