package businessEntity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DaoConnectionManeger {

	static Connection conn;
	static Statement stmt;
	static PreparedStatement ps;

	public DaoConnectionManeger()
	{
		try {

			// Connectionの作成
			// JDBCドライバクラスのロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connectionの作成
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + ConnectionStrings.SERVER_NAME.getValue() + ":1521:"
							+ ConnectionStrings.SID.getValue(),
					ConnectionStrings.USER.getValue(), ConnectionStrings.PASS.getValue());

			//オートコミットはオフにする。
			conn.setAutoCommit(false);
			// Statementの作成
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}