package com.example.spring02.service.message;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.message.dao.MessageDAO;
import com.example.spring02.model.message.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {

	 @Inject
	 MessageDAO messageDAo;

	@Override
	public void addMessage(MessageDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
