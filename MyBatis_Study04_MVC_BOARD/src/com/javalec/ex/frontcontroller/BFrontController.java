package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BContentCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BListCommand;
import com.javalec.ex.command.BLogoutCommand;
import com.javalec.ex.command.BMemberJoin;
import com.javalec.ex.command.BMemberLogin;
import com.javalec.ex.command.BModifyCommand;
import com.javalec.ex.command.BReplyCommand;
import com.javalec.ex.command.BReplyViewCommand;
import com.javalec.ex.command.BWriteCommand;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		// 요청되는 요구에 맞는 작업(Command)으로 분기
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			int curBlock = 0;
			if(request.getParameter("curBlock")!=null) {				
				curBlock = Integer.parseInt(request.getParameter("curBlock"));
			}
			int curPage = 0;
			if(request.getParameter("curPage")!=null) {				
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			request.setAttribute("curBlock", curBlock);
			request.setAttribute("curPage", curPage);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/login.do")) {
			command = new BMemberLogin();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/join.do")) {
			command = new BMemberJoin();
			command.execute(request, response);
			viewPage = "login.jsp";
		} else if(com.equals("/logout.do")) {
			command = new BLogoutCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		// 중간처리 후 마지막단계에서 수행시킬 부분
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		// 적절한 view페이지로 프로그램의 흐름을 지정
		// 새로이 만들어진 커맨드 수행 결과를 싸들고 새로운 뷰단으로 넘어간다.
		dispatcher.forward(request, response);
		
	}

}
