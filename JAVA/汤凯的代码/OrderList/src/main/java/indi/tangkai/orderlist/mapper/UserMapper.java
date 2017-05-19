package indi.tangkai.orderlist.mapper;

import org.springframework.stereotype.Repository;

import indi.tangkai.orderlist.data.entity.User;

@Repository
public interface UserMapper {
	
	public User getUserByUserId(long user_id);
	
}
