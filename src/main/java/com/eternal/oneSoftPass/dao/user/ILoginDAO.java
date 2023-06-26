package com.eternal.oneSoftPass.dao.user;

import com.eternal.oneSoftPass.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ILoginDAO {

    @Select("select * from osp_user where tel = #{tel} and password = #{pwd}")
    UserBean getUserByLogin(@Param("tel") String tel,@Param("pwd") String password);

    @Select("select * from osp_user where U_ID = #{id} and password = #{pwd}")
    UserBean getUserByCookie(@Param("id") String id,@Param("pwd") String password);

    @Update("update osp_user set LOGIN_TIME = #{time} where U_ID = #{id}")
    void updateLoginTime(@Param("id") String id,@Param("time") String time);
}
