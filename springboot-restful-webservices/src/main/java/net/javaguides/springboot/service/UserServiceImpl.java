package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
