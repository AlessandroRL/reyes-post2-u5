package com.universidad.patrones.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {
    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio")
    private String isbn;

    @Min(value = 1800, message = "El anio de publicacion debe ser mayor o igual a 1800")
    @Max(value = 2100, message = "El anio de publicacion debe ser menor o igual a 2100")
    private Integer anioPublicacion;

    private String categoria;
}
