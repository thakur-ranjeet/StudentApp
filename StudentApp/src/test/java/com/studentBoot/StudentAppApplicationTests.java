package com.studentBoot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.studentBoot.entity.Student;
import com.studentBoot.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentAppApplicationTests {
	
	@Autowired
	private StudentRepository repository;
	
	
	@Test
	void studentEmailExists() {
		String studentEmail = "ranjeet@gmail.com";
		
		
		//underTest.save(student);
		boolean expected = repository.studentEmailExists(studentEmail);
		assertThat(expected).isTrue();
		
		
		
	}

}
