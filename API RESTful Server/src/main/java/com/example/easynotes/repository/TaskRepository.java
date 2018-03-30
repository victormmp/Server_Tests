package com.example.easynotes.repository;

import com.example.easynotes.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@EnableJpaRepositories(basePackages="com.example.easynotes.repository", entityManagerFactoryRef="emf")

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
