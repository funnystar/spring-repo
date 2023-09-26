package com.funny.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author funny star
 * @since 2023-09-16
 */
@TableName("x_menu")
@ApiModel(value = "Menu对象", description = "")
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;
    private String component;
    private String path;
    private String redirect;
    private String name;
    private String title;
    private String icon;
    private Integer parentId;
    private String isLeaf;
    private Boolean hidden;

    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Menu> children;

    @TableField(exist = false)
    private Map<String,Object> meta = new HashMap<>();
    public Map<String,Object> getMeta(){
        meta.put("title",this.title);
        meta.put("icon",this.icon);
        return this.meta;
    }
}
