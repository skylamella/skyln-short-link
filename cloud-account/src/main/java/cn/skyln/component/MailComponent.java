package cn.skyln.component;

/**
 * @author lamella
 * @since 2022/11/27/20:20
 */
public interface MailComponent {

    /**
     * 发送一封右键
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param content 邮件正文
     */
    void sendSimpleMail(String to, String subject, String content);
}
