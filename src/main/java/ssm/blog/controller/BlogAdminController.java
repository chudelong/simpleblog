package ssm.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;
import ssm.blog.util.ResponseUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: chudelong
 * @Date: 2019/1/21 22:04
 * @Description 管理员博客controller层
 */

@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

    @Autowired
    private BlogService blogService;

    /**
     * 后台分页查询博客信息
     * @param page
     * @param rows
     * @param s_blog
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/listBlog")
    public String listBlog(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Blog s_blog,
            HttpServletResponse response
            ) throws Exception{
        PageBean<Blog> pageBean = new PageBean<>(Integer.parseInt(page), Integer.parseInt(rows));

        pageBean = blogService.listBlog(s_blog.getTitle(), pageBean);

        //创建json对象
        JSONObject result = new JSONObject();
        //设置json序列化日期格式
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        //禁止对象循环引用
        //使用默认日期格式化
        String jsonStr = JSONObject.toJSONString(pageBean.getResult(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat);
        //得到json数组
        JSONArray json = JSONObject.parseArray(jsonStr);
        //把结果放入json
        result.put("rows", json);
        result.put("total", pageBean.getTotal());
        //返回
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 更新或者新增博客
     * @param blog
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save")
    public String saveBlog(Blog blog, HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if (blog.getId() != null){
            //更新操作
            resultTotal = blogService.saveBlog(blog);
        } else {
            //新增操作
            resultTotal = blogService.insertBlog(blog);
        }
        JSONObject result = new JSONObject();
        if (resultTotal > 0){
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}





















