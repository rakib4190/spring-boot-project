package com.example.demo.cotroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	// get all Student
		@GetMapping("/students")
		public List<Student> getAllStudents(){
			return studentRepository.findAll();
		}	
		
	//create Student rest API
		@PostMapping("/students")
		public Student createStudent(@RequestBody Student student) {
			return studentRepository.save(student);
		}
		
		// get Student by id rest API
		@GetMapping("/students/{id}")
		public ResponseEntity<Student> getStudentById(@PathVariable int id) {
			Student student = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
			return ResponseEntity.ok(student);
		}
		
}