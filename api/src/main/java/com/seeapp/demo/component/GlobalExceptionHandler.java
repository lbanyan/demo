package com.seeapp.demo.component;

import com.github.mydog.common.json.JsonUtil;
import com.seeapp.demo.common.AppConstant;
import com.seeapp.demo.common.HttpJsonResult;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * controller全局统一异常处理
 *
 * @author zhuhui
 */
@Component
@Order(-500)
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final ModelAndView EMPTY_MODEL_AND_VIEW = new ModelAndView();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String errmsg = null;
        int errno = 1;
        if (ex instanceof IllegalArgumentException || ex instanceof HttpRequestMethodNotSupportedException) {
            errmsg = ex.getMessage();
        } else {
            logger.error(ex.getMessage(), ex);
            errmsg = AppConstant.SERVER_INTERNAL_ERROR;
            errno = -1;
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            HttpJsonResult httpJsonResult = new HttpJsonResult();
            httpJsonResult.errno = errno;
            httpJsonResult.errmsg = errmsg;
            writer.write(JsonUtil.writeValueAsString(httpJsonResult));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(writer);
        }
        return EMPTY_MODEL_AND_VIEW;
    }
}
