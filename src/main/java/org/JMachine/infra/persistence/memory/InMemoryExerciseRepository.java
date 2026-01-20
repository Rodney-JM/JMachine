package org.JMachine.infra.persistence.memory;

import org.JMachine.domain.model.exercise.Exercise;
import org.JMachine.domain.repository.ExerciseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryExerciseRepository implements ExerciseRepository {
    private final HashMap<String, Exercise> exercises = new HashMap<>();

    @Override
    public void save(Exercise exercise) {
        exercises.put(exercise.getId(), exercise);
    }

    @Override
    public Optional<Exercise> findById(String id) {
        return Optional.ofNullable(exercises.get(id));
    }

    @Override
    public Optional<Exercise> findByTitle(String title) {
        return exercises.values().stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst();
    }

    @Override
    public List<Exercise> findAll() {
        return new ArrayList<>(exercises.values());
    }

    @Override
    public void deleteById(String id) {
        exercises.remove(id);
    }

    @Override
    public void deleteByTitle(String title) {
        Optional<Exercise> exercise =  Optional.ofNullable(exercises.values().stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Estudante não encontrado")));

        exercises.remove(exercise.get().getId());
    }
}
