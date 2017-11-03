package applicationLogic;

import businessEntity.dto.T_USER;
import businessLogic.GetData;
import businessLogic.ReadCsv;;

public class StartConnection {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		try {
			ReadCsv rs = new ReadCsv();

			rs.readUserCsv(args[0]);

			GetData gd = new GetData();

			// 取得したデータを出力する
			for (T_USER tUser : gd.getTUser()) {
				System.out.println(tUser.USER_NAME);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
