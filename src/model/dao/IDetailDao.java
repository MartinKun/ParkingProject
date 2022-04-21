package model.dao;

import model.dto.Detail;

public interface IDetailDao {
	
	Detail insertDetail(Detail detail);
	
	Detail findDetailById(int id);
	
	boolean updateDetail(Detail detail);
	
	boolean deleteDetail(Detail detail);

}
