package dummy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dummy.filters.ErrorFilter;
import dummy.filters.PostFilter;
import dummy.filters.PreFilter;
import dummy.filters.RouteFilter;

@Configuration
public class ZuulConfiguration {
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
