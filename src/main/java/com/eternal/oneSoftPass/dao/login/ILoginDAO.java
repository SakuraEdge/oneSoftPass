package com.eternal.oneSoftPass.dao.login;

import com.eternal.oneSoftPass.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ILoginDAO {

    @Select("select * from osp_user where tel = #{tel} and password = #{pwd}")
    UserBean getUserByLogin(@Param("tel") String tel,@Param("pwd") String password);
}
