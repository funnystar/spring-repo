package com.funny.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author funny star
 * @since 2023-09-16
 */

@Data
@TableName("x_role")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    @TableField(exist = false)
    private List<Integer> menuIdList;
}
