import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS
{
    private Graph g;
    private Map<String, String> edgeTo;
    private Set<String> marked;
    private String start;

    public DFS(Graph g, String start) {
        this.g = g;
        this.start = start;
        edgeTo = new HashMap<>();
        marked = new HashSet<>();
        edgeTo.put(start, null);
        dfs(start);
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

    private void dfs(String v)
    {
        System.out.println("Entrando em "+v);
        // Marca como visitado
        marked.add(v);
        for(String w: g.getAdj(v)) {
            // Visita se não estiver marcado
            if(!marked.contains(w)) {
                // Armazena que para chegar em w viemos de v
                edgeTo.put(w, v);
                dfs(w);
            }
            else
                System.out.println("  >>> Já visitei "+w);
        }
        System.out.println("Saindo de "+v);
    }
}