package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.db.JDBCUtil;
import project.dto.MemDto;
import project.dto.joinDto;

public class MemDao {
	// 회원가입
	public int addMem(MemDto dto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into member values(?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dto.getNum());
			pst.setString(2, dto.getName());
			pst.setString(3, dto.getPw());
			pst.setString(4, dto.getEmail());
			int n = pst.executeUpdate();
			System.out.println("<< 가입되었습니다. >>");
			return n;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("<< 가입에 실패했습니다. >>");
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 회원정보수정
	public int update(MemDto dto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "update member set pw=?, email=? where num=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getPw());
			pst.setString(2, dto.getEmail());
			pst.setInt(3, dto.getNum());
			int n = pst.executeUpdate();
			System.out.println("<< 회원정보가 수정되었습니다. >>");
			return n;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("<< 회원정보 수정에 실패했습니다. >>");

			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
		}
	}

	// 회원삭제
	public int delMem(int num) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		PreparedStatement pst4 = null;
		try {
			con = JDBCUtil.getConn();
			con.setAutoCommit(false);

			String sql1 = "delete from deposit where num=?";
			pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, num);
			pst1.executeUpdate();

			String sql2 = "delete from withdraw where num=?";
			pst2 = con.prepareStatement(sql2);
			pst2.setInt(1, num);
			pst2.executeUpdate();

			String sql3 = "delete from account where num=?";
			pst3 = con.prepareStatement(sql3);
			pst3.setInt(1, num);
			pst3.executeUpdate();

			String sql4 = "delete from member where num=?";
			pst4 = con.prepareStatement(sql4);
			pst4.setInt(1, num);
			int n = pst4.executeUpdate();
			con.commit();
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		} finally {
			JDBCUtil.close(null, pst4, con);
			JDBCUtil.close(null, pst3, null);
			JDBCUtil.close(null, pst2, null);
			JDBCUtil.close(null, pst1, null);
		}
	}

	// 선택회원조회
	public joinDto search(int num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select m.num, name, pw, email, accnum, amount from member m join account a on m.num=a.num and m.num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String accnum = rs.getString("accnum");
				int amount = rs.getInt("amount");
				joinDto dto = new joinDto(num, name, pw, email, accnum, amount);
				return dto;
			} else {
				return null;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			JDBCUtil.close(rs, pst, con);
		}
	}

	// 전체회원조회
	public ArrayList<joinDto> viewAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select m.num, name, pw, email, accnum, amount from member m join account a on m.num=a.num order by num";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ArrayList<joinDto> list = new ArrayList<joinDto>();
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String accnum = rs.getString("accnum");
				int amount = rs.getInt("amount");
				joinDto dto = new joinDto(num, name, pw, email, accnum, amount);
				list.add(dto);
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}
	}
}
