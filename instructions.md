# Instructions for Backend Project Setup and Configuration

## Contexto General

Este proyecto corresponde únicamente al backend de la aplicación "Amigo Invisible". El objetivo es exponer una API REST utilizando Java y Spring Boot, que permita gestionar toda la lógica y datos del juego. La comunicación con el frontend será exclusivamente mediante JSON sobre HTTP.

---

## Requisitos Funcionales

### Gestión de Participantes
- Permitir agregar, editar y eliminar participantes.
- Cada participante debe tener: nombre y email.
- La fecha de cumpleaños es opcional y solo necesaria si se selecciona el Modo Cumpleaños.

### Selección del Modo de Juego
- Permitir elegir entre:
  - Amigo Invisible Clásico
  - Modo Cumpleaños

### Generación de Asignaciones Aleatorias
- **Clásico:** Asignar aleatoriamente un participante a otro, evitando que una persona se asigne a sí misma.
- **Cumpleaños:** Asignar a cada participante el cumpleaños de otro, evitando que coincida con el propio y asegurando que todos tengan un organizador distinto.

### Notificación de Asignaciones
- Notificar a cada participante la información de su asignado de forma privada, mediante el email proporcionado.

### Configuración de Fecha de Entrega/Regalo
- En modo clásico, el organizador debe poder establecer una fecha única para la entrega de regalos.
- En modo cumpleaños, la fecha estará determinada por el cumpleaños del participante asignado.

### Gestión de Partidas
- Permitir guardar, consultar y eliminar partidas.
- Opcionalmente, evitar asignaciones repetidas en juegos futuros.

### Prevención de Asignaciones Inválidas
- Garantizar que un participante no se asigne a sí mismo.
- En modo clásico, opcionalmente evitar asignaciones circulares directas (A → B y B → A).
- En modo cumpleaños, evitar que un participante sea su propio organizador.

### Exportación e Impresión de Resultados
- El organizador debe poder exportar un listado con las asignaciones (visible solo para él) para respaldo o impresión.

### Interfaz de Administración (API)
- Exponer endpoints para que el organizador gestione participantes, seleccione el modo de juego y consulte los resultados.

### Seguridad y Privacidad
- Las asignaciones deben mantenerse ocultas para todos excepto el participante correspondiente.
- Los datos personales deben protegerse conforme a la normativa vigente.

---

## Requisitos No Funcionales

### Usabilidad
- La API debe ser clara y fácil de consumir por el frontend.

### Rendimiento
- El sistema debe procesar el sorteo en menos de 2 segundos para grupos de hasta 100 personas.
- Permitir la gestión fluida de múltiples grupos simultáneamente.

### Seguridad
- Los resultados del sorteo deben ser privados y accesibles solo por el usuario asignado.

### Mantenibilidad
- El sistema debe estar desarrollado siguiendo buenas prácticas de programación para facilitar su mantenimiento y evolución.

### Compatibilidad
- La API debe funcionar correctamente con los principales clientes HTTP y ser compatible con los navegadores modernos a través del frontend.

---

## Notas
- Este proyecto no incluye ninguna funcionalidad de frontend.
- Todos los endpoints deben estar documentados y seguir convenciones REST.
- La lógica de notificación por email debe ser segura y confiable.
- La privacidad y seguridad de los datos son prioritarias.

Para detalles adicionales, consultar los requerimientos o contactar al responsable del proyecto.
