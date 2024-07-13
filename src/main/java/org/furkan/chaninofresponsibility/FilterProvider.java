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

    private final CustomFilter customFilter;

    public FilterProvider(List<CustomFilter> filters) {
        filters.sort(Comparator.comparingInt(CustomFilter::getOrder));
        this.customFilter = Element.buildChain(filters, new NoopFilter());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        customFilter.doFilter(servletRequest, servletResponse, filterChain);
    }
}
