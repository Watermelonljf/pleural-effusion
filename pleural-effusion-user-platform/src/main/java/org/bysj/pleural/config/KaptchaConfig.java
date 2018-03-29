package org.bysj.pleural.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * <pre>类名: KaptchaConfig</pre>
 * <pre>描述: 验证码配置</pre>
 * <pre>日期: 2018/3/29  14:29</pre>
 * <pre>作者: ljianf</pre>
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "10");
        properties.put("kaptcha.textproducer.char.length","6");
        properties.put("kaptcha.image.height","58");
        properties.put("kaptcha.textproducer.font.size","28");
        properties.put("kaptcha.background.clear.from","gray");
        properties.put("kaptcha.background.clear.to","white");

        properties.put("kaptcha.noise.color","black");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

