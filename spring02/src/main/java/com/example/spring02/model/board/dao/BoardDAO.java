 package com.example.spring02.model.board.dao;

import java.util.List;

import com.example.spring02.model.board.dto.BoardDTO;

public interface BoardDAO {
	public void deleteFile(String fullName);
	public List<String> getAttach(int bno);
	public void addAttach(String fullName);
	public void updateAttach(String fullName, int bno);
	public void create(BoardDTO dto) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardDTO> listAll() throws Exception;
	public void increaseViewcnt(int bno) throws Exception;
	public int countArticle() throws Exception;
}
 