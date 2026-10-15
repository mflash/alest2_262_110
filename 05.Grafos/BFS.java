import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS
{
    private Graph g;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private Set<String> marked;
    private String start;

    public BFS(Graph g, String start) {
        this.g = g;
        this.start = start;
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        marked = new HashSet<>();
        bfs(start);
    }

    public boolean hasPathTo(String v) {
        return marked.contains(v);
        // if(marked.contains(v))
            // return true;
        // else
            // return false;
    }

    public List<String> pathTo(String v) {
        ArrayList<String> path = new ArrayList<>();
        // Enquanto houver um antecessor...
        while(v != null) {
            // Insere no início da lista para inverter o resultado
            path.add(0, v);
            v = edgeTo.get(v);
        }
        return path;
    }

    private void bfs(String v)
    {
        // Inicializa uma fila de vértices (dica: use LinkedList)
        // Adiciona primeiro vértice na fila (v)
        // Marca v como visitado
        marked.add(v);
        // Registra que não há ninguém antes dele
        edgeTo.put(start, null);
        // Seta a distância até v como 0
        distTo.put(start, 0); // distância da origem até ela mesma = 0

        // Enquanto a fila não estiver vazia:
        // - Retira o primeiro vértice da fila
        // - Marca ele
        // - Para cada vizinho não marcado:
        //   - Ajusta edgeTo
        //   - Ajusta distTo
        //   - Insere o vizinho na fila 
    }
}