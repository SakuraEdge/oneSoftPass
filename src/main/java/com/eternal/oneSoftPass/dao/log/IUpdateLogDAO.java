package com.eternal.oneSoftPass.dao.log;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.UpdateLogBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUpdateLogDAO extends BaseMapper<UpdateLogBean> {
}
