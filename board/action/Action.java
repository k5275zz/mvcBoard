package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.action.ActionForward;

public interface Action {
	public ActionForward1 execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
