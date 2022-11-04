package io.nutritionfacts.service.api.filter;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class RequestContextBuilder {
    private final RequestContext requestContext;

    public RequestContextBuilder(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public void buildContext(ServletRequest servletRequest) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestId = Optional.ofNullable(httpServletRequest.getParameter("requestId")).orElse("");
        String clientId = Optional.ofNullable(httpServletRequest.getParameter("clientId")).orElse("");

        requestContext.setRequestId(requestId);
        requestContext.setClientId(clientId);
    }
}
