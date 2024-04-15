package com.example.demothymeleaf.config;


import com.example.demothymeleaf.utils.HeaderUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final SpringResourceTemplateResolver templateResolver;

    public RequestInterceptor(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // Request is intercepted by this method before reaching the Controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //* Business logic just when the request is received and intercepted by this interceptor before reaching the controller
        try {
            System.out.println("Method Type: " + request.getMethod());
            System.out.println("Request URL: " + request.getRequestURI());
        }
        //* If the Exception is caught, this method will return false
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Response is intercepted by this method before reaching the client
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //* Business logic just before the response reaches the client and the request is served
        String userAgent = request.getHeader("User-Agent"); // request => HttpServletRequest (javax.servlet.http.HttpServletRequest)
        boolean isPc = HeaderUtils.isPc(userAgent);

        templateResolver.setPrefix(isPc ? "classpath:/templates/pc/" : "classpath:/templates/sp/");
        System.out.println(templateResolver.getPrefix());
    }

    // This method is called after request & response HTTP communication is done.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //* Business logic after request and response is Completed
        System.out.println("3 - afterCompletion() : After the request and Response is completed");
    }
}
