# Documentación de Endpoints REST

Este documento describe los endpoints expuestos por los controllers del backend y cómo consumirlos desde el frontend.

---

## AssignmentController
**Base URL:** `/api/assignments`

### GET `/api/assignments`
Obtiene todas las asignaciones.
```js
fetch('/api/assignments').then(r => r.json())
```

### GET `/api/assignments/{id}`
Obtiene una asignación por ID.
```js
fetch('/api/assignments/1').then(r => r.json())
```

### POST `/api/assignments`
Crea una nueva asignación.
```js
fetch('/api/assignments', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ /* datos */ })
})
```

### PUT `/api/assignments/{id}`
Actualiza una asignación existente.
```js
fetch('/api/assignments/1', {
  method: 'PUT',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ /* datos */ })
})
```

### DELETE `/api/assignments/{id}`
Elimina una asignación por ID.
```js
fetch('/api/assignments/1', { method: 'DELETE' })
```

---

## GameController
**Base URL:** `/api/games`

### GET `/api/games`
Obtiene todos los juegos.

### GET `/api/games/{id}`
Obtiene un juego por ID.

### POST `/api/games`
Crea un nuevo juego.

### PUT `/api/games/{id}`
Actualiza un juego existente.

### DELETE `/api/games/{id}`
Elimina un juego por ID.

**Ejemplo frontend:**
```js
fetch('/api/games', { method: 'GET' }).then(r => r.json())
```

---

## ParticipantController
**Base URL:** `/api/participants`

### GET `/api/participants`
Obtiene todos los participantes.

### GET `/api/participants/{id}`
Obtiene un participante por ID.

### POST `/api/participants`
Crea un nuevo participante.

### PUT `/api/participants/{id}`
Actualiza un participante existente.

### DELETE `/api/participants/{id}`
Elimina un participante por ID.

**Ejemplo frontend:**
```js
fetch('/api/participants', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ name: 'Juan', email: 'juan@ejemplo.com' })
})
```

---

## Notas para el Frontend
- Para métodos `POST` y `PUT`, enviar el cuerpo en formato JSON y el header `Content-Type: application/json`.
- Los endpoints de eliminación (`DELETE`) no devuelven contenido.
- Manejar respuestas 404 para recursos no encontrados.

---

Para detalles de los modelos (`Assignment`, `Game`, `Participant`), revisar las entidades en el backend.