package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:09
*/
public interface StandService {
	public List<Stand> getStandList();
	public boolean addStand(Stand stand);
	public boolean deleteStandById(long id);
	public Stand getStandById(long id);
	public boolean updateStand(Stand stand);
}
