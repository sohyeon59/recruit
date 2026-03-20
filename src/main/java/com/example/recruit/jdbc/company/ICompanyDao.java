package com.example.recruit.jdbc.company;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ICompanyDao {
    CompanyDto login(CompanyDto dto);
    int regist(CompanyDto dto);
    int idCheck(@Param("cid")String cid);
}