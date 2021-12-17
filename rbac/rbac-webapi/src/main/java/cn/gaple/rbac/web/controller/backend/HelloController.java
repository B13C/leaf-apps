package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.web.dto.protocol.TestProtocol;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.constant.GXBuilderConstant;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.util.GXResultUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
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
    private GXAdminRepository adminRepository;

    @PostMapping("test")
    public GXResultUtils<String> test(@GXRequestBody TestProtocol req) {
        HashBasedTable<String, String, Table<String, String, Dict>> joins = HashBasedTable.create();
        HashBasedTable<String, String, Dict> addrOnWhere = HashBasedTable.create();
        addrOnWhere.put("addr", "admin", Dict.create().set("admin_id", "id"));
        HashBasedTable<String, String, Dict> profileOnWhere = HashBasedTable.create();
        profileOnWhere.put("profile", "admin", Dict.create().set("admin_id", "id"));
        joins.put("left", "address", addrOnWhere);
        joins.put("right", "profile", profileOnWhere);
        //joins.put("inner" , )
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("admin.id", GXBuilderConstant.STR_EQ, 11111);// on addr.id = admin.admin_id and addr.aaa = admin.bbb
//        condition.put("addr.name" , GXBuilderConstant.LEFT_LIKE , );
        GXBaseQueryParamInnerDto paramInnerDto = GXBaseQueryParamInnerDto.builder().tableName("s_admin").tableNameAlias("admin").joins(joins).condition(condition).build();

        adminRepository.findByCondition(paramInnerDto);
/*        HashBasedTable<String, String, Object> objectObjectObjectHashBasedTable = HashBasedTable.create();
        objectObjectObjectHashBasedTable.put("username , '-' , nickname", GXBuilderConstant.RIGHT_LIKE, "77777");
        objectObjectObjectHashBasedTable.put("username ,'-' , real_name", GXBuilderConstant.RIGHT_LIKE, "99999");
        condition.put(GXBuilderConstant.T_FUNC_MARK, "concat", objectObjectObjectHashBasedTable); // where concat(username , '-' , nickname) like '77777%' and concat(username , '-' , real_name) like '99999%'


        condition.put(GXBuilderConstant.T_FUNC_MARK, "JSON_OVERLAPS",
                CollUtil.newHashSet("items->'$.zipcode', CAST('[94536]' AS JSON)", "items->'$.zipcode1', CAST('[94537]' AS JSON)"));*/
        /*
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("nickname", GXBuilderConstant.RIGHT_LIKE, "aaaa");
        condition.put("created_at", GXBuilderConstant.GE, DateUtil.currentSeconds() - 86400);
        condition.put("created_at", GXBuilderConstant.LT, DateUtil.currentSeconds());
        condition.put("username", GXBuilderConstant.STR_IN, CollUtil.newHashSet("aa", "bbbb"));
        condition.put("id", GXBuilderConstant.IN, CollUtil.newHashSet(1, 2));
        condition.put("email", GXBuilderConstant.STR_EQ, "aaaa");
        condition.put("status", GXBuilderConstant.EQ, 12);
        condition.put("email", GXBuilderConstant.STR_NOT_EQ, "nbbbb");
        condition.put("status", GXBuilderConstant.NOT_EQ, 111);
        HashBasedTable<String, String, Object> multiColumn = HashBasedTable.create();
        multiColumn.put("username , '-' , nickname", GXBuilderConstant.RIGHT_LIKE, "77777");
        multiColumn.put("username ,'-' , real_name", GXBuilderConstant.RIGHT_LIKE, "99999");
        condition.put("T_FUNC", "concat", multiColumn);
        condition.put("T_FUNC", "JSON_OVERLAPS", "items->'$.zipcode', CAST('[94536]' AS JSON)");
        condition.put("T_FUNC", "JSON_OVERLAPS", CollUtil.newHashSet("items->'$.zipcode', CAST('[94536]' AS JSON)", "items->'$.zipcode1', CAST('[94537]' AS JSON)"));
        List<Dict> dictList = adminRepository.findByCondition("s_admin", condition, CollUtil.newHashSet("*"), Dict.class);*/
        String[] names = {""};
        return GXResultUtils.ok("Hello : " + "World");
    }
}
