package cn.gaple.extra.feature.services;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.util.GXResultUtils;

public interface GXSendSMSService {
    /**
     * 发送短信验证码
     *
     * @param phone        用户手机号码
     * @param templateName 短信模板名字
     * @return ResultUtil
     */
    GXResultUtils<String> send(String phone, String templateName, Dict param);

    /**
     * 验证验证码
     *
     * @param phone 用户手机号码
     * @param code  验证码
     * @return boolean
     */
    boolean verification(String phone, String code);
}
