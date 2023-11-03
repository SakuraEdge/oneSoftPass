package com.eternal.oneSoftPass.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eternal.oneSoftPass.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ILoginDAO extends BaseMapper<UserBean> {

    @Select("select * from osp_user where tel = #{tel} and password = #{pwd} and STATE = 'U'")
    UserBean getUserByLogin(@Param("tel") String tel,@Param("pwd") String password);

    @Select("select * from osp_user where U_ID = #{id} and password = #{pwd} and STATE = 'U'")
    UserBean getUserByCookie(@Param("id") String id,@Param("pwd") String password);

    @Update("update osp_user set LOGIN_TIME = #{time} where U_ID = #{id} and STATE = 'U'")
    void updateLoginTime(@Param("id") String id,@Param("time") String time);
}
