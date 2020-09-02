package project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConn() throws SQLException {
		try {
			Connection con = null;
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String url = "jdbc:oracle:thin:@192.168.0.36:1521:xe";
			con = DriverManager.getConnection(url, "scott", "tiger");
			return con;
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			return null;
		}
	}

	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null)
				st.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
