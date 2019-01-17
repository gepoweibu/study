package com.weibu.dao;

import com.weibu.pojo.Blog;

public interface IBlog {
	Blog selectBlog(String blogId);//一对一关联查询
	Blog selectBlogPsot(String blogId);//一对多关联查询
	Blog selectBlogNest(String blogID);//嵌套查询
}
