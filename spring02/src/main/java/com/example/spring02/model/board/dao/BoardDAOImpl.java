package com.example.spring02.model.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> listAll() throws Exception {
		return sqlSession.selectList("board.listAll");
	}
	
	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}
	
	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("board.addAttach", fullName);
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
	public void updateAttach(String fullName, int bno) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countArticle() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
 