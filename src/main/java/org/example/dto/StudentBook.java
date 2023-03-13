package org.example.dto;

import lombok.*;
import org.example.Enums.Status;

import java.time.Duration;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentBook {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDate createdDate;
    private Status status;
    private LocalDate returnedDate;
    private Duration duration;
}
