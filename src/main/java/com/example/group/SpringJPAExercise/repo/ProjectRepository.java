package com.example.group.SpringJPAExercise.repo;

import com.example.group.SpringJPAExercise.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
