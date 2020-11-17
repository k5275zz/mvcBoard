package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardBean bbean = new BoardBean();
		ActionForward1 forward = new ActionForward1();
		System.out.println("모디파이실행");
		request.setCharacterEncoding("utf-8");
		bbean.setBno(Integer.parseInt(request.getParameter("bno")));
		bbean.setSubject(request.getParameter("subject"));
		bbean.setContent(request.getParameter("content"));
		bbean.setWriter(request.getParameter("writer"));
		bbean.setWritedate(request.getParameter("writedate"));
		// sql실행
		bdao.boardModify(bbean);
		
		forward.setRedirect(true);
		forward.setPath("BoardDetail.bo?bno="+request.getParameter("bno"));
		return forward;
	}

}
