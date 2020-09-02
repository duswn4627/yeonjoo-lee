package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.db.JDBCUtil;
import project.dto.WithDto;

public class WithDao {

	// 지출
	public int addWith(WithDto dto) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;

		try {
			con = JDBCUtil.getConn();
			String sql = "insert into withdraw values(?, sysdate, ?, ?)";
			String sql1 = "update account set amount=(amount-?) where num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dto.getNum());
			pst.setString(2, dto.getCategory());
			pst.setInt(3, dto.getMoney());
			pst.executeUpdate();

			pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, dto.getMoney());
			pst1.setInt(2, dto.getNum());
			int n = pst1.executeUpdate();
			System.out.println("<< 지출 처리되었습니다. >>");
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			System.out.println("<< 지출 처리에 실패했습니다. >>");
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
			JDBCUtil.close(null, pst1, null);
		}
	}

	// 전체출금내역
	public ArrayList<WithDto> withAll(int num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from withdraw where num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			if (rs.next()) {
				ArrayList<WithDto> list = new ArrayList<WithDto>();
				do {
					Date cadate = rs.getDate("cadate");
					String category = rs.getString("category");
					int money = rs.getInt("money");
					WithDto dto = new WithDto(num, cadate, category, money);
					list.add(dto);
				} while (rs.next());
				return list;
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
}