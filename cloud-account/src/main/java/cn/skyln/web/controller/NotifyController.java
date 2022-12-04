package cn.skyln.web.controller;

import cn.skyln.util.JsonData;
import cn.skyln.web.model.REQ.SendSmsREQ;
import cn.skyln.web.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("send_sms")
    public JsonData sendSms(@RequestBody SendSmsREQ sendSmsREQ) {
        notifyService.sendSms(sendSmsREQ);
        return JsonData.buildSuccess();
    }
}
