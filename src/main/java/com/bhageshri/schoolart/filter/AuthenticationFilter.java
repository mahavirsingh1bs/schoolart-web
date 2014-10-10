/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahavir.singh
 */
public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig;
    
    private static final String SHOW_LOGIN_URL = "showLogin";
    private static final String LOGIN_URL = "login";
    private static final String EMPTY_URL = "";
    private static final String IS_AUTHENTICATED = "isUserAuthenticated";
    private static final String SLASH = "/";
    
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.filterConfig = fc;
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest )sr;
        HttpServletResponse response = (HttpServletResponse ) sr1;
        HttpSession session = request.getSession();
        String requestedPage = getRequestedPage(request);
        if (!(request.getRequestURI().contains(LOGIN_URL) || requestedPage.contains(SHOW_LOGIN_URL)) && session.getAttribute(IS_AUTHENTICATED) == null) {
            response.sendRedirect(SHOW_LOGIN_URL);
            return;
        } else if (session.getAttribute(IS_AUTHENTICATED) != null) {
            fc.doFilter(request, response);
        } else if (request.getRequestURI().contains(LOGIN_URL) || requestedPage.contains(SHOW_LOGIN_URL)) {
            fc.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
    
    private String getRequestedPage(HttpServletRequest request) {
        String url = request.getRequestURI();
        int firstSlash = url.indexOf("/", 1);
        String requestedPage = null;
        if (firstSlash != -1)
            requestedPage = url.substring(firstSlash + 1, url.length());
        return requestedPage;
    }
    
}
