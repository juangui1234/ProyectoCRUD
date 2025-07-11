import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class PanelConsulta extends JInternalFrame {

    private CrudMascotas crudMascotas;
    private JTextArea areaResultado;

    public PanelConsulta(CrudMascotas crudMascotas) {
        super("Consulta y Servicios", true, true, true, true);
        this.crudMascotas = crudMascotas;

        setSize(700, 400);
        setLayout(new BorderLayout());
        setClosable(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // Panel izquierdo con JTree
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Servicios");
        raiz.add(new DefaultMutableTreeNode("Medicina general"));
        raiz.add(new DefaultMutableTreeNode("Cirugía"));
        raiz.add(new DefaultMutableTreeNode("Vacunación"));
        raiz.add(new DefaultMutableTreeNode("Peluquería"));
        raiz.add(new DefaultMutableTreeNode("Urgencias"));

        JTree arbolServicios = new JTree(new DefaultTreeModel(raiz));
        JScrollPane scrollArbol = new JScrollPane(arbolServicios);
        scrollArbol.setPreferredSize(new Dimension(200, getHeight()));
        add(scrollArbol, BorderLayout.WEST);

        // Panel central con búsqueda y resultados
        JPanel panelCentral = new JPanel(new BorderLayout());

        JPanel panelBusqueda = new JPanel();
        JLabel lblNombre = new JLabel("Buscar mascota por nombre:");
        JTextField txtNombre = new JTextField(15);
        JButton btnBuscar = new JButton("Buscar");

        panelBusqueda.add(lblNombre);
        panelBusqueda.add(txtNombre);
        panelBusqueda.add(btnBuscar);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollTexto = new JScrollPane(areaResultado);

        panelCentral.add(panelBusqueda, BorderLayout.NORTH);
        panelCentral.add(scrollTexto, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        // Acción del botón buscar
        btnBuscar.addActionListener(e -> {
            String nombreBuscado = txtNombre.getText().trim();
            if (nombreBuscado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escribe el nombre de la mascota.");
                return;
            }

            Mascota mascota = crudMascotas.buscarPorNombre(nombreBuscado);
            if (mascota != null) {
                areaResultado.setText(""); // Limpiar
                areaResultado.append("Ficha de la mascota:\n\n");
                areaResultado.append("Nombre: " + mascota.getNombre() + "\n");
                areaResultado.append("Especie: " + mascota.getEspecie() + "\n");
                areaResultado.append("Edad: " + mascota.getEdad() + "\n");
                areaResultado.append("\nConsultas:\n");

               /* if (mascota.getHistorial().getConsultas().isEmpty()) {
                    areaResultado.append("- Sin consultas registradas\n");
                } else {
                    for (Consulta c : mascota.getHistorial().getConsultas()) {
                        areaResultado.append("  Código: " + c.getCodigo() + "\n");
                        areaResultado.append("  Fecha: " + c.getFecha() + "\n");
                        areaResultado.append("  Veterinario: " + c.getVeterinario().getNombre() + " - " + c.getVeterinario().getEspecialidad() + "\n");
                        areaResultado.append("-------------------------------\n");
                    }
                }
*/
            } else {
                areaResultado.setText("❌ Mascota no encontrada.");
            }
        });
    }
}