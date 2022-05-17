package cn.gaple.extra.feature.services;

import cn.gaple.extra.feature.entities.GXMediaLibraryModel;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface GXMediaLibraryService {
    /**
     * 保存数据
     *
     * @param dict 参数
     * @return int
     */
    int save(Dict dict);

    /**
     * 更新条目所关联的模块ID
     * <pre>
     * {@code
     *      List<JSONObject> param = new ArrayList<>();
     *      Dict data1 = Dict.create()
     *      .set("id", 22)
     *      .set("core_model_id", 8)
     *      .set("custom_properties", Dict.create()
     *      .set("name", "tom")
     *      .set("age", 12));
     *      Dict data2 = Dict.create()
     *      .set("id", 24)
     *      .set("core_model_id", 8)
     *      .set("resource_type", "AABB")
     *      .set("update_old", 1)
     *      .set("custom_properties", Dict.create()
     *      .set("name", "tom")
     *      .set("age", 12));
     *     param.add(JSONUtil.parseObj(data2));
     *     param.add(JSONUtil.parseObj(data1));
     *     updateOldFile(12, 10, param, Dict.create().set("resource_type", "A"));
     *  }
     * </pre>
     *
     * @param targetId    对象记录ID
     * @param coreModelId 　核心模型ID
     * @param param       　参数
     * @param condition   条件
     */
    void updateOwner(long targetId, long coreModelId, List<JSONObject> param, Dict condition);

    /**
     * 保存文件
     *
     * @param file  文件
     * @param param 参数
     * @return GXCoreMediaLibraryEntity
     */
    GXMediaLibraryModel saveFileInfo(MultipartFile file, Dict param);

    /**
     * 通过条件删除media
     *
     * @param param 参数
     * @return boolean
     */
    boolean deleteByCondition(Dict param);

    /**
     * 通过条件获取资源文件
     *
     * @param param 参数
     * @return List
     */
    List<Dict> getMediaByCondition(Dict param);

    /**
     * 更新旧的资源
     *
     * <pre>
     * {@code
     *      List<JSONObject> objectList = new ArrayList<>();
     *      Dict data1 = Dict.create()
     *      .set("id", 22)
     *      .set("core_model_id", 8)
     *      .set("custom_properties", Dict.create()
     *      .set("name", "tom")
     *      .set("age", 12));
     *      Dict data2 = Dict.create()
     *      .set("id", 24)
     *      .set("core_model_id", 8)
     *      .set("resource_type", "AABB")
     *      .set("update_old", 1)
     *      .set("custom_properties", Dict.create()
     *      .set("name", "tom")
     *      .set("age", 12));
     *     objectList.add(JSONUtil.parseObj(data2));
     *     objectList.add(JSONUtil.parseObj(data1));
     *     Dict condition = Dict.create().set("resource_type", "A");
     *     Dict param = Dict.create().set("data" ,objectList )
     *     .set("object_id" , 100)
     *     .set("core_model_id" , 23)
     *     .set("condition" , condition);
     *     updateOldFile(param);
     *  }
     * </pre>
     *
     * @param param 参数
     */
    void updateOldFile(Dict param);

    /**
     * 获取实体对象的媒体文件
     *
     * @param targetId    实体对象模型ID
     * @param coreModelId 实体模型ID
     * @param param       其他参数
     * @return Collection
     */
    default Collection<GXMediaLibraryModel> getMedia(int targetId, int coreModelId, Dict param) {
        return Collections.emptyList();
    }

    /**
     * 处理用户上传的资源文件
     * <p>
     * {@code
     * "media_info":[
     * {
     * "id":1,
     * "resource_type":"AAAAA",
     * "oss_url":"http://www.geoxus.io/"
     * }
     * ]
     * }
     *
     * @param target   mediaLibrary对象
     * @param targetId 目标模型ID
     * @param param    参数
     */
    default void handleMedia(GXMediaLibraryModel target, @NotNull long targetId, @NotNull Dict param) {
        return;
    }
}
