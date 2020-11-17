package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet implements javax.servlet.Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		System.out.println("RequestURI: " + RequestURI);
		System.out.println("contextPath: " + contextPath);
		System.out.println("command: " + command);

		ActionForward1 forward1 =null;
		Action action = null;

		if (command.equals("/BoardWrite.bo")) {
			action = new BoardInsertAction();
			try {
				forward1 = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//BoardWrite.bo끝
		else if(command.equals("/BoardList.bo")) {
			action = new BoardListAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardList.bo끝
		else if(command.equals("/BoardDetail.bo")) {
			action = new BoardDetailtAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardDetail.bo 끝
		else if(command.equals("/BoardModify.bo")) {
			action = new BoardModifyAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardDetail.bo 끝
		else if(command.equals("/BoardDel.bo")) {
			System.out.println("BBB");
			action = new BoardDelAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}
		
		
		
		
		  if(forward1!=null) {
   		   if(forward1.isRedirect()) {
   			   // 1. redirect : 새로운 페이지에서는 request, response객체가 새롭게 생성된다. - 로그인,회원가입,글쓰기
   			   response.sendRedirect(forward1.getPath());
   		   }else {
   			   //2. dispatcher(forward) : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request, response 객체를 공유. 리스트보기, 검색
   			   RequestDispatcher dispatcher=request.getRequestDispatcher(forward1.getPath());
   			   dispatcher.forward(request, response);
   		   }
		  }

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
