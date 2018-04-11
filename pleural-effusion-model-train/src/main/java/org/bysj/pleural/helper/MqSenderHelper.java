package org.bysj.pleural.helper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.bysj.pleural.bean.EachGenResult;
import org.bysj.pleural.builder.EachResultBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * className: MqSenderHelper
 * describe: 消息发送帮助类
 * author: Watermelon_R
 * date:   2018/4/10
 */
@Component
@Slf4j
public class MqSenderHelper {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void sendTrainResult(EachGenResult eachGenResult,Integer gen, Double acc, Double avgs){

        log.info("构建消息参数【开始】");
        EachGenResult result = EachResultBuilder.builder(eachGenResult, gen, acc, avgs);
        log.info("构建消息参数【结束】,消息对象值：{}",result.toString());

        log.info("发送消息");
        this.rabbitTemplate.convertAndSend("fanoutExchange","train_data", JSON.toJSON(result).toString());
    }

    public void sendTrainResult(){
        this.rabbitTemplate.convertAndSend("fanoutExchange","train_data", "hello"+new Date());
    }
}
