package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.web.dto.protocol.TestProtocol;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.constant.GXBuilderConstant;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.util.GXResultUtils;
import com.google.common.collect.HashBasedTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 管理员管理
 */
@RestController
@RequestMapping("/hello/backend")
public class HelloController implements GXBaseController {
    @Resource
    private GXAdminMapper adminMapper;

    @Resource
    private GXAdminRepository adminRepository;

    @PostMapping("test")
    public GXResultUtils<String> test(@GXRequestBody TestProtocol req) {
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("id", GXBuilderConstant.NUMBER_EQ, 1);
        condition.put(GXBuilderConstant.DELETED_FLAG_FIELD_NAME, GXBuilderConstant.EXCLUSION_DELETED_CONDITION_FLAG, "");
        HashBasedTable<String, String, Object> condition1 = HashBasedTable.create();
        condition1.put("id", GXBuilderConstant.NUMBER_EQ, 1);
        List<Dict> data = adminRepository.findByCondition("s_admin", condition1, CollUtil.newHashSet("nickname", "username"), Dict.class);
        List<String> nickname = adminRepository.findByCondition("s_admin", condition, CollUtil.newHashSet("nickname"), String.class);
        return GXResultUtils.ok("Hello : " + nickname);
    }
}
