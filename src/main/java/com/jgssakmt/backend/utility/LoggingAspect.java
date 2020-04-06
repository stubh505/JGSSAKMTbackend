package com.jgssakmt.backend.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    @AfterThrowing(pointcut = "execution(* com.jgssakmt.backend.dao.*Impl.*(..))", throwing = "exception")
    public void logExceptionFromDAO(Exception exception) throws Exception {
        log(exception);
    }

    @AfterThrowing(pointcut = "execution(* com.jgssakmt.backend.service.*Impl.*(..))", throwing = "exception")
    public void logExceptionFromService(Exception exception) throws Exception {
        log(exception);
    }


    private void log(Exception exception) {
        Logger logger = LogManager.getLogger(this.getClass());
        if(exception.getMessage()!=null) {
            logger.error(exception.getMessage(), exception);
        }
    }

}
