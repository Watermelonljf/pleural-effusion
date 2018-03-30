package org.bysj.pleural.service.impl;

import org.bysj.pleural.exception.BusinessException;
import org.bysj.pleural.helper.RedisHelp;
import org.bysj.pleural.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <pre>类名: CaptchaServiceImpl</pre>
 * <pre>描述: 验证马服务实现</pre>
 * <pre>日期: 2018/3/29  14:42</pre>
 * <pre>作者: ljianf</pre>
 */
@Service
public class CaptchaServiceImpl implements CaptchaService{

    private static final Long CAPTCHA_EXPIRE = 60l;

    @Autowired
    private RedisHelp redisHelp;



    /**
     * @Description: 生成UUID
     * @date   2018/3/29 14:44
     * @param
     * @return
     * @author ljianf
     */
    @Override
    public String createCaptchaToken(String text) {
        UUID uuid = UUID.randomUUID();
        redisHelp.cacheValue(uuid.toString(),text,CAPTCHA_EXPIRE);
        return uuid.toString();
    }


    @Override
    public boolean checkCaptcha(String uuid,String text) {
        if(!redisHelp.containsKey(uuid)){
            throw new BusinessException("验证码过期，请刷新！");
        }
        String code = (String)redisHelp.getValue(uuid);
        if(!code.equals(text)) {
            throw new BusinessException("验证码输入错误！");
        }
        return true;
    }
}
