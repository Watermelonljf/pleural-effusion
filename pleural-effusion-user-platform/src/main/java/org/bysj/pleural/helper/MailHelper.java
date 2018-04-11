package org.bysj.pleural.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * <pre>类名: MailHelper</pre>
 * <pre>描述: 邮件帮助类</pre>
 * <pre>日期: 2018/3/30  11:12</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
public class MailHelper{

        @Value( "${email.username}")
        private String mailUsername;

        @Value( "${email.pass}" )
        private String mailPass;

        @Value("${email.from.address}")
        private String formAddress;

        public void sendMail(String to,String code) throws Exception{
            // 1.创建连接对象
            Properties properties = new Properties();
            properties.setProperty("mail.host", "smtp.163.com");
            properties.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailUsername, mailPass);
                }
            });
            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(formAddress));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //主题
            message.setSubject("来自pleural-effusion系统的激活邮件");
            //正文
            message.setContent("<h1>来自pleural-effusion的激活邮件，点击链接激活账号：</h1><h3><a href='http://localhost:9094/user/active?code="+code+"'>http://localhost:9094/user/active?code="+code+"</a></h3>", "text/html;charset=utf-8");
            // 3.发送激活邮件
            Transport.send(message);
        }
}
