package cn.skyln.web.service.impl;

import cn.skyln.component.SMSComponent;
import cn.skyln.web.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lamella
 * @since 2022/11/27/21:01
 */
@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private SMSComponent smsComponent;

    @Override
    public void sendSms(String mobile, String type) {

    }
}
