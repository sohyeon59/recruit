package com.example.recruit.jdbc.company;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ICompanyDao {
    CompanyDto login(@Param("cid") String id, @Param("cpw")String pw);
    int regist(CompanyDto dto);
    int idCheck(String cid);
}