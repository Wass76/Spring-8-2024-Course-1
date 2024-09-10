package com.SpringCourse.Startup;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotBlank(message = "first name must not be blank")
//    @Length(max = 10,min=2)
    @Size(message = "should be between 2 and 10 chars"  ,max = 10, min = 2)
    private String firstName;
    @NotBlank(message = "last name must not be null")
    private String lastName;
    @NotNull(message = "birthday must not be null")
    private LocalDate birthday;
}
