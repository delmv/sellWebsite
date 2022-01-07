package com.spring.henallux.transpLux;

import com.spring.henallux.transpLux.dataAccess.dao.ProductAccessDAO;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.dataAccess.entity.ProductEntity;
import com.spring.henallux.transpLux.dataAccess.entity.UserEntity;
import com.spring.henallux.transpLux.dataAccess.repository.ProductRepository;
import com.spring.henallux.transpLux.dataAccess.repository.UserRepository;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TranspLuxApplicationTests {

	@Mock
	UserRepository userRepository;

	/*@Test
	void contextLoads() {
	}*/

	@Test
	public void testFindUserInDB() throws EmptyProductListException {
		UserEntity isaline = new UserEntity();
		isaline.setEmail("manager@outlook.com");
		isaline.setFirstName("Isaline");
		isaline.setLastName("Didier");
		isaline.setMale(false);
		isaline.setCity("Sensenruth");
		isaline.setCountry("Uzbekistan");
		isaline.setPassword("$2a$10$63k3PJULkVlHYW7WrNLXXOENchLrFJQpJQm1dRbo4omm49GFrraRa");
		isaline.setAddress("Rue des Minières 6");
		isaline.setZipCode(6832);
		isaline.setPhone("473507157");
		isaline.setUsername("isaline");
		isaline.setAuthorities("ROLE_USER");
		isaline.setNonExpired(true);
		isaline.setNonLocked(true);
		isaline.setCredentialsNonExpired(true);
		isaline.setEnabled(true);

		when(userRepository.findByUsername("isaline")).thenReturn(isaline);
	}

	@Test
	public void findUnknownUserInDB() {
		when(userRepository.findByUsername("unknown")).thenReturn(null);
	}
}
