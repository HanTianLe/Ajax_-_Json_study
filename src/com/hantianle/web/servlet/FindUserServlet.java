package com.hantianle.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hantianle.web.service.FindUserService;
import com.hantianle.web.service.Impl.FindUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {

    private FindUserService findUserService = new FindUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取用户名
        String username = request.getParameter("username");
        //2、调用service层判断用户名是否存在
        //期望服务器响应的数据格式：{"userExist":true,"msg":"此用户名太受欢迎，请更换一个"}
        //                     {"userExist":false,"msg":"用户名可用"}
        /**
         *  编码设置，解决乱码问题
         *  用了这个方法，
         *  $.get(type):将最后一个参数type要指定为 "json"
         */
        //response.setContentType("text/html;charset=utf-8");
        /** 设置响应的数据格式为 json
         *  用了这个方法，
         *  $.get(type):最后一个参数type不需要指定为 "json"
         */
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String, Object>();
        // findUserService.FindUserByUsername(username) -->判断用户是否在数据库中存在
        if (findUserService.FindUserByUsername(username)){
            //存在
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请更换一个");
        }else {
            //不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

