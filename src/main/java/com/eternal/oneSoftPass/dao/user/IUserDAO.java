package com.eternal.oneSoftPass.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDAO {

    @Select("select U_ID from osp_user where TEL = #{tel}")
    String selectUIDByTEL(@Param("tel") String tel);

    @Select("select U_ID from osp_user where EMAIL = #{email}")
    String selectUIDByEmail(@Param("email") String email);

}
