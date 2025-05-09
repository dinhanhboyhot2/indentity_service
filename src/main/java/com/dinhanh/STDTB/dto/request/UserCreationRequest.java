package com.dinhanh.STDTB.dto.request;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserCreationRequest {
    private long Id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

}
