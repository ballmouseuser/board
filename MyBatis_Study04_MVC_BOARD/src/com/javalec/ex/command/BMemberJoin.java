package com.javalec.ex.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BMemberDao;
import com.javalec.ex.dto.BMemberDto;

public class BMemberJoin implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String mname = request.getParameter("mname");
		String mbirthday = request.getParameter("mbirthday");
		String mphone = request.getParameter("mphone");
		
		BMemberDto dto = new BMemberDto();
		BMemberDao dao = new BMemberDao();
		
		String[] temp = mbirthday.split("-");
		int year = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int day = Integer.parseInt(temp[2]);
		
		dto.setMId(mid);
		dto.setMPassword(mpassword);
		dto.setMName(mname);
		dto.setMPhone(mphone);
		dto.setMBirthday(new Date(year-1900,month-1,day));
		
		dao.write(dto);
		
		
	}

}
