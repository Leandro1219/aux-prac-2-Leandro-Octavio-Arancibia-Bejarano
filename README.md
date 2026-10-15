# Práctica 2 - API REST de Libros

API REST con Spring Boot para gestionar libros (CRUD en memoria, sin base de datos).

## Requisitos
- Java 21

## Ejecución
    gradlew.bat bootRun      (Windows)
    ./gradlew bootRun        (Linux/Mac)

## Endpoints
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/books | Registrar un libro |
| GET | /api/books | Obtener todos los libros |
| GET | /api/books/{id} | Obtener un libro por ID |
| PUT | /api/books/{id} | Actualizar un libro |
| DELETE | /api/books/{id} | Eliminar un libro |

## Swagger
Con la aplicación en ejecución, abrir:
http://localhost:8080/swagger-ui/index.html