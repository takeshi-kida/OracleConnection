package applicationLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import businesslogic.DriverManeger;
import businesslogic.ReadCsv;

public class StartConnection {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;

		DriverManeger dm = new DriverManeger();

		try {

			ReadCsv rs = new ReadCsv();

			rs.readUserCsv();

			conn = dm.getConnection();
			// Statementの作成
			Statement stmt = conn.createStatement();

			// Resultsetの作成
			ResultSet rset = stmt.executeQuery("select USER_NAME from T_USER");
			// 取得したデータを出力する
			while (rset.next()) {
				System.out.println(rset.getString("USER_NAME"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
		}
	}

}
