# Laboratorio: API REST con DTOs y Swagger - Alessandro Reyes
**Universidad Francisco de Paula Santander** **Ingeniería de Sistemas - 2026**

## Arquitectura
El proyecto utiliza una arquitectura en capas:
- **Controller**: Maneja los endpoints y la documentación Swagger.
- **DTO**: Define el contrato público, separando el modelo del cliente.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Maneja la persistencia con JPA.
- **Mapper**: Realiza la conversión entre Entidades y DTOs.

## Cómo Ejecutar
1. Clonar el repositorio.
2. Ejecutar ./mvnw spring-boot:run.
3. Acceder a Swagger en: http://localhost:8080/swagger-ui.html.

## Dependencias Principales
- Spring Boot Starter Web & Data JPA
- Validation (Jakarta Validation)
- SpringDoc OpenAPI (Swagger)
- Lombok

## Evidencia de Funcionamiento

### 1. Documentación Swagger UI
![Swagger UI](docs/swagger.png)  
*Se visualizan los endpoints de /api/v2/libros.*

### 2. Validación de Datos (Error 400)
![Validacion 400](docs/error_400.png)  
*Respuesta JSON al enviar campos obligatorios vacíos.*

### 3. Recurso No Encontrado (Error 404)
![Not Found 404](docs/error_404.png)  
*Respuesta JSON al buscar un ID inexistente.*