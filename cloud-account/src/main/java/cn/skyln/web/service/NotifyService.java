package cn.skyln.web.service;

import cn.skyln.web.model.REQ.SendSmsREQ;

/**
 * @author lamella
 * @since 2022/11/27/21:01
 */
public interface NotifyService {

    void sendSms(SendSmsREQ sendSmsREQ);

    boolean checkSmsCode(String mobile,String smsCode);
}
