package com.example.spacedemo;

import com.example.spacedemo.entity.User;
import com.example.spacedemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpecDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@BeforeEach
	void setUp() {
		userRepository.deleteAll();
	}

	@Test
	@DisplayName("Test saving a user")
	void testSaveUser() {
		User user = new User();
		user.setUsername("test_user");
		user.setEmail("test@example.com");
		user.setAge(27);

		User savedUser = userRepository.save(user);

		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedUser.getUsername()).isEqualTo("test_user");
	}

	@Test
	@DisplayName("Test finding users by username")
	void testFindByUsername() {
		User user = new User();
		user.setUsername("unique_user");
		user.setEmail("unique@example.com");
		user.setAge(29);
		userRepository.save(user);

		List<User> foundUsers = userRepository.findAll(
				(root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), "unique_user")
		);

		assertThat(foundUsers).hasSize(1);
		assertThat(foundUsers.get(0).getEmail()).isEqualTo("unique@example.com");
	}


}
