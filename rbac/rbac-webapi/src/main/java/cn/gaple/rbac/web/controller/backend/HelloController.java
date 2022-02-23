package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.model.ETestModel;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.repository.MTestRepository;
import cn.gaple.rbac.service.GXAdminService;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminReqProtocol;
import cn.gaple.rbac.web.mapstruct.PersonMapstruct;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.IdUtil;
import cn.maple.core.datasource.config.GXDynamicDataSource;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.util.GXAuthCodeUtils;
import cn.maple.core.framework.util.GXCommonUtils;
import cn.maple.core.framework.util.GXResultUtils;
import cn.maple.core.framework.util.GXTypeOfUtils;
import com.google.common.collect.HashBasedTable;
import com.mysql.cj.xdevapi.*;
import com.redis.lettucemod.api.StatefulRedisModulesConnection;
import com.redis.lettucemod.api.sync.RediSearchCommands;
import com.redis.lettucemod.search.Document;
import com.redis.lettucemod.search.SearchOptions;
import com.redis.lettucemod.search.SearchResults;
import lombok.extern.slf4j.Slf4j;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * 管理员管理
 */
@RestController
@RequestMapping("/hello/backend")
@Slf4j
public class HelloController implements GXBaseController {
    @Resource
    private GXAdminMapper adminMapper;

    @Resource
    private GXAdminService adminService;

    @Resource
    private CaffeineCacheManager caffeineCacheManager;

    @Resource
    private RedissonSpringCacheManager redissonSpringCacheManager;

    @Resource
    private PersonMapstruct personMapstruct;

    @Resource
    private MTestRepository testRepository;

    @Resource
    private GXAdminRepository adminRepository;

    @Resource
    private GXDynamicDataSource druidDataSource;

    @Resource
    private StatefulRedisModulesConnection<String, String> redisModulesConnection;

    public static void main(String[] args) {
        Object a = "";
        Object b = 0;
        int c = 0;
        Object d = m();
        System.out.println(GXTypeOfUtils.typeof(a) + " : " + GXCommonUtils.getClassDefaultValue(GXTypeOfUtils.typeof(a)));
        System.out.println(GXTypeOfUtils.typeof(b) + " : " + GXCommonUtils.getClassDefaultValue(GXTypeOfUtils.typeof(b)));
        System.out.println(GXTypeOfUtils.typeof(c) + " : " + GXCommonUtils.getClassDefaultValue(GXTypeOfUtils.typeof(c)));
        System.out.println(Objects.equals("", GXCommonUtils.getClassDefaultValue(GXTypeOfUtils.typeof(a))));
    }

    public static Object m() {
        return null;
    }

    @PostMapping("test")
    public GXResultUtils<String> test(@GXRequestBody GXAdminReqProtocol req) {
        CopyOptions copyOptions = new CopyOptions();
        GXAdminResDto adminResDto = convertSourceToTarget(req, GXAdminResDto.class);
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

    @PostMapping("snow-flake")
    public GXResultUtils<String> snowflake() {
        String s = IdUtil.getSnowflake().nextIdStr();
        return GXResultUtils.ok(s);
    }

    @PostMapping("set-redis-value")
    public GXResultUtils<String> setRedisValue(@GXRequestBody Dict dict) throws IOException {
        // *3\r\n$3\r\nset\r\n$8\r\nusername\r\n$9\r\nbritton01\r\n
        Socket client = null;
        client = new Socket("192.168.1.245", 16379);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
        String property = "\\r\\n";
        ArrayList<String> strings = CollUtil.newArrayList("*3", "$3", "set", "$6", "userAA", "$5", "AAAAA");
        String collect = String.join(property, strings) + property;
        // pw.print("*3\\r\\n$3\\r\\nset\\r\\n$8\\r\\nusernaAA\\r\\n$9\\r\\nbritton01\\r\\n");
        pw.println(collect);
        return GXResultUtils.ok("hello");
    }

    @GetMapping("/test-mongo")
    public GXResultUtils<String> testMongo() {
        ETestModel eTestModel = new ETestModel();
        eTestModel.setId("MMMMMMM");
        eTestModel.setPlanUrl("KKKKKKKKK");
        String s = testRepository.create(eTestModel);
        return GXResultUtils.ok(eTestModel.getId());
    }

    @GetMapping("test1")
    public GXResultUtils<List<DbDoc>> test1() throws Throwable {
        ClientFactory xClientFactory = new ClientFactory();
        Properties properties = new Properties();
        Client client = xClientFactory.getClient("mysqlx://britton:britton@192.168.56.101:33060/world_x", properties);
        Schema schema = client.getSession().getSchema("world_x");
        Collection flags = schema.getCollection("flags");
        FindStatement findStatement = flags.find("city='资中' and $.detail[*].a='BB'");
        DocResult execute = findStatement.execute();
        ArrayList<DbDoc> arrayList = new ArrayList<>();
        execute.forEachRemaining(one -> arrayList.add(one));
        /*Session session = new SessionFactory().getSession("mysqlx://192.168.56.101:33060/world_x?user=britton&password=britton");
        Schema db = session.getSchema("world_x");
        Collection flags = db.getCollection("flags");
        DbDoc one = flags.getOne("10001");*/
        return GXResultUtils.ok(arrayList);
    }

    @GetMapping("test-redis-module")
    public GXResultUtils<List<Document<String, String>>> testRediSearch(String keyWord) {
       /* RedisJSONCommands<String, String> jsonCommands = redisModulesConnection.sync();
        Dict data = Dict.create().set("user", Dict.create().set("id", "3").set("name", "britton002").set("country", "AAAABB").set("material", "绒布").set("url", "383").set("body", "四川-成都"));
        jsonCommands.jsonSet("doc:arr03", ".", JSONUtil.toJsonStr(data));
        //jsonCommands.jsonDel("doc:arr04");*/

        RediSearchCommands<String, String> search = redisModulesConnection.sync();
        /*CreateOptions<String, String> doc = CreateOptions.<String, String>builder()
                .prefixes("1", "doc:")
                .on(CreateOptions.DataType.JSON)
                .build();
        search.create("userIdx", doc,
                Field.text("$.user.material").as("material").build(),
                Field.text("$.user.name").as("name").build(),
                Field.text("$.user.country").as("country").build());*/
        // search.alter("userIdx", Field.text("$.user.id").as("id").build());
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();

        List<Object> userIdx = search.indexInfo("userIdx");
        System.out.println(userIdx);
        SearchOptions<String, String> searchOptions = SearchOptions.<String, String>builder().returnFields("name", "country", "material", "id")
                .build();
        SearchResults<String, String> documents = search.search("userIdx", "@name:britton* @material:布艺", searchOptions);
        List<Document<String, String>> collect = new ArrayList<>(documents);
        return GXResultUtils.ok(collect);
    }
}
