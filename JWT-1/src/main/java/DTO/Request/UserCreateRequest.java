package DTO.Request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
	 private String username;
	 private String password;
	 private String lastName;
	 private String firstName;
	 private LocalDate dob;
}
