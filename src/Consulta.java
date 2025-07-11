import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Consulta {
    private String codigo;
    // private String fecha; // original
    private LocalDate fecha; // ✅ Refactor: usar LocalDate
    private Veterinario veterinario;

    public Consulta(String codigo, String fechaTexto, Veterinario veterinario) {
        /* Código original:
        this.codigo = codigo;
        this.fecha = fechaTexto;
        this.veterinario = veterinario;
        */
        // ✅ Refactor: uso de setters con validación y conversión de fecha
        setCodigo(codigo);
        setFecha(fechaTexto);
        setVeterinario(veterinario);
    }

    public void mostrarConsulta() {
        System.out.println("Consulta Código: " + codigo);
        System.out.println("Fecha: " + fecha);
        if (veterinario != null) {
            veterinario.mostrarPerfil();
        } else {
            System.out.println("Sin veterinario asignado.");
        }
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido (YYYY-MM-DD).", e);
        }
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinario requerido.");
        }
        this.veterinario = veterinario;
    }
}
