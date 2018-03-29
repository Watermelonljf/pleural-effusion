package org.bysj.pleural.service;

/**
 * <pre>类名: CaptchaService</pre>
 * <pre>描述: 验证码服务</pre>
 * <pre>日期: 2018/3/29  14:40</pre>
 * <pre>作者: ljianf</pre>
 */
public interface CaptchaService {

    String createCaptchaToken(String text);

    boolean checkCaptcha(String uuid,String text);
}
