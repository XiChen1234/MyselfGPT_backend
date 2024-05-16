package com.example.myselfgpt_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myselfgpt_backend.domain.VO.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户Mapper层，ORM与数据库交互
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
