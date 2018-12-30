package ssm.blog.dao;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.blog.entity.BlogType;

import java.util.List;

/**
 * @Author: chudelong
 * @Date: 2018/12/27 21:32
 * @Description 博客类别dao测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class BlogTypeDaoTest  {

    @Autowired
    private BlogTypeDao blogTypeDao;

    @Test
    public void addBlogType() throws Exception {
        BlogType blogType = new BlogType("MySQL", 10);
        int result = blogTypeDao.addBlogType(blogType);
        System.out.println(result);
    }

    @Test
    public void deleteBlogType() throws Exception {
        int result = blogTypeDao.deleteBlogType(16);
        System.out.println(result);
    }

    @Test
    public void updataBlogType() throws Exception {
        BlogType blogType = blogTypeDao.getById(17);
        blogType.setTypeName("oracle");
        int result = blogTypeDao.updateBlogType(blogType);
        System.out.println("======================="+result+"++++++++++++++++++++");
    }

    @Test
    public void getById() throws Exception {
        BlogType blogType = blogTypeDao.getById(17);
        System.out.println(blogType+"=======++++++++++++++++++++++++++++++++++++++++");
    }

    @Test
    public void listByPage() {
        Integer page = 1;//第一页
        Integer pageSize = 2;//一页显示的条数
        Integer start = (page - 1) * pageSize;
        Integer end = page * pageSize;

        List<BlogType> blogTypeList = blogTypeDao.listByPage(start, end);
        for (BlogType blogType : blogTypeList) {
            System.out.println(blogType+"===============================================");
        }
    }

    @Test
    public void getTotal(){
        long total = blogTypeDao.getTotal();
        System.out.println(total+"=====================");
    }

}




















