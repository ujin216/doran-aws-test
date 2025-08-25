package com.example.doranawstest.controller;

import com.example.doranawstest.controller.dto.BoardResponse;
import com.example.doranawstest.controller.dto.CreateBoardRequest;
import com.example.doranawstest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Void> creat(
            @RequestBody CreateBoardRequest createBoardRequest
    ) {
        boardService.create(
                createBoardRequest.getTitle(), createBoardRequest.getContent()
        );
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoardById(@PathVariable("id") Long id) {
        BoardResponse boardResponse = boardService.getBoardById(id);

        return ResponseEntity.ok().body(boardResponse);
    }
}
