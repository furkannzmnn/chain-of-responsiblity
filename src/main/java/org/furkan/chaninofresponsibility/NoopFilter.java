package org.furkan.chaninofresponsibility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class NoopFilter  implements CustomFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Noop filter");
    }

    @Override
    public void setNext(CustomFilter step) {

    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
