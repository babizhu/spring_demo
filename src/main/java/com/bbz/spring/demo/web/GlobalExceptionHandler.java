package com.bbz.spring.demo.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    class MyException {
        private int id;
        private String describ;

        MyException(int id, String describ) {
            this.id = id;
            this.describ = describ;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescrib() {
            return describ;
        }

        public void setDescrib(String describ) {
            this.describ = describ;
        }
    }

    @ExceptionHandler({Exception.class})
    public Object handleArrayIndexOutOfBoundsException(Exception e) {
        e.printStackTrace();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return new MyException(404, "Not Found");
        }
        return e;
    }
}
