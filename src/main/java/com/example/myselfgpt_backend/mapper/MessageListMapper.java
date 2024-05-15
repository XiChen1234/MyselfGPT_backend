package com.example.myselfgpt_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myselfgpt_backend.domain.DTO.MessageListDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 聊天列表Mapper层，ORM与数据库交互
 */
@Mapper
public interface MessageListMapper extends BaseMapper<MessageListDTO> {
}
