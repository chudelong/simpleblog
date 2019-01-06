package ssm.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;

import java.util.List;

/**
 * @Author: chudelong
 * @Date: 2019/1/1 22:04
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeDao blogTypeDao;

    @Override
    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
        //查询分页结果
        List<BlogType> blogTypeList = blogTypeDao.listByPage(pageBean.getStart(), pageBean.getEnd());
        pageBean.setResult(blogTypeList);

        //查询记录总数
        Long total = blogTypeDao.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }
}
