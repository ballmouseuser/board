package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;
import com.javalec.ex.dto.BDto;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDto dto = new BDto();
		
		dto.setBId(Integer.parseInt(request.getParameter("bId")));
		dto.setBName(request.getParameter("bName"));
		dto.setBTitle(request.getParameter("bTitle"));
		dto.setBContent(request.getParameter("bContent"));
		
		BDao dao = new BDao();
		
		dao.modify(dto);
		
			
	}

}
