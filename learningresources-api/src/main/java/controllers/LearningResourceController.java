package controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.LearningResource;
import repository.LearningResourceRepository;

@RestController
public class LearningResourceController {

	@Autowired
	LearningResourceRepository repo;
	
	@GetMapping("/resources")
	public List<LearningResource> getresources()
	{
		return repo.findAll(); 
	}
	@PostMapping("/addResource")
	public void saveLearningResources(List<LearningResource> learningResources){
        for (LearningResource learningResource : learningResources)
            repo.save(learningResource);
    }
	@DeleteMapping(value = "/learningresource/{learningResourceId}")
    public void deleteLearningResource(@PathVariable int learningResourceId){
        repo.deleteLearningResourceById(learningResourceId);
    }
}
