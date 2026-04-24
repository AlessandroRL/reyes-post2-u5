package com.universidad.patrones.service;

import com.universidad.patrones.model.Libro;
import com.universidad.patrones.repository.LibroRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return repository.findById(id);
    }

    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Libro no encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
