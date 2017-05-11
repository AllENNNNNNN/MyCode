package xmu.mystore.goodsmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.dao.StandDao;
import xmu.mystore.goodsmgt.model.Stand;
@Transactional
@Service
public class StandServiceImp implements StandService{

	@Autowired
	private StandDao standDao;
	public List<Stand> getStandList() {
		// TODO Auto-generated method stub
		return this.standDao.getStandList();
	}

	public boolean addStand(Stand stand) {
		// TODO Auto-generated method stub
		return this.standDao.addStand(stand);
	}

	public boolean deleteStandById(long id) {
		// TODO Auto-generated method stub
		return this.standDao.deleteStandById(id);
	}

	public Stand getStandById(long id) {
		// TODO Auto-generated method stub
		return this.standDao.getStandById(id);
	}

	public boolean updateStand(Stand stand) {
		// TODO Auto-generated method stub
		return this.standDao.updateStand(stand);
	}

}
