package com.eternal.oneSoftPass.dao.chat;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.ChatBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IChatDAO extends BaseMapper<ChatBean> {
}
