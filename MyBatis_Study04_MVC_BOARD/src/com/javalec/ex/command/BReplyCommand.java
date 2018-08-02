package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDto dto = new BDto();

		dto.setBId(Integer.parseInt(request.getParameter("bId")));
		dto.setBName(request.getParameter("bName"));
		dto.setBTitle(request.getParameter("bTitle"));
		dto.setBContent(request.getParameter("bContent"));
		dto.setBGroup(Integer.parseInt(request.getParameter("bGroup")));
		dto.setBStep(Integer.parseInt(request.getParameter("bStep")));
		dto.setBIndent(Integer.parseInt(request.getParameter("bIndent")));

		BDao dao = new BDao();
		dao.reply(dto);
		
	}

}
