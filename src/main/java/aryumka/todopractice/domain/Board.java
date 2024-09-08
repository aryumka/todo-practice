package aryumka.todopractice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name="boards")
@Getter
@NoArgsConstructor
public class Board {
  @Id @GeneratedValue
  @Column(name = "board_id")
  private Long id;

  private String title;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
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

  //todo Task를 여기서 추가하는게 맞을까?
  public void addTask(
    Task task
  ) {
    this.tasks.add(task);
  }
}
