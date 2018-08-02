package com.javalec.ex.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import com.javalec.ex.common.MBUtils;
import com.javalec.ex.dto.BDto;

public class BDao {
	// DBCP 사용하기 위한 자원
	// DBCP를 사용하기 위해서는 Server context.xml에 Resource태그를 추가하여야 이용이 가능하다.
	private String namespace = "com.javalec.ex.xml.BDtoMapper";
	DataSource dataSource;

	public BDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 게시글을 인설트하는 부분
	public void write(BDto dto) { // 글작성
		// 일반적으로 vo(dto)를 만들어 전달하나, 여기서는 필드값 각각을 입력함
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.insert(namespace + ".insert", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	// 모든 등록된 게시글을 리스트에 담아오기(selectAll)
	public ArrayList<BDto> list() { // selectAll
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		List<BDto> dtos = new ArrayList<BDto>();

		try {
			dtos = session.selectList(namespace + ".selectAll");
		} finally {
			session.close();
		}
		return (ArrayList<BDto>) dtos;
	}

	// strID를 받아 그 내용을 보여줄때 사용(select(key)
	public BDto contentView(int bId) { //
		// TODO Auto-generated method stub
		// 글을 조회 할 때마다 1씩 증가 시켜주는 로직
		// 서브루틴으로 메소드를 만들어서 사용(자주사용하기때문에)
		upHit(bId);

		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		BDto vo = null;
		try {
			vo = session.selectOne(namespace + ".select", bId);
		} finally {
			session.close();
		}
		return vo;
	}

	// 게시글을 수정할때 사용하는 메소드 - 수정작업을 종료한다.
	public void modify(BDto dto) {
		int res = 0;
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		try {
			res = session.update(namespace + ".update", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	// 게시글을 삭제하는 메소드
	public void delete(int bId) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.delete(namespace + ".delete", bId);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	// 답글 보여주기에 필요한 vo를 리턴받는 메소드
	public BDto reply_view(int bId) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		BDto vo = null;
		try {
			vo = session.selectOne(namespace + ".select", bId);
		} finally {
			session.close();
		}
		return vo;
	}

	// 답글을 작성하는 메소드 (게시글 인설트와 유사함)
	public void reply(BDto dto) {
		// TODO Auto-generated method stub
		// 게시글 그룹 및 게시순서를 세팅
		replyShape(dto);

		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			dto.setBStep(dto.getBStep() + 1);
			dto.setBIndent(dto.getBIndent() + 1);
			res = session.insert(namespace + ".reply", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	// 답글의 위치와 순서를 처리해주는 메소드
	private void replyShape(BDto dto) {
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.update(namespace + ".replyShape", dto);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}

	// 답글이나 게시글의 조회수를 증가시키는 메소드
	private void upHit(int strID) {
		// TODO Auto-generated method stub
		SqlSession session = MBUtils.getSqlSessionFactory().openSession();
		int res = 0;
		try {
			res = session.update(namespace + ".upHit", strID);
			if (res > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} finally {
			session.close();
		}
	}
}
