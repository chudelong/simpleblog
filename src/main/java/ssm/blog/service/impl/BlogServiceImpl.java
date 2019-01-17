package ssm.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;

import java.util.List;
import java.util.Map;

/**
 * @Author: chudelong
 * @Date: 2019/1/14 22:30
 * @Description 博客Service实现类
 */

@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;
    
    @Override
    public List<Blog> listBlog(Map<String, Object> map) {
        return null;
    }

    @Override
    public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean) {
        return null;
    }

    @Override
    public Integer getBlogByTypeId(Integer typeId) {
        return null;
    }

    @Override
    public Integer saveBlog(Blog blog) {
        return null;
    }

    @Override
    public Integer insertBlog(Blog blog) {
        return null;
    }

    @Override
    public Integer deleteBlog(Integer id) {
        return null;
    }

    @Override
    public Blog getById(Integer id) {
        return null;
    }

    @Override
    public long getTotal(Map<String, Object> map) {
        return 0;
    }
}
