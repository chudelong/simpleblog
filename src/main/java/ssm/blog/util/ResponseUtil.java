package ssm.blog.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: chudelong
 * @Date: 2019/1/3 21:37
 */

public class ResponseUtil {

    /**
     * 向response对象写入数据
     * @param response
     * @param obj
     * @throws Exception
     */
    public static void write(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(obj.toString());
        out.flush();
        out.close();
    }
}