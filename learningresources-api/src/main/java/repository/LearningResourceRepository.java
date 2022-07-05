package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.LearningResource;

public interface LearningResourceRepository extends JpaRepository<LearningResource,Integer> {
	public void deleteLearningResourceById(int id);
}
