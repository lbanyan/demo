package com.seeapp.servlet.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 授权认证filter
 *
 * @author zhuhui
 */
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter extends OncePerRequestFilter {

    @SuppressWarnings("serial")
    private static final Set<String> EXCLUDES = new HashSet<String>(2) {
        {
            //add("/demo/login");
        }
    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        if (EXCLUDES.contains(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        // TODO filter

        filterChain.doFilter(request, response);
    }
}
