package com.kh.spring.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.model.dto.Member;

@Mapper
public interface MybatisRepository {
	
	@Select("select password from member where user_id = #{userId}")
	String selectPasswordByUserId(String userId);
	
	@Select("select * from member where user_id = #{userId}")
	Member selectMemberByUserId(String userId);
	
	
	@Select(" select * from member inner join rent_master using(user_id) where user_id=#{user_id}")
	List<Map<String,Object>> selectRentAndMemberByUserId(String userId);
	
	List<Map<String,Object>>selectRentBookByUserId(String userId);
	
	@Insert(" insert into member(user_id, password, tell, email) values(#{userId},#{password},#{tell},#{email})")
	Member insertWithDto(Member member);
	
	@Insert("insert into rent_master(rm_idx,user_id,title,rent_book_cnt) values(sc_rm_idx.nextval,#{member.userId},#{title},#{rentBookCnt})")
	Map<String, Object> insertWithMap(Map commandMap);
	
	@Delete("delete from rent_master where user_id = #{userId}")
	String delete(String userId);
	
	@Update(" update member set password = #{password} where user_id <= #{userId}")
	Member update(String password, String userId);
}
