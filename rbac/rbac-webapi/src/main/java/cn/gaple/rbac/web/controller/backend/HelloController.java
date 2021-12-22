package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.service.GXAdminService;
import cn.gaple.rbac.web.dto.protocol.TestProtocol;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.constant.GXBuilderConstant;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.util.GXAuthCodeUtils;
import cn.maple.core.framework.util.GXResultUtils;
import com.google.common.collect.HashBasedTable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 管理员管理
 */
@RestController
@RequestMapping("/hello/backend")
public class HelloController implements GXBaseController {
    @Resource
    private GXAdminMapper adminMapper;

    @Resource
    private GXAdminService adminService;

    @Resource
    private CaffeineCacheManager caffeineCacheManager;

    @PostMapping("test")
    public GXResultUtils<String> test(@GXRequestBody TestProtocol req) {
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("id", GXBuilderConstant.EQ, 1);
        GXBaseQueryParamInnerDto paramInnerDto = GXBaseQueryParamInnerDto.builder().tableName("s_admin").condition(condition).build();
        GXAdminResDto adminResDto = adminService.findOneByCondition(paramInnerDto);

        return GXResultUtils.ok("Hello : " + "World : " + adminResDto);
    }

    @PostMapping("encrypt-connect")
    public GXResultUtils<String> encryptConnectStr(String str, String key) {
        String s = GXAuthCodeUtils.authCodeEncode(str, key);
        return GXResultUtils.ok(s);
    }

    @PostMapping("decrypt-connect")
    public GXResultUtils<String> decryptConnectStr(String str, String key) {
        String s = GXAuthCodeUtils.authCodeDecode(str, key);

        return GXResultUtils.ok(s);
    }
}
