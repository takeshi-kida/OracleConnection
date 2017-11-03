package businessLogic;

import java.util.List;

import businessEntity.dao.SelectT_USER;
import businessEntity.dto.T_USER;

public class GetData {
	public List<T_USER> getTUser() throws Exception {
		return SelectT_USER.selectT_USER();
	}
}
