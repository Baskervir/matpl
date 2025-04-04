package com.example.matpl.handler;

import com.example.matpl.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalViewExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneral(Exception e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errorMessage", "알 수 없는 오류가 발생했습니다.");
        return mav;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ModelAndView handleUserAlreadyExists(UserAlreadyExistsException e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ModelAndView handleInvalidPassword(InvalidPasswordException e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

    @ExceptionHandler(TokenException.class)
    public ModelAndView handleToken(TokenException e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

    @ExceptionHandler(DisableLoginException.class)
    public ModelAndView handleDisableLogin(DisableLoginException e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFound(UserNotFoundException e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("errorMessage", "존재하지 않는 사용자입니다.");
        return mav;
    }


}
