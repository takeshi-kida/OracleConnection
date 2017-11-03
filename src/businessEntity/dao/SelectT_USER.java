package businessEntity.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import businessEntity.dto.T_USER;
import businessLogic.DriverManeger;

public class SelectT_USER {
	private static Connection conn = null;
	private static Statement stmt = null;

	private static DriverManeger dm = new DriverManeger();

	private static final String selectAllSql = "select USER_ID, PASSWORD, USER_NAME, AGE, ORG_CD from T_USER";

	public static List<T_USER> selectT_USER() throws Exception {
		List<T_USER> getResult = new ArrayList<T_USER>();

		try {
			// Connectionの作成
			conn = dm.getConnection();

			// Statementの作成
			stmt = conn.createStatement();
			// Resultsetの作成
			ResultSet rset = stmt.executeQuery(selectAllSql);

			T_USER tUser = new T_USER();
			// 取得したデータを出力する
			while (rset.next()) {
				tUser = new T_USER();

				tUser.USER_ID = rset.getString(1);
				tUser.PASSWORD = rset.getString(2);
				tUser.USER_NAME = rset.getString(3);
				tUser.AGE = rset.getInt(4);
				tUser.ORG_CD = rset.getString(5);

				getResult.add(tUser);

			}
		} catch (Exception e) {
			e.printStackTrace();
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
