package com.example.myselfgpt_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myselfgpt_backend.domain.DO.Talk;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 会话Mapper层，ORM与数据库交互
 */
@Mapper
public interface TalkMapper extends BaseMapper<Talk> {
}
