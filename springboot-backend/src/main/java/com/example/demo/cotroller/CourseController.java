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
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;


@RestController
@RequestMapping("/api/v1/")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	
	// get all Course
		@GetMapping("/courses")
		public List<Course> getAllCourses(){
			return courseRepository.findAll();
		}	
		
	//create Course rest API
		@PostMapping("/courses")
		public Course createCourse(@RequestBody Course course) {
			return courseRepository.save(course);
		}
		
		// get Course by id rest API
		@GetMapping("/courses/{id}")
		public ResponseEntity<Course> getCourseById(@PathVariable int id) {
			Course course = courseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
			return ResponseEntity.ok(course);
		}
		
}