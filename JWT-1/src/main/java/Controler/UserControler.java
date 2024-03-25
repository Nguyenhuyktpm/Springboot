package Controler;

import org.springframework.web.bind.annotation.RestController;

import DTO.Request.UserCreateRequest;
import Entity.UserEntity;
import Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class UserControler {
	private final UserService userService;
	
	@PostMapping("/users")
	public UserEntity createUser(@RequestBody UserCreateRequest request) {
		
		
		return userService.createRequest(request);
	}
	
}
