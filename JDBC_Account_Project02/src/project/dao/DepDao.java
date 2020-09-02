package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import project.db.JDBCUtil;
import project.dto.DepDto;

public class DepDao {

	// 수입
	public int addDep(DepDto dto) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;

		try {
			con = JDBCUtil.getConn();
			String sql = "insert into deposit values(?, sysdate, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dto.getNum());
			pst.setString(2, dto.getCategory());
			pst.setInt(3, dto.getMoney());
			pst.executeUpdate();

			String sql1 = "update account set amount=(amount+?) where num=?";
			pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, dto.getMoney());
			pst1.setInt(2, dto.getNum());
			int n = pst1.executeUpdate();
			System.out.println("<< 수입 처리되었습니다. >>");
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			System.out.println("<< 수입 처리에 실패했습니다. >>");
			return -1;
		} finally {
			JDBCUtil.close(null, pst, con);
			JDBCUtil.close(null, pst1, null);
		}
	}

	// 전체입금내역
	public ArrayList<DepDto> depAll(int num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "select * from deposit where num=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			if (rs.next()) {
				ArrayList<DepDto> list = new ArrayList<DepDto>();
				do {
					Date cadate = rs.getDate("cadate");
					String category = rs.getString("category");
					int money = rs.getInt("money");
					DepDto dto = new DepDto(num, cadate, category, money);
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