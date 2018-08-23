//package com.bbz.spring.demo.web;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class HttpErrorHandler implements ErrorController {
//    private final static String ERROR_PATH = "/error";
//    @Override
//    public String getErrorPath() {
//        return ERROR_PATH;
//    }
//
//    /**
//     * Supports other formats like JSON, XML
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = ERROR_PATH)
//    @ResponseBody
//    public Object error(HttpServletRequest request) {
//        return "404错误！！！！";
//    }
//
//    @RequestMapping(value = ERROR_PATH, produces = "text/html")
//    public String errorHtml(HttpServletRequest request) {
//        return "/404";
//    }
//}
