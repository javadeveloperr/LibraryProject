package org.example.dto;
import lombok.*;
import org.example.Enums.Status;
import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student_book")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    @Column(name = "created_date")
    private LocalDate createdDate;
    private Status status;
    @Column(name = "returned_date")
    private LocalDate returnedDate;
    private Duration duration;
}
