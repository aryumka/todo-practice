package aryumka.todopractice.repository;

import aryumka.todopractice.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
