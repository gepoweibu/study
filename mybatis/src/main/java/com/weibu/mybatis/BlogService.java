package com.weibu.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weibu.dao.IBlog;
import com.weibu.pojo.Author;
import com.weibu.pojo.Blog;
import com.weibu.pojo.Post;

public class BlogService {
	private static SqlSession session;//非线程安全类，最好在方法的获取，用完就关闭。工厂类可以是静态或单例的全局应用。
	private static IBlog iblog;
	static {
		try {
			String resource = "MybatisConfig.xml";
			InputStream ins = Resources.getResourceAsStream(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(ins);
			session = ssf.openSession(true);
			iblog = session.getMapper(IBlog.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			selectBlog("1");
			selectBlogPost("2");
			selectBlogNest("2");
		}finally {
			session.close();
		}
	}
	
	public static void selectBlog(String blogId) {
		Blog blog = iblog.selectBlog(blogId);
		//Author author = blog.getAuthor();
		System.out.println("---一对一关联查询---");
		System.out.println(blog);
	}
	public static void selectBlogPost(String blogId) {
		System.out.println("---一对多关联查询---");
		Blog blog = iblog.selectBlogPsot(blogId);
		String title = blog.getTitle();
		Author author = blog.getAuthor();
		List<Post> posts = blog.getPosts();
		System.out.println("blog tiele: "+title+"\nblog author: "+author.getUsername());
		for (Post post : posts) {
			System.out.println("post subject: "+post.getSubject());
		}
	}
	public static void selectBlogNest(String blogId) {
		System.out.println("---一对多嵌套查询---");
		Blog blog = iblog.selectBlogPsot(blogId);
		String title = blog.getTitle();
		Author author = blog.getAuthor();
		List<Post> posts = blog.getPosts();
		System.out.println("blog tiele: "+title+"\nblog author: "+author.getUsername());
		for (Post post : posts) {
			System.out.println("post subject: "+post.getSubject());
		}
	}

}
