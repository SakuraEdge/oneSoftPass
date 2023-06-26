package com.eternal.oneSoftPass.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IRegisterDAO {

    @Insert("insert into osp_user(NAME,TEL,PASSWORD,EMAIL,CREATE_TIME) values(#{name},#{tel},#{pwd},#{email},#{time});")
    void registerUser(@Param("name") String name,@Param("tel") String tel,@Param("pwd") String pwd,@Param("email") String email,@Param("time") String time);


}
