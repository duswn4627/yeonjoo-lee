package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.db.JDBCUtil;
import project.dto.AccDto;

public class AccDao {
	// ���µ��
	public int addAcc(AccDto dto) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = JDBCUtil.getConn();
			String sql = "insert into account values(?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, dto.getNum());
			pst.setString(2, dto.getBank());
			pst.setString(3, dto.getAccnum());
			pst.setInt(4, dto.getAmount());
			int n = pst.executeUpdate();
			System.out.println("<< ���°� ��ϵǾ����ϴ�. >>");
			return n;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			System.out.println("<< ���µ�Ͽ� �����߽��ϴ�. >>");
			return -1;
		}
	}
}