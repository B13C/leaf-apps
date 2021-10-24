package cn.gaple.order.controller;

import cn.gaple.order.dto.UserReqBusinessDto;
import cn.gaple.order.dto.protocol.req.UserReqProtocol;
import cn.gaple.order.dto.protocol.res.OrderResProtocol;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import cn.gaple.order.dto.res.GoodsResDto;
import cn.gaple.order.dto.res.OrderResDto;
import cn.gaple.order.entity.UserDto;
import cn.gaple.order.entity.UserEntity;
import cn.gaple.order.mapstruct.OrderMapStruct;
import cn.gaple.order.mapstruct.UserProtocolBusinessDtoMapStruct;
import cn.gaple.order.repository.primary.UserRepository;
import cn.gaple.order.service.UserService;
import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geoxus.core.framework.annotation.GXRequestBody;
import com.geoxus.core.framework.util.GXResultUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/index/frontend/")
public class IndexController {
    @Resource
    private UserService userService;

    @Resource
    private OrderMapStruct orderMapStruct;

    @Resource
    private MongoTemplate primaryMongoTemplate;

    @Resource
    private MongoTemplate secondaryMongoTemplate;

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserProtocolBusinessDtoMapStruct protocolConvertUserReqBusinessDto;

    @GetMapping("index")
    public GXResultUtil<Dict> index() {
        return GXResultUtil.ok("APP , Hello World");
    }

    @PostMapping("hello")
    public GXResultUtil<Dict> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        UserReqBusinessDto userReqBusinessDto = protocolConvertUserReqBusinessDto.sourceToTarget(userReqProtocol);
        System.out.println(userReqBusinessDto);
        userService.createOrUpdate(userReqProtocol);
        return GXResultUtil.ok("Hello World");
    }

    @GetMapping("get-user-info")
    public GXResultUtil<String> getUserInfo(Long userId) {
        userService.getUserInfo(1L);
        return GXResultUtil.ok("sadasd");
    }

    @GetMapping("/abc")
    public GXResultUtil<List<UserDto>> getInfoFromMongoDB() {
        List<UserDto> vvv = userRepository.getListByUsername("vvv");
        return GXResultUtil.ok(vvv);
    }

    @PostMapping("list-or-search")
    public GXResultUtil<GXPaginationProtocol<UserResProtocol>> listOrSearch(@RequestBody GXBaseSearchReqProtocol searchReqProtocol) {
        IPage<UserResProtocol> riPage = userService.listOrSearchPage(searchReqProtocol);
        GXPaginationProtocol<UserResProtocol> pagination = new GXPaginationProtocol<>(riPage.getRecords(), riPage.getTotal(), riPage.getSize(), riPage.getCurrent());
        return GXResultUtil.ok(pagination);
    }

    @GetMapping("test")
    public GXResultUtil<List<OrderResProtocol>> test() {
        GoodsResDto g1 = GoodsResDto.builder().goodsPrice("19.9").goodsName("香皂").build();
        GoodsResDto g2 = GoodsResDto.builder().goodsPrice("29.9").goodsName("肥皂").build();
        OrderResDto orderResDto1 = OrderResDto.builder()
                .orderSn("10")
                .totalPrice("109.9")
                .goodsResDtoList(Arrays.asList(g1, g2)).build();
        GoodsResDto g3 = GoodsResDto.builder().goodsPrice("39.9").goodsName("沐浴露").build();
        GoodsResDto g4 = GoodsResDto.builder().goodsPrice("49.9").goodsName("电脑").build();
        OrderResDto orderResDto2 = OrderResDto.builder()
                .orderSn("100")
                .totalPrice("1009.9")
                .goodsResDtoList(Arrays.asList(g3, g4)).build();
        List<OrderResProtocol> orderResProtocols = orderMapStruct.dtoListToProtocolList(Arrays.asList(orderResDto1, orderResDto2));
        return GXResultUtil.ok(orderResProtocols);
    }

    @GetMapping("update-user-status")
    public GXResultUtil<String> updateUserStatus() {
        boolean b = userService.updateFieldByCondition(UserEntity.class, Dict.create().set("status", 1990), Dict.create().set("id", 1).set("username", "jack"));
        if (b) {
            return GXResultUtil.ok("success");
        }
        return GXResultUtil.ok("fail");
    }
}
