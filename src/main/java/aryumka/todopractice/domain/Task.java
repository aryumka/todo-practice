package aryumka.todopractice.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Task {
  @Id @GeneratedValue
  @Column(name = "task_id")
  private Long id;

  private String title;

  private String description;

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

  private TaskStatus status;

  private boolean deleted;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private LocalDateTime completedAt;

  private Task(
    String title,
    String description
  ) {
    this.title = title;
    this.description = description;
    this.status = TaskStatus.NOT_STARTED;
    this.deleted = false;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
    this.completedAt = null;
  }

  public static Task create(
    String title,
    String description
  ) {
    return new Task(title, description);
  }

  public void update(
    String title,
    String description
  ) {
    this.title = title;
    this.description = description;
    this.updatedAt = LocalDateTime.now();
  }

  public void start() {
    this.status = TaskStatus.IN_PROGRESS;
  }

  public void complete() {
    this.status = TaskStatus.COMPLETED;
    this.completedAt = LocalDateTime.now();
  }

  public void delete() {
    this.deleted = true;
  }
}
