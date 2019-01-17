package ssm.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;

import java.util.HashMap;
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
        return blogDao.listBlog(map);
    }

    @Override
    public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean) {
        Map<String, Object> map = new HashMap<>();
        //设置查询条件
        map.put("title", title);
        //总记录放入pageBean
        pageBean.setTotal(blogDao.getTotal(map));

        map.put("start", pageBean.getStart());
        map.put("end", pageBean.getEnd());
        //把分页结果放入pageBean
        pageBean.setResult(blogDao.listBlog(map));
        return pageBean;
    }

    @Override
    public Integer getBlogByTypeId(Integer typeId) {
        return blogDao.getBlogByTypeId(typeId);
    }

    @Override
    public Integer saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    @Override
    public Integer insertBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    public Integer deleteBlog(Integer id) {
        return blogDao.deleteBlog(id);
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

    @Override
    public long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }
}
