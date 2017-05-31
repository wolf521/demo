package com.example.demo.mail.manager;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by cuizhixiang on 2017/5/26.
 * JavaMail发送
 **/
@Component
public class MailManager {

    //发送邮件
    public static void sendMail(String email, String emailMsg)
            throws AddressException, MessagingException {

        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.port", "25");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout","1000");
        // 验证账号及密码，密码需要是第三方授权码
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15953185712@163.com", "czxsqm521");
            }
        };
        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        // 设置发送者
        message.setFrom(new InternetAddress("15953185712@163.com"));
        // 设置发送方式与接收者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
        // 设置主题
        message.setSubject("邮件发送测试");
        // 设置内容
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
}
