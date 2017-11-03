package businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverManeger {

	private static Connection conn = null;

	@SuppressWarnings("finally")
	public Connection getConnection() {
			try {
			// JDBCドライバクラスのロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connectionの作成
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + ConnectionStrings.SERVER_NAME.getValue() + ":1521:"
							+ ConnectionStrings.SID.getValue(),
							ConnectionStrings.USER.getValue(), ConnectionStrings.PASS.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			return conn;

		}
	}
}
