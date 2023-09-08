package com.eternal.oneSoftPass.dao.exchange;


import com.eternal.oneSoftPass.bean.RetBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface IExChangeDAO {

    @Update("update osp_exchange set name=#{name},hui_in=#{hui_in},hui_out=#{hui_out},chao_in=#{chao_in},chao_out=#{chao_out}," +
            "code=#{code},zhesuan=#{zhesuan},day=#{day},time=#{time} where id=#{id}")
    void UpdateExChange(@Param("id") int id,@Param("name") String name,@Param("hui_in") String hui_in,@Param("hui_out") String hui_out,
                        @Param("chao_in") String chao_in,@Param("chao_out") String chao_out,@Param("code") String code,
                        @Param("zhesuan") String zhesuan,@Param("day") String day,@Param("time") String time);

    @Select("select * from osp_exchange")
    ArrayList<RetBean> getRetInfo();

}
