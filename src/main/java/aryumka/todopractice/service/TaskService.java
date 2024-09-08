package aryumka.todopractice.service;

import aryumka.todopractice.domain.Board;
import aryumka.todopractice.domain.Task;
import aryumka.todopractice.repository.BoardRepository;
import aryumka.todopractice.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;

    public Task create(
        String title,
        String content,
        Long boardId
    ) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        Task task = Task.create(title, content, board);
        return taskRepository.save(task);
    }

    public void update(
        Long taskId,
        String title,
        String content
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        task.updateContent(title, content);
    }

    public void move(
        Long taskId,
        Long boardId
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        task.move(board);
    }

    public void complete(
        Long taskId
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        task.complete();
    }

    public void delete(
        Long taskId
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        task.delete();
    }
}
