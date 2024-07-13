package org.furkan.chaninofresponsibility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Component
public class FilterProvider {

    private final List<CustomFilter> filters;

    public FilterProvider(List<CustomFilter> filters) {
        this.filters = filters;
        this.filters.sort(Comparator.comparingInt(CustomFilter::getOrder));
        for (int i = 0; i < filters.size() - 1; i++) {
            filters.get(i).setNextFilter(filters.get(i + 1));
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filters.get(0).doFilter(servletRequest, servletResponse, filterChain);
    }
}
