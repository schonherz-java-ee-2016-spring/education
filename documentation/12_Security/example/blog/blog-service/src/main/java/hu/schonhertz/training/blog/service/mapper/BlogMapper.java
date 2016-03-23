package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.Blog;
import hu.schonhertz.training.blog.vo.BlogVo;

public class BlogMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static BlogVo toVo(Blog blog) {
		return mapper.map(blog, BlogVo.class);
	}

	public static Blog toDto(BlogVo blogVo) {
		return mapper.map(blogVo, Blog.class);
	}

	public static List<BlogVo> toVo(List<Blog> blogs) {
		List<BlogVo> blogVos = new ArrayList<>();
		for (Blog blog : blogs) {
			blogVos.add(toVo(blog));
		}
		return blogVos;
	}

	public static List<Blog> toDto(List<BlogVo> blogVos) {
		List<Blog> blogs = new ArrayList<>();
		for (BlogVo blogVo : blogVos) {
			blogs.add(toDto(blogVo));
		}
		return blogs;
	}

}
