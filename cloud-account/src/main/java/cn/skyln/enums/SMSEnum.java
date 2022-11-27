package cn.skyln.enums;

import lombok.Getter;

/**
 * @author lamella
 * @since 2022/11/27/0:01
 */
public enum SMSEnum {

    /**
     * 短信通用验证码模板
     */
    SMS_UNIVERSAL_VERIFICATION_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "908e94ccf08b4476ba6c876d13f084ad"),
    /**
     * 注册短信验证码模板
     */
    SMS_REGISTRATION_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "a09602b817fd47e59e7c6e603d3f088d"),
    /**
     * 修改密码短信验证码模板
     */
    SMS_CHANGE_PWD_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "29833afb9ae94f21a3f66af908d54627"),
    /**
     * 身份验证短信验证码模板
     */
    SMS_AUTHENTICATION_CODE_TEMPLATE_ID("**code**:%s", "d6d95d8fb03c4246b944abcc1ea7efd8"),
    /**
     * 登录确认短信验证码模板
     */
    SMS_LOGIN_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "02551a4313154fe4805794ca069d70bf"),
    /**
     * 登录异常短信验证码模板
     */
    SMS_LOGIN_ERROR_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "81e8a442ea904694a37d2cec6ea6f2bc"),
    /**
     * 信息变更短信验证码模板
     */
    SMS_CHANGE_INFO_CODE_TEMPLATE_ID("**code**:%s,**minute**:%s", "ea66d14c664649a69a19a6b47ba028db");

    @Getter
    private final String templateId;

    private final String param;

    /**
     * 格式化返回的param
     * <p>
     * 当param中不存在所需的过期时间时，将只格式化进去验证码
     *
     * @param code    验证码
     * @param minutes 过期时间
     * @return 格式化返回的param
     */
    public String getParam(String code, String minutes) {
        return String.format(this.param, code, minutes);
    }

    private SMSEnum(String param, String templateId) {
        this.param = param;
        this.templateId = templateId;
    }
}
