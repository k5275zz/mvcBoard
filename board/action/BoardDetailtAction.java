package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;
import net.member.action.ActionForward;


public class BoardDetailtAction implements Action {

	@Override
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardBean bbean = new BoardBean();
		ActionForward1 forward = new ActionForward1();// 이동 구문
		request.setCharacterEncoding("utf-8");
		System.out.println("detail bno="+request.getParameter("bno"));
		
		bbean.setBno(Integer.parseInt(request.getParameter("bno")));
		BoardBean detail=bdao.boardDetail(bbean);
		request.setAttribute("boarddetail", detail);
		
		forward.setRedirect(false);
		forward.setPath("board/board_detail.jsp");
		
		return forward;
	}

}
