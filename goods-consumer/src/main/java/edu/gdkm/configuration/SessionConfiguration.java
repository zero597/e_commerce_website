package edu.gdkm.configuration;

import edu.gdkm.filter.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ClassName: SessionConfiguration
 * Package: edu.gdkm.configuration
 * Description:
 *
 * @Author 林
 * @Create 2023/6/20 14:19
 * @Version 1.0
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {


    /**
     * 将拦截器添加到springboot中
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("/goods/cart");
    }
}
