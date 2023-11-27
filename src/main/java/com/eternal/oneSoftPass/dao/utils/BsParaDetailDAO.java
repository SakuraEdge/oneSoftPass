package com.eternal.oneSoftPass.dao.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.BsParaBean;
import com.eternal.oneSoftPass.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BsParaDetailDAO extends BaseMapper<BsParaBean> {
}
