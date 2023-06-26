package com.eternal.oneSoftPass.dao.user;

import com.eternal.oneSoftPass.bean.UserBean;
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

    @Select("select NAME,TEL,EMAIL,DESCRIPTION,CREATE_TIME from osp_user where U_ID = #{id}")
    UserBean selectUserByID(@Param("id") String id);

}
