package businessEntity.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import businessEntity.dto.T_USER;

public class SelectT_USER extends DaoConnectionManeger {
	private static final String selectAllSql = "select USER_ID, PASSWORD, USER_NAME, AGE, ORG_CD from T_USER";

	public static List<T_USER> selectT_USER() throws Exception {
		List<T_USER> getResult = new ArrayList<T_USER>();

		try {
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
		}

		return getResult;
	}
}
