package com.funny.sys.mapper;

import com.funny.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author funny star
 * @since 2023-09-16
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    public List<Integer> getMenuIdListByRoleId(Integer roleId);
}
