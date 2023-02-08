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
import com.example.demo.model.Section;
import com.example.demo.repository.SectionRepository;


@RestController
@RequestMapping("/api/v1/")
public class SectionController {
	@Autowired
	private SectionRepository sectionRepository;
	
	// get all Section
		@GetMapping("/sections")
		public List<Section> getAllSections(){
			return sectionRepository.findAll();
		}	
		
	//create Section rest API
		@PostMapping("/sections")
		public Section createSection(@RequestBody Section section) {
			return sectionRepository.save(section);
		}
		
		// get Section by id rest API
		@GetMapping("/sections/{id}")
		public ResponseEntity<Section> getSectionById(@PathVariable int id) {
			Section section = sectionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Section not exist with id :" + id));
			return ResponseEntity.ok(section);
		}	
}

