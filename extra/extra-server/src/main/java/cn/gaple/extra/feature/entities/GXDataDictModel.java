package cn.gaple.extra.feature.entities;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("data_dict")
@EqualsAndHashCode(callSuper = false)
public class GXDataDictModel extends GXMyBatisModel {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 具体值
     */
    private String value;

    /**
     * 显示的label
     */
    private String label;

    /**
     * 所属类型
     */
    private String type;
}
