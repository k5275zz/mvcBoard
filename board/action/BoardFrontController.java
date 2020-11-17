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
		}//BoardWrite.bo��
		else if(command.equals("/BoardList.bo")) {
			action = new BoardListAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardList.bo��
		else if(command.equals("/BoardDetail.bo")) {
			action = new BoardDetailtAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardDetail.bo ��
		else if(command.equals("/BoardModify.bo")) {
			action = new BoardModifyAction();
			try {
 			   forward1=action.execute(request, response);
 		   }catch(Exception e) {
 			   e.printStackTrace();
 		   }
		}// BoardDetail.bo ��
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
   			   // 1. redirect : ���ο� ������������ request, response��ü�� ���Ӱ� �����ȴ�. - �α���,ȸ������,�۾���
   			   response.sendRedirect(forward1.getPath());
   		   }else {
   			   //2. dispatcher(forward) : ���� �������� �������� forward�� ���� ȣ��� �������� request, response ��ü�� ����. ����Ʈ����, �˻�
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
