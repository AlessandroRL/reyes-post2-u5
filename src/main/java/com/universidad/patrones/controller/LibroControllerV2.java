package com.universidad.patrones.controller;

import com.universidad.patrones.dto.LibroRequestDTO;
import com.universidad.patrones.dto.LibroResponseDTO;
import com.universidad.patrones.mapper.LibroMapper;
import com.universidad.patrones.model.Libro;
import com.universidad.patrones.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/libros")
@Tag(name = "Libros", description = "API para gestion de libros")
public class LibroControllerV2 {
    private final LibroService service;
    private final LibroMapper mapper;

    public LibroControllerV2(LibroService service, LibroMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Listar libros")
    public List<LibroResponseDTO> listar() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar libro por id")
    public LibroResponseDTO buscarPorId(@PathVariable Long id) {
        Libro libro = service.findById(id).orElseThrow(() -> new NoSuchElementException("Libro no encontrado: " + id));
        return mapper.toResponse(libro);
    }

    @PostMapping
    @Operation(summary = "Crear libro")
    public ResponseEntity<LibroResponseDTO> crear(@Valid @RequestBody LibroRequestDTO request) {
        Libro creado = service.save(mapper.toEntity(request));
        LibroResponseDTO response = mapper.toResponse(creado);
        return ResponseEntity.created(URI.create("/api/v2/libros/" + creado.getId())).body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar libro por id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
