# 📦 SIGEP – Sistema de Gestión de Pedidos Empresariales

Sistema web para registrar, controlar y dar seguimiento a los pedidos de una empresa. Reemplaza el manejo manual (hojas de cálculo y procesos en papel) por una aplicación centralizada que reduce errores y mejora el control de la información.

Proyecto del curso **Desarrollo de Aplicaciones Web I** (ciclo V), **Cibertec – Lima Centro**, 2026. Desarrollado en equipo.

## ¿Qué hace el sistema?

- **Autenticación segura:** inicio de sesión con credenciales y contraseñas cifradas con **BCrypt**.
- **Gestión de roles de usuario:** el acceso a las funciones depende del rol de cada usuario.
- **Mantenimiento (CRUD)** de:
  - Clientes
  - Productos
  - Usuarios
  - Pedidos
- **Registro de pedidos** con operaciones transaccionales.
- **Persistencia de datos** en una base de datos relacional MySQL.

## Tecnologías

| Parte | Tecnología |
|---|---|
| Backend (API REST) | **Java**, **Spring Boot**, Spring Security |
| Frontend | **Angular**, TypeScript |
| Base de datos | **MySQL**, MySQL Workbench |
| Seguridad | Cifrado de contraseñas con BCrypt |
| Herramientas | Spring Tool Suite 4, Visual Studio Code, Git y GitHub |

## Arquitectura

El frontend en Angular consume los servicios REST del backend en Spring Boot, y este se conecta a la base de datos MySQL:

```
Angular (sigep-frontend)  →  API REST Spring Boot (sigep-backend)  →  MySQL (database)
```

## Estructura del repositorio

```
├── README.md
├── sigep-backend/     → API REST (Spring Boot)
├── sigep-frontend/    → Aplicación web (Angular)
└── database/          → Script SQL de la base de datos
```

## Requisitos

- JDK compatible con el proyecto (Java)
- Spring Tool Suite 4 (o cualquier IDE para Spring Boot)
- Node.js y npm
- Angular CLI (`npm install -g @angular/cli`)
- Visual Studio Code
- MySQL Server y MySQL Workbench

## Cómo ejecutarlo

Sigue los pasos **en este orden**, porque cada parte depende de la anterior.

### 1. Cargar la base de datos (MySQL Workbench)

1. Abre MySQL Workbench y conéctate a tu servidor local.
2. Abre el script de la carpeta `database/`.
3. Ejecútalo completo (ícono del rayo) para crear la base de datos, las tablas y los datos de prueba.

### 2. Ejecutar el backend (Spring Tool Suite 4)

1. En Spring Tool Suite 4, elige **File → Import → Existing Maven Projects** (o **Gradle**, según tu proyecto) y selecciona la carpeta `sigep-backend`.
2. Abre `src/main/resources/application.properties` y configura la conexión a tu MySQL: URL de la base de datos, usuario y contraseña.
3. Haz clic derecho sobre el proyecto → **Run As → Spring Boot App**.
4. Cuando termine de arrancar, la API queda disponible en `http://localhost:8080` (o el puerto que hayas configurado).

### 3. Ejecutar el frontend (Visual Studio Code)

1. Abre la carpeta `sigep-frontend` en Visual Studio Code.
2. En la terminal, instala las dependencias:
   ```
   npm install
   ```
3. Inicia la aplicación:
   ```
   ng serve
   ```
4. Abre el navegador en `http://localhost:4200`.

Si cambiaste el puerto del backend, actualiza la dirección de la API en los archivos de `src/environments/` del frontend.

### 4. Probar el sistema

1. Inicia sesión con un usuario de prueba del script SQL.
2. Registra clientes y productos.
3. Crea un pedido y revisa que se guarde correctamente.

## Notas

- Las contraseñas y datos de conexión del repositorio son de ejemplo. Cámbialos por los de tu entorno antes de ejecutar.
- Los datos del script SQL son solo de prueba.

## Autor

**Diego Enrique Aite Velasquez** – Técnico en Computación e Informática, Cibertec.
LinkedIn: _(https://www.linkedin.com/in/diego-enrique-aite-velasquez-169555441/)_
