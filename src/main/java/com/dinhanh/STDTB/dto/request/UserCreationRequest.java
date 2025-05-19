package com.dinhanh.STDTB.dto.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
     String Id;
    @Size(min = 8, message ="USERNAME_INVALID")
     String username;

    @Size(min = 3, message ="INVALID_PASSWORD")
     String password;
     String firstName;
     String lastName;
     LocalDate dob;


}
