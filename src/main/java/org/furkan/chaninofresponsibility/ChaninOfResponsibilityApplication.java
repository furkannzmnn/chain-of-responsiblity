package org.furkan.chaninofresponsibility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
public class ChaninOfResponsibilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaninOfResponsibilityApplication.class, args);
    }

}

@RestController
@RequestMapping("/api")
class Controller {

    private final FilterProvider filterProvider;

    public Controller(FilterProvider filterProvider) {
        this.filterProvider = filterProvider;
    }

    @PostMapping("/test")
    public void handleRequest(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        filterProvider.doFilter(servletRequest, servletResponse, null);
    }
}
