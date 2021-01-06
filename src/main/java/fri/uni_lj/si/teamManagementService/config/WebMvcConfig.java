package fri.uni_lj.si.teamManagementService.config;


import fri.uni_lj.si.teamManagementService.interceptors.TeamManagementInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableRetry
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    TeamManagementInterceptor teamManagementInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(teamManagementInterceptor).addPathPatterns("/**");
    }
}