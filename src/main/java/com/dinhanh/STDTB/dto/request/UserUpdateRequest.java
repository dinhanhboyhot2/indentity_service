package com.dinhanh.STDTB.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    private String Id;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
