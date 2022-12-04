package cn.skyln.web.model.REQ;

import lombok.Data;

/**
 * @author lamella
 * @since 2022/12/04/20:56
 */
@Data
public class SendSmsREQ {
    private String mobile;
    private String type;
}
