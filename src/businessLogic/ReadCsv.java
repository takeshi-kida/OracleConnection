package businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import dto.T_USER;

public class ReadCsv {
	public void readUserCsv(String fleName) throws Exception {
		try {
			File csv = new File(fleName); // CSVデータファイル

			BufferedReader br = new BufferedReader(new FileReader(csv));

			InsertOracle insertOracle = new InsertOracle();

			// 最終行まで読み込む
			String line = "";
			while ((line = br.readLine()) != null) {
				// 1行をデータの要素に分割
				StringTokenizer st = new StringTokenizer(line, ",");
				T_USER tUser = new T_USER();

				while (st.hasMoreTokens()) {
					tUser = new T_USER();
					// 1行の各要素をタブ区切りで表示
					tUser.USER_ID = st.nextToken();
					tUser.PASSWORD = st.nextToken();
					tUser.USER_NAME = st.nextToken();
					tUser.AGE = Integer.parseInt(st.nextToken());
					tUser.ORG_CD = st.nextToken();
				}

				insertOracle.insertUserTable("INSERT INTO T_USER values(?, ?, ?, ?, ?)", tUser);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// Fileオブジェクト生成時の例外捕捉
			e.printStackTrace();
		} catch (IOException e) {
			// BufferedReaderオブジェクトのクローズ時の例外捕捉
			e.printStackTrace();
		}
	}
}
