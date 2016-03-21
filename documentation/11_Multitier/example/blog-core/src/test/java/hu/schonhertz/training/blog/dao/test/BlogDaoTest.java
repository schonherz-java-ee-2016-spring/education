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

import hu.schonhertz.training.blog.dao.BlogDao;
import hu.schonhertz.training.blog.dto.Blog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-core-test.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@Rollback(false)
public class BlogDaoTest {
	@Autowired
	BlogDao blogDao;

	@Test
	public void test1CreateDef() {
		blogDao.createBlog("Test", "test");
	}

	@Test
	public void test2Create() {
		blogDao.createBlog("TestUser", "Test", "test");
	}

	@Test
	public void test2GetAll() {
		List<Blog> blogs = blogDao.getAllBlog();
		Assert.assertEquals(2, blogs.size());
	}

	@Test
	public void test2GetById() {
		Blog blog = blogDao.getBlogById(1);
		Assert.assertEquals("Test", blog.getTitle());
	}
}
