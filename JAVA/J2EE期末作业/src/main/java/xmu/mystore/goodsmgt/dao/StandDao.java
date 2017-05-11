package xmu.mystore.goodsmgt.dao;

import java.util.List;

import xmu.mystore.goodsmgt.model.Stand;



public interface StandDao {
	public List<Stand> getStandList();
	public boolean addStand(Stand stand);
	public boolean deleteStandById(long id);
	public Stand getStandById(long id);
	public boolean updateStand(Stand stand);
}
