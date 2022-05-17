package cn.gaple.extra.feature.entities;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("media_library")
@EqualsAndHashCode(callSuper = false)
public class GXMediaLibraryModel extends GXMyBatisModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private String modelType;

    private long coreModelId;

    private long targetId;

    private String collectionName;

    private String name;

    private String fileName;

    private String mimeType;

    @TableField(select = false)
    private String disk;

    private long size;

    private String manipulations = "[]";

    private String customProperties = "{}";

    private String responsiveImages = "{}";

    private int orderColumn;

    private String resourceType = "";

    private String ossUrl;

    @TableField(exist = false)
    private String filePath = "";
}
