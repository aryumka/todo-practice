package aryumka.todopractice.service;

import aryumka.todopractice.domain.Board;
import aryumka.todopractice.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board create(String title) {
        Board board = Board.create(title);
        return boardRepository.save(board);
    }

    public void update(Long boardId, String title) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        board.updateTitle(title);
    }

    public void delete(Long boardId) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        boardRepository.delete(board);
    }
}
