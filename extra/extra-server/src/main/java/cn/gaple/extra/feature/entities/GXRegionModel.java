package cn.gaple.extra.feature.entities;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@TableName("region")
@EqualsAndHashCode(callSuper = false)
public class GXRegionModel extends GXMyBatisModel {
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
     * 父ID
     */
    private int parentId;

    /**
     * 等级
     */
    private int type;

    /**
     * 名称
     */
    private String name;

    /**
     * 拼音全称
     */
    private String pinyin;

    /**
     * 拼音首字母
     */
    private String firstLetter;

    @TableField(exist = false)
    private List<GXRegionModel> children = null;
}
