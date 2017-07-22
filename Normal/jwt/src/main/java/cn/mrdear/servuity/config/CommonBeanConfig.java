package cn.mrdear.servuity.config;

import cn.mrdear.servuity.util.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一些线程安全的工具类
 *
 * @author Niu Li
 * @since 2017/6/28
 */
@Configuration
public class CommonBeanConfig {

    /**
     * 配置jwt token
     */
    @Bean
    public JwtTokenUtil configToken() {
        return new JwtTokenUtil();
    }
}
