package com.funny.sys.service.impl;

import com.funny.sys.entity.User;
import com.funny.sys.mapper.UserMapper;
import com.funny.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author funny star
 * @since 2023-09-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
