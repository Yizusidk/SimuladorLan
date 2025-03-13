import java.util.ArrayList;
import javax.swing.JTextArea;

class Red {
    private String topologia;
    private ArrayList<Nodo> nodos;
    private int tamanoPaquete;
    
    public Red() {
        this.nodos = new ArrayList<>();
    }
    
    public void setTopologia(String topologia) {
        this.topologia = topologia;
    }
    
    public void agregarNodo(String nombre) {
        nodos.add(new Nodo(nombre));
    }
    
    public void eliminarNodo(String nombre) {
        nodos.removeIf(nodo -> nodo.getNombre().equals(nombre));
    }
    
    public void listarNodos(JTextArea area) {
        area.setText("");
        for (Nodo nodo : nodos) {
            area.append(nodo.getNombre() + "\n");
        }
    }
    
    public void setTamanoPaquete(int tamano) {
        this.tamanoPaquete = tamano;
    }
    
    public void enviarPaquete(String origen, String destino, JTextArea area) {
        area.append("Enviando paquete de " + origen + " a " + destino + " con tamaño " + tamanoPaquete + " bytes.\n");
    }
    
    public void difundirPaquete(String origen, JTextArea area) {
        area.append("Difundiendo paquete desde " + origen + " a todos los nodos.\n");
    }
}
