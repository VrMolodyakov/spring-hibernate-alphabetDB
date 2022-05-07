package com.example.HiberTest.GlobalExeptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

@ControllerAdvice
class globalControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleMyException(HttpServletRequest req, Exception e) {

        ModelAndView model = new ModelAndView();
        //model.addObject("errCode", mex.getErrCode());
        //model.addObject("errMsg", mex.getErrMsg());
        model.addObject("myerror",e.toString());
        model.addObject("message",e.getMessage());
        model.addObject("exception","bind exception");
        model.setViewName("myError");

        System.out.println("i'm here");


        return model;
    }
}
