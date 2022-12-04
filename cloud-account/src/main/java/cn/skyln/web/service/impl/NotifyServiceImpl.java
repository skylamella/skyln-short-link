package cn.skyln.web.service.impl;

import cn.skyln.component.SMSComponent;
import cn.skyln.constant.CacheKey;
import cn.skyln.enums.BizCodeEnum;
import cn.skyln.enums.SMSEnum;
import cn.skyln.exception.BizException;
import cn.skyln.util.CheckUtil;
import cn.skyln.util.CommonUtils;
import cn.skyln.web.model.REQ.SendSmsREQ;
import cn.skyln.web.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static cn.skyln.constant.TimeConstant.CAPTCHA_CODE_EXPIRED;

/**
 * @author lamella
 * @since 2022/11/27/21:01
 */
@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private SMSComponent smsComponent;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    @Async("threadPoolTaskExecutor")
    public void sendSms(SendSmsREQ sendSmsREQ) {
        String code = CommonUtils.getRandomSMSCode();
        String mobile = sendSmsREQ.getMobile();
        if (!CheckUtil.isPhone(mobile)) {
            throw new BizException(BizCodeEnum.CODE_TO_ERROR);
        }
        String key = String.format(CacheKey.CHECK_CODE_KEY, mobile, code);
        SMSEnum smsEnum = SMSEnum.getSMSEnumByName(sendSmsREQ.getType());
        if (Objects.isNull(smsEnum)) {
            throw new BizException(BizCodeEnum.CODE_SMS_TYPE_ERROR);
        }
        String value = code + "_" + CommonUtils.getCurrentTimeStamp();
        redisTemplate.opsForValue().set(key, value, CAPTCHA_CODE_EXPIRED, TimeUnit.MINUTES);
        smsComponent.sendSMSCode(smsEnum, mobile, code);
    }

    @Override
    public boolean checkSmsCode(String mobile, String smsCode) {
        String key = String.format(CacheKey.CHECK_CODE_KEY, mobile, smsCode);
        String cacheValue = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(cacheValue)) {
            return StringUtils.equals(cacheValue.split("_")[0], smsCode);
        }
        return false;
    }
}
