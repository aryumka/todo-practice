package aryumka.todopractice.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board {
  // 실제 칼럼 이름은 board_id
  @Id @GeneratedValue
  @Column(name = "board_id")
  private Long id;

  private String title;

  @OneToMany(mappedBy = "board")
  private List<Task> tasks;

  private boolean deleted;

  private Board(
    String title
  ) {
    this.title = title;
    this.deleted = false;
  }

  public static Board create(
    String title
  ) {
    return new Board(title);
  }

  public void addTask(
    Task task
  ) {
    this.tasks.add(task);
  }
}
