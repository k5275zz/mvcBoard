package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardDelAction implements Action {

	@Override
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardBean bbean = new BoardBean();
		ActionForward1 forward1 = new ActionForward1();
		bbean.setBno(Integer.parseInt(request.getParameter("bno")));
		//sql¹® ½ÇÇà
		bdao.boardDel(bbean);
		
		forward1.setRedirect(true);
		forward1.setPath("BoardList.bo");
		return forward1;
	}

}
