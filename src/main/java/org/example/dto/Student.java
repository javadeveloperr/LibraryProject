package org.example.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate createdDate;
    private Boolean visible;
}
