# E-commerce API - TechLab

API RESTful desarrollada con **Spring Boot, JPA y MySQL** para la gestión integral de un e-commerce.
## Configuración
La aplicación se ejecuta en el puerto **8080**.

## Endpoints Disponibles
Puedes acceder a la aplicación a través de la siguiente URL:

* **Página principal:** `http://localhost:8080/prueba.html`


* **Listar productos:** `GET http://localhost:8080/productos`
##  Funcionalidades Principales
* **Gestión de Catálogo:** Operaciones CRUD para productos y categorías.
* **Gestión de Stock:** Descuento automático de stock al realizar una compra.
* **Carrito de Compras:** Soporte para múltiples productos mediante relaciones `@ManyToMany`.
* **Validaciones y Errores:** Manejo centralizado de excepciones con `@RestControllerAdvice`.
* **Configuración CORS:** Habilitada para comunicación fluida con el Frontend.

##  Instrucciones de Ejecución
1. **Requisitos:** Tener instalado Java JDK 17+, Maven y MySQL Server.
2. **Configuración:**
   - Crear una base de datos llamada `ecommerce` en MySQL o Se proporciona un sq de ejemplo con la base usada en resources data.sql
   - Configurar  credenciales en `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     spring.jpa.hibernate.ddl-auto=update
     ```
3. **Ejecución:** En la terminal, dentro de la carpeta raíz del proyecto, ejecutar:
   ```bash
   ./mvnw spring-boot:run