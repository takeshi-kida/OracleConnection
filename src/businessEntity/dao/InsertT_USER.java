package businessEntity.dao;

import businessEntity.dto.T_USER;

public class InsertT_USER extends DaoConnectionManeger {

	private static final String insertSql = "INSERT INTO T_USER values(?, ?, ?, ?, ?)";

	public void insertUserTable(T_USER tUser) throws Exception {
		try {
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
		}
	}
}