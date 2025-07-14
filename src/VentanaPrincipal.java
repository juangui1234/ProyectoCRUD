import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane desktopPane;
    private CrudMascotas crudMascotas;

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión Clínica Veterinaria");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        crudMascotas = new CrudMascotas(); // Instancia central del CRUD
        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        crearMenu();
    }

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = getJMenu();

        // Menú Vista
        JMenu menuVista = new JMenu("Vista");

        JMenuItem itemPacientes = new JMenuItem("Pacientes");
        itemPacientes.addActionListener(_ -> {
            ListaPacientes lista = new ListaPacientes(crudMascotas);
            desktopPane.add(lista);
            lista.setVisible(true);
        });

        JMenuItem itemConsulta = new JMenuItem("Consulta");
        itemConsulta.addActionListener(_ -> {
            PanelConsulta panel = new PanelConsulta(crudMascotas);
            desktopPane.add(panel);
            panel.setVisible(true);
        });

        menuVista.add(itemPacientes);
        menuVista.add(itemConsulta);

        menuBar.add(menuArchivo);
        menuBar.add(menuVista);

        setJMenuBar(menuBar);
    }

    private JMenu getJMenu() {
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem itemNuevo = new JMenuItem("Nuevo registro");
        itemNuevo.addActionListener(_ -> {
            FormularioPaciente form = new FormularioPaciente(crudMascotas);
            desktopPane.add(form);
            form.setVisible(true);
        });

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(_ -> System.exit(0));

        menuArchivo.add(itemNuevo);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);
        return menuArchivo;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}