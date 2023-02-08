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
import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;


@RestController
@RequestMapping("/api/v1/")
public class TeacherController {
	@Autowired
	private TeacherRepository teacherRepository;
	
	// get all Teacher
		@GetMapping("/teachers")
		public List<Teacher> getAllTeachers(){
			return teacherRepository.findAll();
		}	
		
	//create Teacher rest API
		@PostMapping("/teachers")
		public Teacher createTeacher(@RequestBody Teacher teacher) {
			return teacherRepository.save(teacher);
		}
		
		// get Teacher by id rest API
		@GetMapping("/teachers/{id}")
		public ResponseEntity<Teacher> getTeacherById(@PathVariable int id) {
			Teacher teacher = teacherRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id :" + id));
			return ResponseEntity.ok(teacher);
		}
		
}