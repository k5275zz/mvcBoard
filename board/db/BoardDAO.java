package net.board.db;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import net.member.db.MemberBean;

import javax.naming.*;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public BoardDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void boardInsert(BoardBean bbean) {
		String sql = "insert into mvcboard(subject,content,writer)" + " values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			// 매개변수를 통해 넘겨준다.
			
			pstmt.setString(1, bbean.getSubject());
			pstmt.setString(2, bbean.getContent());
			pstmt.setString(3, bbean.getWriter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
		}

	}// boardInsert end

	public ArrayList<BoardBean> boardList() {
		String sql = "select * from mvcboard";
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		try {
			pstmt = con.prepareStatement(sql);
			// 매개변수를 통해 넘겨준다.
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setBno(rs.getInt("bno"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setWriter(rs.getString("writer"));
				bean.setWritedate(rs.getString("writedate"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if (con != null) {
				if(con!=null){try{con.close();}catch(Exception e){}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
				if(rs!=null){try{rs.close();}catch(Exception e){}}}
		}
		return list;
	}// boardlist end

	public BoardBean boardDetail(BoardBean bbean) {
		String sql = "select * from mvcboard where bno=?";
		BoardBean bean = null;
		
		try {
			pstmt= con.prepareStatement(sql);
			// 매개변수를 통해 넘겨준다.
			
			pstmt.setInt(1, bbean.getBno());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				bean = new BoardBean();
				bean.setBno(rs.getInt("bno"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setWriter(rs.getString("writer"));
				bean.setWritedate(rs.getString("writedate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if(con!=null){try{con.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
			if(rs!=null){try{rs.close();}catch(Exception e){}}
		}
		return bean;
	}// boarddetail end
	
	public void boardModify(BoardBean bbean) {
		String sql = "update mvcboard set subject=?,content=? where bno=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bbean.getSubject());
			pstmt.setString(2, bbean.getContent());
			pstmt.setInt(3, bbean.getBno());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{ // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if(con!=null){try{con.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
		}
	} // boardmodify end
	
	public void boardDel(BoardBean bbean) {
		String sql="delete from mvcboard where bno=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbean.getBno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ // 예외가 있던 말던 처리한다. 끊어줘야지 반복 새로고침해도 먹통이 되지 않는다.
			if(con!=null){try{con.close();}catch(Exception e){}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){}}
		}
	}
	
	
}
