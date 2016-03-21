package hu.schonhertz.training.blog.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.dao.CommentDao;
import hu.schonhertz.training.blog.dto.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core-test.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@Rollback(false)
public class CommentDaoTest {
	@Autowired
	CommentDao commentDao;

	@Test
	public void test1CreateDef() {
		commentDao.createComment(1, "comment");
	}

	@Test
	public void test2Create() {
		List<Comment> comments = commentDao.getAllCommentByBlogId(1);
		Assert.assertEquals("comment", comments.get(0).getComment());
	}
}
