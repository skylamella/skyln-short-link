package cn.skyln.web.controller;

import cn.skyln.util.JsonData;
import cn.skyln.web.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lamella
 * @since 2022/11/27/21:01
 */
@RestController
@RequestMapping("/api/v1/notify")
@Slf4j
public class NotifyController {

    @Autowired
    private NotifyService notifyService;

    @RequestMapping("send_sms/{type}/{mobile}")
    public JsonData sendSms(@PathVariable String mobile, @PathVariable String type) {
        notifyService.sendSms(mobile, type);
        return JsonData.buildSuccess();
    }
}
