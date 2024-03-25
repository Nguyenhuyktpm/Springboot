package Service.Impliments;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import DTO.Request.UserCreateRequest;
import Entity.UserEntity;
import Repository.UserRepository;
import Service.UserService;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
	private final UserRepository userRepository;
	@Override
	public UserEntity createRequest(UserCreateRequest request) {

		UserEntity user = UserEntity.builder()
				.username(request.getUsername())
				.password(request.getPassword())
				.lastName(request.getLastName())
				.firstName(request.getFirstName())
				.dob(request.getDob())
				.build();

		return userRepository.save(user);

	}
}
