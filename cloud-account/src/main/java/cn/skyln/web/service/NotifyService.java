package cn.skyln.web.service;

/**
 * @author lamella
 * @since 2022/11/27/21:01
 */
public interface NotifyService {

    void sendSms(String mobile, String type);
}
