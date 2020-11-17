package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.member.action.ActionForward;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardBean bbean =new BoardBean();
		ActionForward1 forward = new ActionForward1();
		
		request.setCharacterEncoding("utf-8");
		
		bbean.setSubject(request.getParameter("subject"));
		bbean.setContent(request.getParameter("content"));
		bbean.setWriter(request.getParameter("writer"));
		
		bdao.boardInsert(bbean);
		
		forward.setRedirect(true);
		forward.setPath("BoardList.bo");
		System.out.println("bbb");
		return forward;
	}

}
