 package com.example.spring02.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring02.model.board.dao.BoardDAO;
import com.example.spring02.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDao.listAll();
	}
	
	@Transactional
	@Override
	public void create(BoardDTO dto) throws Exception {
		// board 테이블 레코드 추가
		boardDao.create(dto);
		
		// attach 테이블 레코드 추가
		String[] files = dto.getFiles();
		
		if (files == null ) return;
		
		for (String name : files) {
			boardDao.addAttach(name);
		}
	}
	
	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public BoardDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void increaseViewcnt() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countArticle() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
 