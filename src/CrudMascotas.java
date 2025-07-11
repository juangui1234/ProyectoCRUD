import java.util.ArrayList;

public class CrudMascotas {

    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        if (mascota != null) {
            mascotas.add(mascota);
        }
    }

    public Mascota buscarPorNombre(String nombre) {
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    public void limpiarMascotas() {
        mascotas.clear();
    }
}