package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.Comment;
import hu.schonhertz.training.blog.vo.CommentVo;

public class CommentMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static CommentVo toVo(Comment comment) {
		return mapper.map(comment, CommentVo.class);
	}

	public static Comment toDto(CommentVo commentVo) {
		return mapper.map(commentVo, Comment.class);
	}

	public static List<CommentVo> toVo(List<Comment> comments) {
		List<CommentVo> commentVos = new ArrayList<>();
		for (Comment comment : comments) {
			commentVos.add(toVo(comment));
		}
		return commentVos;
	}

	public static List<Comment> toDto(List<CommentVo> commentVos) {
		List<Comment> comments = new ArrayList<>();
		for (CommentVo commentVo : commentVos) {
			comments.add(toDto(commentVo));
		}
		return comments;
	}

}
