package businessEntity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import businessEntity.dto.T_USER;
import businessLogic.DriverManeger;

public class InsertT_USER {

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;

	private DriverManeger dm = new DriverManeger();

	private String insertSql = "INSERT INTO T_USER values(?, ?, ?, ?, ?)";

	public void insertUserTable(T_USER tUser ) throws Exception
	{
		try {
			// Connectionの作成
			conn = dm.getConnection();

			//オートコミットはオフにする。
			conn.setAutoCommit(false);

			// Statementの作成
			stmt = conn.createStatement();

			ps = conn.prepareStatement(insertSql);
			ps.setString(1, tUser.USER_ID);
			ps.setString(2, tUser.PASSWORD);
			ps.setString(3, tUser.USER_NAME);
			ps.setInt(4, tUser.AGE);
			ps.setString(5, tUser.ORG_CD);

			//INSERT文を実行する
			int result = ps.executeUpdate();

			//処理件数を表示する
			System.out.println("結果：" + result);

			//コミット
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				/* クローズ処理 */
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Throwable e) {
				// nop
			}
		}
	}
}