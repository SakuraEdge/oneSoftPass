package com.eternal.oneSoftPass.dao.user;

import com.eternal.oneSoftPass.bean.SignInfoBean;
import com.eternal.oneSoftPass.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserDAO {

    @Select("select U_ID from osp_user where TEL = #{tel} and STATE = 'U'")
    String selectUIDByTEL(@Param("tel") String tel);

    @Select("select U_ID from osp_user where EMAIL = #{email} and STATE = 'U'")
    String selectUIDByEmail(@Param("email") String email);

    @Select("select NAME,TEL,EMAIL,DESCRIPTION,CREATE_TIME,LOGIN_TIME,EXP from osp_user where U_ID = #{id} and STATE = 'U'")
    UserBean selectUserByID(@Param("id") String id);

    @Update("update osp_user set DESCRIPTION = #{description} where U_ID = #{id} and STATE = 'U'")
    void updateDes(@Param("id") String id,@Param("description") String description);

    @Update("update osp_user set PASSWORD = #{pwd} where U_ID = #{id} and STATE = 'U'")
    void updatePwd(@Param("id") String id,@Param("pwd") String newPwd);

    @Select("select U_ID,U_NAME,S_MSG,S_TIME,S_EXP from osp_sign_info order by S_TIME desc")
    List<SignInfoBean> getSignInfo();

}
