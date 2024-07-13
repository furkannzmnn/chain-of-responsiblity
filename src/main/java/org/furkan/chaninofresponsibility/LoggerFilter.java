package org.furkan.chaninofresponsibility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerFilter implements CustomFilter {

    private CustomFilter nextFilter;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Logging request");
        System.out.println("Logging response");

        if (nextFilter != null) {
            nextFilter.doFilter(servletRequest, servletResponse, filterChain);
        }
    }

   @Override
    public void setNext(CustomFilter step) {
        this.nextFilter = step;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
