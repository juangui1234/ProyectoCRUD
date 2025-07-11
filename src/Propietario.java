import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String documento;
    private String telefono;
    private ArrayList<Mascota> mascotas; // Relación 1:N original

    public Propietario(String nombre, String documento, String telefono) {
        /* Código original:
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
        */
        // ✅ Refactor: Usar setters con validaciones y lista inicializada
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    /**
     * Muestra los datos del propietario.
     */
    public void mostrarInformacion() {
        System.out.println("👤 Propietario: " + nombre);
        System.out.println("🆔 Documento: " + documento);
        System.out.println("📞 Teléfono: " + telefono);
    }

    /**
     * Muestra el historial de todas las mascotas asociadas.
     */
    public void mostrarMascotas() {
        for (Mascota m : mascotas) {
            System.out.println();
            m.mostrarHistorial();
        }
    }

    /**
     * Conveniencia: muestra toda la ficha clínica completa.
     */
    public void mostrarInformacionCompleta() {
        System.out.println("===== FICHA CLÍNICA =====");
        mostrarInformacion();
        mostrarMascotas();
    }

    // Getters y Setters refactorizados

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        if (documento == null || documento.length() < 5) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
        return new ArrayList<>(mascotas);
    }
}