package aryumka.todopractice.service;

import aryumka.todopractice.domain.Board;
import aryumka.todopractice.domain.Task;
import aryumka.todopractice.domain.TaskStatus;
import aryumka.todopractice.repository.BoardRepository;
import aryumka.todopractice.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;

    public Task createTask(
        String title,
        String content,
        Long boardId
    ) {
        Board board = boardRepository.findById(boardId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        Task task = Task.create(title, content, board);
        return taskRepository.save(task);
    }

    public void updateTask(
        Long taskId,
        String title,
        String content,
        Board board
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        task.update(title, content, board);
    }

    public void deleteTask(
        Long taskId
    ) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        task.delete();
    }
}
