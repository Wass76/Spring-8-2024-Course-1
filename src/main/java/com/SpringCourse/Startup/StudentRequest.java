package com.SpringCourse.Startup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotBlank(message = "first name must not be blank")
    @Length(max = 10,min=2)
    private String firstName;
    @NotNull(message = "last name must not be null")
    private String lastName;
    @NotNull(message = "birthday must not be null")
    private LocalDate birthday;
}
