package com.funny.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.funny.sys.entity.User;
import com.funny.sys.mapper.UserMapper;
import com.funny.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> login(User user) {
        //根据用户名和密码查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        //结果不为空，则生成token，并且将用户信息存入redis
        if(loginUser != null){
            //暂时用UUID，终极方案为jwt
            String key = "user:" + UUID.randomUUID();

            //存入redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);
            //返回数据
            Map<String,Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }
}
