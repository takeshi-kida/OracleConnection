package businessEntity.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import businessEntity.dto.T_USER;
import businessLogic.DriverManeger;

public class SelectT_USER {
	private Connection conn = null;
	private Statement stmt = null;

	private DriverManeger dm = new DriverManeger();

	public List<T_USER> selectT_USER() throws Exception {
		List<T_USER> getResult = new ArrayList<T_USER>();

		try {
			// Connectionの作成
			conn = dm.getConnection();

			//オートコミットはオフにする。
			conn.setAutoCommit(false);

			// Statementの作成
			stmt = conn.createStatement();
			// Resultsetの作成
			ResultSet rset = stmt.executeQuery("select USER_NAME from T_USER");
			// 取得したデータを出力する
			while (rset.next()) {
				System.out.println(rset.getString("USER_NAME"));
			}
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

		return getResult;

	}
}
