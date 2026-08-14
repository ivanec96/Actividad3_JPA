# 🏢 Sistema de Gestión y Cálculo de Costes de Proyectos (JPA)

Este repositorio contiene el backend de una aplicación Java desarrollada para gestionar y calcular el coste real de proyectos empresariales. El sistema integra la asignación de personal (horas trabajadas) y el uso de materiales (cantidades de productos) para generar informes de facturación dinámicos.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java
* **Persistencia:** EclipseLink/JPA (Java Persistence API) 
* **Base de Datos:** MySQL
* **Arquitectura:** Patrón DAO (Data Access Object)

## 🏗️ Arquitectura y Diseño de Datos

El núcleo técnico de este proyecto radica en el mapeo de relaciones complejas en bases de datos relacionales utilizando entidades de JPA.

* **Patrón DAO:** Separación estricta de la lógica de negocio y el acceso a datos mediante interfaces y clases de implementación (`ProyectoDao`, `EmpleadoDao`, etc.), gestionando el ciclo de vida del `EntityManager` de forma manual.
* **Entidades Intermedias con Atributos Extra:** Resolución de relaciones muchos-a-muchos (`@ManyToMany`) complejas mediante el mapeo de tablas intermedias como entidades propias (`@Entity`):
  * `ProyectoConEmpleado`: Registra de forma individualizada las **horas** que un empleado dedica a un proyecto específico.
  * `ProyectoConProductos`: Controla el inventario y la **cantidad** exacta de unidades de un producto asignadas a un proyecto.

## 💡 Lógica de Negocio Destacada

El sistema va más allá de un simple CRUD (Crear, Leer, Actualizar, Borrar), implementando lógica financiera en tiempo de ejecución:

1. **Cálculo de Mano de Obra:** Extracción de la tasa estándar del perfil de cada empleado multiplicada por las horas específicas extraídas de la tabla intermedia para obtener el importe repercutido.
2. **Cálculo de Materiales:** Cruce de la cantidad utilizada de cada producto por su precio unitario en catálogo.
3. **Actualización de Costes Reales:** Suma automatizada de gastos (empleados + productos) para contrastarlos con el presupuesto de venta previsto y persistir el coste real finalizado en la base de datos mediante transacciones JPA (`merge` / `update`).

## 🚀 Cómo ejecutar este proyecto

1. Clona este repositorio en tu entorno local.
2. Configura las credenciales de tu base de datos en el archivo `src/META-INF/persistence.xml`.
3. *(Opcional)* Ejecuta los scripts SQL adjuntos para generar el esquema inicial y los datos de prueba.
4. Ejecuta la clase principal (`ImprimirGastos.java` o el nombre de tu `main`) para visualizar por consola el informe detallado de costes.

---
**Autor:**
Iván Escorza Cabrera
