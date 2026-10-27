import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CicloNaoDirigido
{
    private Graph g;
    private Map<String, String> edgeTo;
    private Set<String> marked;
    private boolean temCiclo;

    public CicloNaoDirigido(Graph g) {
        this.g = g;
        temCiclo = false;
        edgeTo = new HashMap<>();
        marked = new HashSet<>();
        // Descomente para processar os vértices em ordem alfabética:
        // ArrayList<String> ordenados = new ArrayList<>();
        // for(String s: g.getVerts())
           // ordenados.add(s);
        // Collections.sort(ordenados);
        // for(String s: ordenados) {

        for(String s: g.getVerts()) {
            if(!marked.contains(s)) {
                if(dfs(s)) {
                    temCiclo = true;
                    return;
                }
            }
        }
    }

    public boolean hasCycle() {
        return temCiclo;
    }

    private boolean dfs(String v)
    {
        System.out.println("Entrando em "+v);
        // Marca como visitado
        marked.add(v);
        for(String w: g.getAdj(v)) {
            // Visita se não estiver marcado
            if(!marked.contains(w)) {
                // Armazena que para chegar em w viemos de v
                edgeTo.put(w, v);
                if(dfs(w))
                    return true;
            }
            else if(!w.equals(edgeTo.get(v))) {
                System.out.println("  >>> Ciclo encontrado em "+w);
                return true;
            }
        }
        System.out.println("Saindo de "+v);
        // Não encontrou ciclo
        return false;
    }
}