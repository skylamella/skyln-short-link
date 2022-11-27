package cn.skyln.component.impl;

import cn.hutool.http.HttpRequest;
import cn.skyln.component.SMSComponent;
import cn.skyln.config.SMSConfig;
import cn.skyln.enums.SMSEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import cn.hutool.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static cn.skyln.constant.TimeConstant.CAPTCHA_CODE_EXPIRED;

/**
 * @author lamella
 * @since 2022/11/27/19:51
 */
@Component
@Slf4j
public class SMSComponentImpl implements SMSComponent {
    @Autowired
    private SMSConfig smsConfig;

    @Override
    public void sendSMSCode(SMSEnum smsEnum, String mobile, String SMSCode) {
        Map<String, String> querys = new HashMap<>();
        querys.put("mobile", mobile);
        querys.put("param", smsEnum.getParam(SMSCode, String.valueOf(CAPTCHA_CODE_EXPIRED)));
        querys.put("smsSignId", smsConfig.getSmsSignId());
        querys.put("templateId", smsEnum.getTemplateId());
        HttpResponse response = HttpRequest.post(buildUrl(smsConfig.getHost(), smsConfig.getPath(), querys))
                .header("Authorization", "APPCODE " + smsConfig.getAppCode())
                .execute();
        if (HttpStatus.OK.value() == response.getStatus()) log.info("发送短信成功,响应信息:{}", response.body());
        else log.error("发送短信失败,响应信息:{}", response.body());
        response.close();
    }

    private static String buildUrl(String host, String path, Map<String, String> querys) {
        StringBuilder url = new StringBuilder();
        url.append(host).append(path);
        if (Objects.nonNull(querys) && !querys.isEmpty()) {
            StringBuilder queryStr = new StringBuilder();
            querys.keySet().forEach(key -> {
                if (0 < queryStr.length()) {
                    queryStr.append("&");
                }
                queryStr.append(key).append("=").append(querys.get(key));
            });
            if (0 < queryStr.length()) {
                url.append("?").append(queryStr);
            }
        }
        return url.toString();
    }
}
