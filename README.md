# 📇 API REST de Gestión de Contactos

API REST desarrollada con Spring Boot para la gestión de contactos. Permite crear, leer, actualizar y eliminar contactos, así como buscar por teléfono, email y categoría.

## 🎥 Video de Demostración

### [>Ver video de la API< - ClickMe](https://www.youtube.com/watch?v=Ndm5VsOBNBY)

## 🚀 Características

- ✅ CRUD completo de contactos
- 🔍 Búsqueda de contactos por teléfono
- 🔍 Búsqueda de contactos por email
- 🏷️ Filtrado por categoría (familia, trabajo, amigos)
- 💾 Persistencia de datos con MySQL
- 🌐 CORS habilitado para integración con frontend
- 📝 Validación de datos con JPA

## 🛠️ Tecnologías Utilizadas

- **Java** 21
- **Spring Boot** 4.0.0
- **Spring Data JPA** - Para acceso a datos
- **MySQL** - Base de datos relacional
- **Lombok** - Para reducir código boilerplate
- **Maven** - Gestión de dependencias

## 📁 Estructura del Proyecto

```
ProyectoFinalSpringboot/
├── src/
│   ├── main/
│   │   ├── java/com/osvaldx/demo/
│   │   │   ├── Contact/
│   │   │   │   ├── controller/      # Controladores REST
│   │   │   │   ├── model/           # Entidades JPA
│   │   │   │   ├── repository/      # Repositorios de datos
│   │   │   │   ├── service/         # Lógica de negocio
│   │   │   │   └── enums/           # Enumeraciones
│   │   │   └── ProyectofinalBaApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 📡 Endpoints de la API

Base URL: `http://localhost:8080/api/contacts`

### Obtener todos los contactos

```http
GET /api/contacts
```

**Respuesta:** Lista de todos los contactos

### Buscar contacto por teléfono

```http
GET /api/contacts?phone={numero}
```

**Parámetros:**
- `phone` (query param): Número de teléfono a buscar

**Respuesta:** Contacto encontrado o 404 si no existe

### Buscar contacto por email

```http
GET /api/contacts?email={email}
```

**Parámetros:**
- `email` (query param): Email a buscar

**Respuesta:** Contacto encontrado o 404 si no existe

### Buscar contactos por categoría

```http
GET /api/contacts?category={categoria}
```

**Parámetros:**
- `category` (query param): Categoría (`family`, `work`, `friends`)

**Respuesta:** Lista de contactos de la categoría especificada

### Crear un nuevo contacto

```http
POST /api/contacts
Content-Type: application/json
```

**Body de ejemplo:**
```json
{
  "firstname": "Juan",
  "lastname": "Pérez",
  "email": "juan.perez@example.com",
  "phone": "+1234567890",
  "category": "work"
}
```

**Respuesta:** 201 Created con el contacto creado

### Actualizar un contacto

```http
PUT /api/contacts/{id}
Content-Type: application/json
```

**Parámetros:**
- `id` (path param): ID del contacto a actualizar

**Body de ejemplo:**
```json
{
  "firstname": "Juan",
  "lastname": "Pérez García",
  "email": "juan.perez@example.com",
  "phone": "+1234567890",
  "category": "work"
}
```

**Respuesta:** 200 OK con el contacto actualizado o 404 si no existe

### Eliminar un contacto

```http
DELETE /api/contacts/{id}
```

**Parámetros:**
- `id` (path param): ID del contacto a eliminar

**Respuesta:** 204 No Content o 404 si no existe

## 📝 Modelo de Datos

### Contact

```java
{
  "id": Long,              // Autogenerado
  "firstname": String,     // Nombre (requerido)
  "lastname": String,      // Apellido (opcional)
  "email": String,         // Email (requerido)
  "phone": String,         // Teléfono (requerido)
  "category": ContactCategory  // Categoría: family, work, friends
}
```

### ContactCategory (Enum)

- `family` - Familia
- `work` - Trabajo
- `friends` - Amigos

## 🔧 Ejemplos de Uso con cURL

### Obtener todos los contactos

```bash
curl -X GET http://localhost:8080/api/contacts
```

### Buscar contacto por teléfono

```bash
curl -X GET "http://localhost:8080/api/contacts?phone=+1234567890"
```

### Buscar contacto por email

```bash
curl -X GET "http://localhost:8080/api/contacts?email=juan.perez@example.com"
```

### Buscar contactos por categoría

```bash
curl -X GET "http://localhost:8080/api/contacts?category=work"
```

### Crear un contacto

```bash
curl -X POST http://localhost:8080/api/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "firstname": "María",
    "lastname": "González",
    "email": "maria.gonzalez@example.com",
    "phone": "+9876543210",
    "category": "friends"
  }'
```

### Actualizar un contacto

```bash
curl -X PUT http://localhost:8080/api/contacts/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstname": "María",
    "lastname": "González López",
    "email": "maria.gonzalez@example.com",
    "phone": "+9876543210",
    "category": "friends"
  }'
```

### Eliminar un contacto

```bash
curl -X DELETE http://localhost:8080/api/contacts/1
```