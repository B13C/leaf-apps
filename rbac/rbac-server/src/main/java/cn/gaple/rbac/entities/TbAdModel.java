package cn.gaple.rbac.entities;

import cn.maple.core.datasource.model.GXMyBatisModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbAdModel extends GXMyBatisModel {
    private Integer id;

    private String url;

    private Short status;

    private String position;

    private String ext;

    private String image;
}
