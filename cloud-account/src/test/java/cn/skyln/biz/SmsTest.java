package cn.skyln.biz;

import cn.hutool.core.util.RandomUtil;
import cn.skyln.AccountApplication;
import cn.skyln.component.SMSComponent;
import cn.skyln.enums.SMSEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lamella
 * @since 2022/11/27/20:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@Slf4j
public class SmsTest {
    @Autowired
    private SMSComponent smsComponent;

    @Test
    public void sentSmsTest() {
        String code = RandomUtil.randomNumbers(6);
        smsComponent.sendSMSCode(SMSEnum.REGISTRATION, "13145216441", code);
        System.out.println(code);
    }
}
