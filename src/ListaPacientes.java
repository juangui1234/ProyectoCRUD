import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaPacientes extends JInternalFrame {

    private CrudMascotas crudMascotas;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JProgressBar barraCarga;

    public ListaPacientes(CrudMascotas crudMascotas) {
        super("Lista de pacientes", true, true, true, true);
        this.crudMascotas = crudMascotas;

        setSize(600, 400);
        setLayout(new BorderLayout());
        setClosable(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        modelo = new DefaultTableModel(new String[]{"Nombre", "Especie", "Edad"}, 0);
        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        barraCarga = new JProgressBar(0, 100);
        barraCarga.setStringPainted(true);
        add(barraCarga, BorderLayout.SOUTH);

        cargarDatosConSimulacion();
    }

    private void cargarDatosConSimulacion() {
        modelo.setRowCount(0); // Limpia la tabla

        Timer timer = new Timer(30, null); // 30 ms por ciclo
        final int[] progreso = {0};
        timer.addActionListener(e -> {
            if (progreso[0] >= 100) {
                ((Timer) e.getSource()).stop();
                llenarTabla();
            } else {
                progreso[0] += 5;
                barraCarga.setValue(progreso[0]);
            }
        });
        timer.start();
    }

    private void llenarTabla() {
        List<Mascota> lista = crudMascotas.getMascotas();
        for (Mascota m : lista) {
            modelo.addRow(new Object[]{
                    m.getNombre(),
                    m.getEspecie(),
                    m.getEdad()
            });
        }
        barraCarga.setValue(100);
        barraCarga.setString("Datos cargados");
    }
}