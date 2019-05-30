package com.shop.tools;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomHandException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        AuctionCustomException ace = null;
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof AuctionCustomException){
            ace = (AuctionCustomException) e;
            modelAndView.addObject("error",ace.getMessage());
        }else{
            modelAndView.addObject("error","其他异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
