package businesslogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadCsv {
	public void readUserCsv() throws Exception {
		try {
			File csv = new File("C:\\TMP\\USER.csv"); // CSVデータファイル

			BufferedReader br = new BufferedReader(new FileReader(csv));

			InsertOracle insertOracle = new InsertOracle();

			// 最終行まで読み込む
			String line = "";
			while ((line = br.readLine()) != null) {
				// 1行をデータの要素に分割
				StringTokenizer st = new StringTokenizer(line, ",");
				String userID = "";
				String userName = "";
				String password = "";
				int age = 0;
				String orgCd = "";

				while (st.hasMoreTokens()) {
					// 1行の各要素をタブ区切りで表示
					userID = st.nextToken();
					userName = st.nextToken();
					password = st.nextToken();
					age = Integer.parseInt(st.nextToken());
					orgCd = st.nextToken();
				}

				insertOracle.insertUserTable("INSERT INTO T_USER values(?, ?, ?, ?, ?)", userID,
						userName, password, age, orgCd);
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
