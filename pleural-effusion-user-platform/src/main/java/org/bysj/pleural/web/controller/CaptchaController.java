package org.bysj.pleural.web.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.common.collect.Maps;
import org.bysj.pleural.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * <pre>类名: CaptchaController</pre>
 * <pre>描述: 验证码图片控制器</pre>
 * <pre>版权: 税友软件集团股份有限公司</pre>
 * <pre>日期: 2018/3/29  14:31</pre>
 * <pre>作者: ljianf</pre>
 */
@RestController
@RequestMapping(value = "/captcha")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private DefaultKaptcha producer;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> captcha(HttpServletResponse response) throws ServletException, IOException {
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);

        outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", outputStream);

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        // 生成captcha的token
        Map<String, Object> map = Maps.newHashMap();
        String uuid = captchaService.createCaptchaToken(text);
        map.put("imgToken",uuid);
        map.put("img", encoder.encode(outputStream.toByteArray()));
        return map;
    }
}
