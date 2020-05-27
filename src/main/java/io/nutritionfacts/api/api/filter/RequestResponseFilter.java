package io.nutritionfacts.api.api.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class RequestResponseFilter implements Filter {
    private final RequestContextBuilder requestContextBuilder;

    public RequestResponseFilter(RequestContextBuilder requestContextBuilder) {
        this.requestContextBuilder = requestContextBuilder;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        requestContextBuilder.buildContext(servletRequest);

        filterChain.doFilter(servletRequest, servletResponse);

        //TODO log request and response here
    }
}
