package com.example.myselfgpt_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myselfgpt_backend.domain.DTO.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 消息Mapper层，ORM与数据库交互
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageDTO> {
}
