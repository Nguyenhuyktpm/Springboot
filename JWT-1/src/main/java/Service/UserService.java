package Service;

import org.springframework.stereotype.Service;

import DTO.Request.UserCreateRequest;
import Entity.UserEntity;



public interface UserService {

	UserEntity createRequest(UserCreateRequest request);

}
