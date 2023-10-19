package com.canal.basic.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Value("${cors.allow.origin}")
    private String allowOrigin;

    @Value("${cors.allow.credentials}")
    private Boolean credentials;

    @Value("${cors.allow.header}")
    private String allowHeader;

    @Value("${cors.allow.method}")
    private String allowMethod;

    @Value("${cors.register.pattern}")
    private String registerPattern;

    @Autowired
    private CorsConfiguration corsConfiguration;

    @Autowired
    private UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource;

    @Bean
    public CorsConfiguration corsConfiguration() {
        return new CorsConfiguration();
    }

    @Bean
    public UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
        return new UrlBasedCorsConfigurationSource();
    }

    @Bean
    public CorsFilter corsFilter() {
        //允许所有域名进行跨域调用
        corsConfiguration.addAllowedOrigin(allowOrigin);
        //允许跨越发送cookie
        corsConfiguration.setAllowCredentials(credentials);
        //放行全部原始头信息
        corsConfiguration.addAllowedHeader(allowHeader);
        //允许所有请求方法跨域调用
        corsConfiguration.addAllowedMethod(allowMethod);
        urlBasedCorsConfigurationSource.registerCorsConfiguration(registerPattern, corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
