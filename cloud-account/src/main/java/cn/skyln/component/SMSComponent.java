package cn.skyln.component;

import cn.skyln.enums.SMSEnum;

/**
 * @author lamella
 * @since 2022/11/27/20:20
 */
public interface SMSComponent {
    void sendSMSCode(SMSEnum smsEnum, String mobile, String SMSCode);
}
