package indi.tangkai.orderlist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import indi.tangkai.orderlist.data.entity.User;
import indi.tangkai.orderlist.mapper.UserMapper;
import indi.tangkai.orderlist.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
	@Autowired (required=false) 
	private UserMapper userMapper;
	
	@Override
	public User getUserByUserId(long user_id) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(user_id);
	}

}
