package com.eternal.oneSoftPass.dao.datasource;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.DataSourceBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IDataSourceDAO extends BaseMapper<DataSourceBean> {

}
