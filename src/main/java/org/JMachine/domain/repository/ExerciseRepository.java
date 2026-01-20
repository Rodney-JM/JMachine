package org.JMachine.domain.repository;

import org.JMachine.domain.model.exercise.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository {
    void save(Exercise exercise);
    Optional<Exercise> findById(String id);
    Optional<Exercise> findByTitle(String title);
    List<Exercise> findAll();
    void deleteById(String id);
    void deleteByTitle(String title);
}
