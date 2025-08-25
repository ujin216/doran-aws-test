package com.example.doranawstest.service;

import com.example.doranawstest.controller.dto.BoardResponse;
import com.example.doranawstest.domain.Board;
import com.example.doranawstest.domain.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void create(String title, String content) {
        Board board = new Board(title, content);
        boardRepository.save(board);
    }

    @Cacheable(cacheNames = "board", key = "#id")
    public BoardResponse getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }
}
