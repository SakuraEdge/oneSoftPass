package com.eternal.oneSoftPass.dao.datasource;

import com.eternal.oneSoftPass.bean.DataSourceBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IDataSourceDAO {

    @Insert("insert into osp_datasource_save(NAME,U_ID,DATA_TYPE,DATA_IP,DATA_PORT,DATA_TABLE,DATA_USERNAME,DATA_PASSWORD,CREATE_TIME,NOTE)" +
            " VALUES(#{name},#{uid},#{type},#{ip},#{port},#{table},#{userName},#{userPwd},#{time},#{note})")
    void sourceSave(@Param("name") String name,@Param("uid") String uid,@Param("type") String type,@Param("ip") String ip,@Param("port") String port,
                    @Param("table") String table,@Param("userName") String userName,@Param("userPwd") String userPwd,
                    @Param("time") String time,@Param("note") String note);


    @Select("select * from osp_datasource_save where U_ID = #{id} and STATE = 'U'")
    List<DataSourceBean> getSource(@Param("id") String id);

    @Delete("delete from osp_datasource_save where ID=#{id}")
    void delSource(@Param("id") String i);
}
