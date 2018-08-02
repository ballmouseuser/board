package com.javalec.ex.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.BMemberDao;
import com.javalec.ex.dto.BMemberDto;

public class BMemberLogin implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
			
		BMemberDao dao = new BMemberDao();
		BMemberDto dto = dao.loginSelect(mid);
		
		BMemberDto dto2 = null;
		
//		System.out.println("id:"+dto.getmId());
//		System.out.println("id:"+mid);
//		System.out.println("mpassword:"+dto.getMPassword());
//		System.out.println("mpassword:"+mpassword);
//		
//		System.out.println(dto.getmId().equals(mid));
//		System.out.println(dto.getMPassword().equals(mpassword));
		HttpSession session = request.getSession();
		try {
			PrintWriter out = response.getWriter();
			if(dto.getmId().equals(mid)) {
				if(dto.getMPassword().equals(mpassword)) {
					dto2 = dao.select(mid);
					session.setAttribute("mid", mid);
					session.setAttribute("mpassword", mpassword);
					session.setAttribute("mname", dto2.getMName());
					session.setAttribute("mbirthday", dto2.getMBirthday());
					session.setAttribute("mphone", dto2.getMPhone());
					session.setAttribute("mjoindate", dto2.getMJoindate());
				}else {

				}
			}else {

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
