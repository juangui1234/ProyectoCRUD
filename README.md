# 🐾 Sistema de Gestión Clínica Veterinaria

Este proyecto es una **aplicación de escritorio en Java** desarrollada con **Swing** y la arquitectura **orientada a objetos**, que permite registrar y gestionar mascotas, así como visualizar su historial de consultas veterinarias.

## 🧰 Tecnologías utilizadas

- 🟨 **Java** (JDK 17 o superior recomendado)
- 🖥️ **IntelliJ IDEA** como entorno de desarrollo
- 🎨 **Java Swing** para interfaz gráfica (GUI)
- 🗃️ **Estructuras de datos**: `ArrayList`, `JTable`, `JTree`, etc.

---

## 🧠 Funcionalidades principales

- **Registrar Pacientes (Mascotas)** con nombre, especie y edad.
- **Listar Pacientes** en una tabla con barra de progreso animada.
- **Buscar Mascotas** por nombre y visualizar su ficha.
- **Ver Servicios Veterinarios** disponibles desde un `JTree`.
- **Asociar Consultas** (estructura lista implementada).
- Gestión central a través de un `JDesktopPane` con ventanas internas (`JInternalFrame`).

---

## 🗂️ Estructura del proyecto

src/
├── Main.java
├── VentanaPrincipal.java
├── FormularioPaciente.java
├── ListaPacientes.java
├── PanelConsulta.java
├── CrudMascotas.java
├── Mascota.java
├── Consulta.java
├── Veterinario.java
├── Historial.java
├── Propietario.java
├── IDGenerator.java

yaml
Copiar
Editar

---

## 🏃‍♂️ Cómo ejecutar el proyecto

1. Abre el proyecto en **IntelliJ IDEA**.
2. Asegúrate de que el archivo `Main.java` tenga el método `main()` activo.
3. Ejecuta el proyecto desde `Main.java`.
4. Usa el menú de la aplicación para:
    - Registrar nuevos pacientes.
    - Visualizar la lista de pacientes.
    - Buscar información desde la vista de consultas.

---

## 📸 Capturas sugeridas (opcional)

Puedes agregar capturas de pantalla de:

- El formulario de pacientes.
- La tabla de pacientes con la barra de carga.
- El árbol de servicios en la vista de consulta.
- Ejemplo de búsqueda de mascota por nombre.

---

## ✨ Posibles mejoras futuras

- Registro de **consultas desde GUI**.
- Gestión de **propietarios** y vinculación con sus mascotas.
- Persistencia de datos con **archivos** o **base de datos**.
- Módulo de **autenticación de usuario**.

---

## 👨‍💻 Autor

**Juan Guillermo Salazar**  
Proyecto desarrollado como parte del curso de Lenguaje de Programación.  
Con asesoría y acompañamiento técnico paso a paso 🤝.

---

## ⚠️ Licencia

Este proyecto es de uso educativo y libre distribución para fines académicos.
