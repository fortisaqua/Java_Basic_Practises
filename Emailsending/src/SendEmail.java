import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.security.GeneralSecurityException;
import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail {
    public static void main(String[] args) throws GeneralSecurityException {
//        receiver's email address
        String to = "15960252056@163.com";

//        sender's email address
        String from = "1336250263@qq.com";

//        sender's host
        String host = "smtp.qq.com";

//        get system property
        Properties properties = System.getProperties();

//        set mail server
        properties.setProperty("mail.smtp.host",host);
        properties.put("mail.smtp.auth", "true");

//        set SSL security 要从发送方所在主机获取授权码
        MailSSLSocketFactory sf = new MailSSLSocketFactory("");
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
//        get default session object
        Session session = Session.getDefaultInstance(properties,new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1336250263@qq.com", "whx@dmc#626890"); //发件人邮件用户名、密码
            }
        });

        try{
//            create default MimeMessage object
            MimeMessage message = new MimeMessage(session);

//            Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

//            Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

//            Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

//            create message body
            BodyPart messageBodyPart = new MimeBodyPart();

            // set text message
            messageBodyPart.setText("This is message body");

            // create multi-part message
            Multipart multipart = new MimeMultipart();

            // set message part
            multipart.addBodyPart(messageBodyPart);

            // attachment part
            messageBodyPart = new MimeBodyPart();
            String filename = "test.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            message.setContent(multipart );

            //   发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex){
            mex.printStackTrace();
        }
    }
}
