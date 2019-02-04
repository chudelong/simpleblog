package ssm.blog.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @Author: chudelong
 * @Date: 2019/2/4 12:22
 * @Description 监听程序初始化
 */

public class InitBloggerData implements ServletContextListener, ApplicationContextAware{

    private static ApplicationContext applicationContext;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //先获取servlet上下文
        ServletContext application = sce.getServletContext();
        //获取博客类别信息service
        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList", blogTypeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }
}
