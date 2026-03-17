package com.example.recruit.jdbc.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberDao {
    MemberDto login(MemberDto dto);
    int regist(MemberDto dto);
    int idCheck(String mid);
}