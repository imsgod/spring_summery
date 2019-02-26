package com.example.spring02.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dao.MemberDAO;
import com.example.spring02.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;
	
	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		boolean result = memberDao.loginCheck(dto);
		
		if(result) {
			 MemberDTO dto2 = viewMember(dto.getUserid());
			 session.setAttribute("userid", dto.getUserid());
			 session.setAttribute("name", dto2.getName());
		}  
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();

	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

}
