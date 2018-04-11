package org.bysj.pleural.config;

import org.aspectj.lang.annotation.Before;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className: RabbitMqConfig
 * describe: MQ配置
 * author: Watermelon_R
 * date:   2018/4/10
 */
@Configuration
public class RabbitMqConfig {



    /**
     * 训练数据队列
     * @return
     */
    @Bean
    public Queue trainDataQueue(){
        return new Queue("train_data_queue");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
}
