package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ccc");
		BoardDAO bdao = new BoardDAO();
		
		ArrayList<BoardBean> list =new ArrayList<BoardBean>();
		
		ActionForward1 forward1 = new ActionForward1();
		
		request.setCharacterEncoding("utf-8");
		list = bdao.boardList();
		request.setAttribute("boardlist", list);
		
		forward1.setRedirect(false);
		forward1.setPath("board/board_list.jsp");
		return forward1;
	}

}
