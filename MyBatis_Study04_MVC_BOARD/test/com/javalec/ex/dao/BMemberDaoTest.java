/*package com.javalec.ex.dao;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.javalec.ex.dto.BMemberDto;

public class BMemberDaoTest {
	private BMemberDao dao;
	
	@Before
	public void init() {
		dao = new BMemberDao();
	}

	@After
	public void stop() {
	}
	
	@Test
	public void �����깅���猷����ν���ㅽ��() {
		BMemberDto dto = new BMemberDto();
		dto.setMId("hgd");
		dto.setMName("��湲몃��");
		dto.setMBirthday(new Date(1990-1900,8-1,27));
		dto.setMPassword("1234");
		dto.setMPhone("010-1111-2222");
		dao.write(dto);
	}
	@Test
	public void ������猷��������ㅽ��() {
		BMemberDto dto = new BMemberDto();
		dto.setMId("hgd");
		dto.setMName("��湲몃����");
		dto.setMBirthday(new Date(1990-1900,8-1,26));
		dto.setMPassword("1222");
		dto.setMPhone("000-1111-3333");
		dao.modify(dto);
	}
	@Test
	public void ��猷�議고�����ㅽ��() {
		dao.select("hgd");
	}
	@Test
	public void ��泥댁��猷�議고��() {
		dao.loginSelectAll();
	}
	@Test
	public void ������猷��������ㅽ��() {
		dao.delete("hgd");
	}
}
*/