package com.hyh.action.demo.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Demo class
 *
 * @author hyh
 * @date 2019/3/9
 */
@Controller
public class AnnotationController {
    /**请求映射地址 http://localhost:8080/gitcode/test*/
    @RequestMapping(value="/test")
    public String goTest(HttpServletRequest request){
        //输出请求URL路径
        System.out.println(request.getRequestURL());
        return "index";
    }
}
