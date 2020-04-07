package com.mask.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Calendar;

/**
 * 将version版本号写入application中，给css,js引用时用
 */
@Component
public class ApplicationContext implements ServletContextAware {


    @Override
    public void setServletContext(ServletContext context) {
        String contextPath = context.getContextPath();
        context.setAttribute("ctx", contextPath);
    }

}