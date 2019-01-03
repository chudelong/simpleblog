package ssm.blog.service;

import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;

/**
 * @Author: chudelong
 * @Date: 2019/1/1 21:56
 * @Description 博客类别的service接口
 */

public interface BlogTypeService {

    //分页查询
    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);
}
