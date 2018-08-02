package com.javalec.ex.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.common.MBUtils;
import com.javalec.ex.dto.BMemberDto;

public class BMemberDao {
	private String namespace = "com.javalec.ex.xml.BDtoMapper";
	DataSource dataSource;

	public BMemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void write(BMemberDto dto) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.insert(namespace + ".bMemberInsert", dto);
			if (res > 0) {
				session.commit();
				res = 0;
				res = session.insert(namespace + ".bMemberLoginInsert", dto);
				if (res > 0) {
					session.commit();
				} else {
					session.rollback();
				}
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public void modify(BMemberDto dto) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.update(namespace + ".bMemberUpdate", dto);
			if (res > 0) {
				session.commit();
				res = 0;
				res = session.update(namespace + ".bMemberLoginUpdate", dto);
				if (res > 0) {
					session.commit();
				} else {
					session.rollback();
				}
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}
	
	public BMemberDto select(String key) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		BMemberDto dto = null;
		try {
			dto = session.selectOne(namespace + ".bMemberSelect", key);
		}finally {
			session.close();
		}
		return dto;
	}
	
	public BMemberDto loginSelect(String key) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		BMemberDto dto = null;
		try {
			dto = session.selectOne(namespace + ".bMemberLoginSelect", key);
		}finally {
			session.close();
		}
		return dto;
	}
	
	public ArrayList<BMemberDto> selectAll(){
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		List<BMemberDto> list = new ArrayList<>();
		try {
			list = session.selectList(namespace + ".bMemberSelectAll");
		}finally {
			session.close();
		}
		return (ArrayList<BMemberDto>)list;
	}
	
	public ArrayList<BMemberDto> loginSelectAll(){
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		List<BMemberDto> list = new ArrayList<>();
		try {
			list = session.selectList(namespace + ".bMemberLoginSelectAll");
		}finally {
			session.close();
		}
		return (ArrayList<BMemberDto>)list;
	}
	
	public void delete(String key) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.delete(namespace + ".bMemberDelete", key);
			if(res>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}finally {
			session.close();
		}
	}
}
