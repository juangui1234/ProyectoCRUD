import javax.swing.*;
import java.awt.*;

public class FormularioPaciente extends JInternalFrame {

    private CrudMascotas crudMascotas;

    public FormularioPaciente(CrudMascotas crudMascotas) {
        super("Formulario de paciente", true, true, true, true);
        this.crudMascotas = crudMascotas;

        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblClave = new JLabel("Clave del historial:");
        JPasswordField txtClave = new JPasswordField();

        JLabel lblEspecie = new JLabel("Especie:");
        JComboBox<String> cbEspecie = new JComboBox<>(new String[]{"Perro", "Gato", "Ave", "Otro"});

        JLabel lblEdad = new JLabel("Edad:");
        JSpinner spEdad = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));

        JButton btnRegistrar = new JButton("Registrar");

        btnRegistrar.addActionListener(_ -> {
            String nombre = txtNombre.getText().trim();
            String especie = cbEspecie.getSelectedItem().toString();
            int edad = (int) spEdad.getValue();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre obligatorio");
                return;
            }

            try {
                Mascota mascota = new Mascota(nombre, especie, edad);
                crudMascotas.getMascotas().add(mascota);  // 🔗 Agrega a la lista global
                JOptionPane.showMessageDialog(this, "Mascota registrada con éxito.");
                dispose();  // Cierra el formulario
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Agregar componentes al formulario
        add(lblNombre);
        add(txtNombre);
        add(lblClave);
        add(txtClave);  // clave no se usa aún, la podemos omitir si prefieres
        add(lblEspecie);
        add(cbEspecie);
        add(lblEdad);
        add(spEdad);
        add(new JLabel());  // espacio vacío
        add(btnRegistrar);
    }
}