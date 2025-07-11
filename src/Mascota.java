package Historia;
//import java.util.ArrayList;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    // private ArrayList<Consulta> consultas; // original
    private Historial historial; // ✅ Refactor: delegar manejo de consultas a Historial

    public Mascota(String nombre, String especie, int edad) {
        /* Código original:
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.consultas = new ArrayList<>();
        */
        // ✅ Refactor: usar setters con validación y crear historial
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        this.historial = new Historial();
    }

    public void agregarConsulta(Consulta consulta) {
        // consultas.add(consulta); // original
        // ✅ Refactor: delegar a Historial
        historial.agregarConsulta(consulta);
    }

    public void mostrarHistorial() {
        System.out.println("📋 Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:");
        /* Código original:
        if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }
        */
        // ✅ Refactor: usar metodo de Historial
        historial.mostrarConsultas();
    }

    // Getters y setters con validación
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida.");
        }
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa.");
        }
        this.edad = edad;
    }
   }
