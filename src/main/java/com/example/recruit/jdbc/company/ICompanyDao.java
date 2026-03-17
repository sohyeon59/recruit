package com.example.recruit.jdbc.company;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICompanyDao {
    CompanyDto login(CompanyDto dto);
    int regist(CompanyDto dto);
    int idCheck(String cid);
}