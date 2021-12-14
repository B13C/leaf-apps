package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.web.dto.protocol.TestProtocol;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.constant.GXBuilderConstant;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.dto.res.GXPaginationResDto;
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
    public GXResultUtils<GXPaginationResDto<GXAdminResDto>> test(@GXRequestBody TestProtocol req) {
        final Table<String, String, Object> extData = HashBasedTable.create();
        extData.put("ext", "name", "jack");
        extData.put("ext", "salary", "50000");
        extData.put("ext", "-address", "四川成都");
        Dict data = Dict.create().set("nickname", "看一哈哇").set("ext", extData);
        Table<String, String, Object> condition = HashBasedTable.create();
        //condition.put("username", GXBaseBuilderConstant.RIGHT_LIKE, "jack");
        //condition.put(GXAdminConstant.PRIMARY_KEY, GXBaseBuilderConstant.NUMBER_EQ, 22);
        // condition.put(GXAdminConstant.PRIMARY_KEY, GXBaseBuilderConstant.NUMBER_EQ, 22);
       /* condition.put("created_at", GXBaseBuilderConstant.NUMBER_GT, "222222");
        condition.put("created_at", GXBaseBuilderConstant.NUMBER_LE, "11111");*/
        //condition.put("username", GXBaseBuilderConstant.RIGHT_LIKE, "jetty");

        GXBaseQueryParamInnerDto queryInnerDto = GXBaseQueryParamInnerDto.builder().columns(CollUtil.newHashSet("*")).tableName("s_admin").columns(CollUtil.newHashSet("username")).groupByField(CollUtil.newHashSet("nickname")).orderByField(Dict.create().set("username", "asc").set("nickname", "desc")).build();
        //GXPaginationResDto<GXAdminResDto> paginate = adminRepository.paginate(queryInnerDto);
        //List<GXAdminResDto> byCondition = adminRepository.findByCondition(queryInnerDto);
        //List<Dict> singleFieldByCondition = adminRepository.findByCondition(queryInnerDto, Dict.class);
        condition.put(GXAdminConstant.PRIMARY_KEY, GXBuilderConstant.NUMBER_EQ, 11);

        //adminRepository.updateFieldByCondition("s_admin", Dict.create().set("username", "AAAA").set("nickname", "我的测试"), condition);
/*        List<Dict> dataList = CollUtil.newArrayList();
        Dict data1 = Dict.create().set("username", "ML").set("nickname", "我是批量插入的1").set("salt", "11111");
        Dict data2 = Dict.create().set("username", "QL").set("nickname", "我是批量插入的2").set("salt", "22222");
        Dict data3 = Dict.create().set("username", "PL").set("nickname", "我是批量插入的3").set("salt", "3333");
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);*/
        //Integer s_admin = adminRepository.batchInsert("s_admin", dataList);
        GXPaginationResDto<GXAdminResDto> paginate = adminRepository.paginate(1, 2, "s_admin", condition, CollUtil.newHashSet("*"));
        return GXResultUtils.ok(paginate);
    }
}
