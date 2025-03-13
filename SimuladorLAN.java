import java.awt.*;
import javax.swing.*;

public class SimuladorLAN extends JFrame {
    private Red red;
    private JTextArea textArea;
    private JComboBox<String> topologiaBox;
    
    public SimuladorLAN() {
        red = new Red();
        setTitle("Simulador de Red LAN");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelConfig = new JPanel();
        panelConfig.setLayout(new GridLayout(3, 2));
        
        topologiaBox = new JComboBox<>(new String[]{"Bus", "Estrella", "Hub", "Anillo"});
        JButton btnConfigurar = new JButton("Configurar Red");
        JTextField nodoField = new JTextField();
        JButton btnAgregar = new JButton("Agregar Nodo");
        JButton btnEliminar = new JButton("Eliminar Nodo");
        JButton btnListar = new JButton("Listar Nodos");
        
        panelConfig.add(new JLabel("Topología:"));
        panelConfig.add(topologiaBox);
        panelConfig.add(btnConfigurar);
        panelConfig.add(new JLabel("Nombre Nodo:"));
        panelConfig.add(nodoField);
        panelConfig.add(btnAgregar);
        panelConfig.add(btnEliminar);
        panelConfig.add(btnListar);
        
        add(panelConfig, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new GridLayout(2, 2));
        
        JTextField tamanoField = new JTextField();
        JButton btnSetTamano = new JButton("Asignar Tamaño Paquete");
        JButton btnEnviar = new JButton("Enviar Paquete");
        JButton btnDifundir = new JButton("Difundir Paquete");
        
        panelAcciones.add(new JLabel("Tamaño Paquete (Bytes):"));
        panelAcciones.add(tamanoField);
        panelAcciones.add(btnSetTamano);
        panelAcciones.add(btnEnviar);
        panelAcciones.add(btnDifundir);
        
        add(panelAcciones, BorderLayout.SOUTH);

        btnConfigurar.addActionListener(e -> {
            red.setTopologia((String) topologiaBox.getSelectedItem());
            textArea.append("Topología configurada: " + topologiaBox.getSelectedItem() + "\n");
        });
        
        btnAgregar.addActionListener(e -> {
            red.agregarNodo(nodoField.getText());
            textArea.append("Nodo agregado: " + nodoField.getText() + "\n");
        });
        
        btnEliminar.addActionListener(e -> {
            red.eliminarNodo(nodoField.getText());
            textArea.append("Nodo eliminado: " + nodoField.getText() + "\n");
        });
        
        btnListar.addActionListener(e -> red.listarNodos(textArea));
        
        btnSetTamano.addActionListener(e -> {
            int tamano = Integer.parseInt(tamanoField.getText());
            red.setTamanoPaquete(tamano);
            textArea.append("Tamaño de paquete configurado: " + tamano + " bytes\n");
        });
        
        btnEnviar.addActionListener(e -> {
            String origen = JOptionPane.showInputDialog("Ingrese nodo origen:");
            String destino = JOptionPane.showInputDialog("Ingrese nodo destino:");
            red.enviarPaquete(origen, destino, textArea);
        });
        
        btnDifundir.addActionListener(e -> {
            String origen = JOptionPane.showInputDialog("Ingrese nodo origen:");
            red.difundirPaquete(origen, textArea);
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimuladorLAN().setVisible(true));
    }
}
