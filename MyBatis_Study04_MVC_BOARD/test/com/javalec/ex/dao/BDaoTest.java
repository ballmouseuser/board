/*package com.javalec.ex.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.javalec.ex.dto.BDto;

public class BDaoTest {
	private BDao dao;

	@Before
	public void init() {
		dao = new BDao();
	}

	@After
	public void stop() {
	}
	@Test
	public void ��猷����ν���ㅽ��() {
		BDto vo = new BDto();
		vo.setBName("��湲몃��");
		vo.setBTitle("寃���臾쇱���ν���ㅽ��");
		vo.setBContent("寃���臾쇱���ν���ㅽ�몄������.");
		dao.write(vo);
	}
	@Test
	public void ��猷��������ㅽ��() {
		BDto vo = new BDto();
		vo.setBName("�댁�щ��");
		vo.setBTitle("寃���臾쇱���ν���ㅽ��.");
		vo.setBContent("寃���臾쇱���ν���ㅽ�몄������.....");
		vo.setBId(123);
		dao.modify(vo);
	}
	@Test
	public void ��猷�議고�����ㅽ��() {
		dao.reply_view(123);
	}
	@Test
	public void �듦����ν���ㅽ��() {
		BDto vo = new BDto();
		vo.setBName("諛�洹쇱��");
		vo.setBTitle("�댁�щ�� 諛�蹂�");
		vo.setBContent("�댁�щ�� 諛�蹂대��");
		vo.setBGroup(123);
		vo.setBStep(1);
		vo.setBIndent(1);
		dao.reply(vo);
	}
	@Test
	public void 肄����몃럭���ㅽ��() {
		dao.contentView(123);
	}
	@Test
	public void ��猷��������ㅽ��() {
		dao.delete(123);
	}
}
*/