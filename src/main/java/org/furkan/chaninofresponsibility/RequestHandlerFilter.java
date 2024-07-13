package org.furkan.chaninofresponsibility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestHandlerFilter implements CustomFilter {

    private CustomFilter nextFilter;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Handling request");
        System.out.println("Handling response");

        if (nextFilter != null) {
            nextFilter.doFilter(servletRequest, servletResponse, filterChain);
        }

    }

    @Override
    public void setNextFilter(CustomFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
